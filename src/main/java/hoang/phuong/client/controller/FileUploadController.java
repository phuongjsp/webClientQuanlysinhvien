package hoang.phuong.client.controller;

import hoang.phuong.client.model.Diachi;
import hoang.phuong.client.model.Thongtinsinhvien;
import hoang.phuong.client.service.DiaChiService;
import hoang.phuong.client.service.ThongTinSinhVienService;
import hoang.phuong.client.service.ThongTinThemService;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(path = "test")
public class FileUploadController {
    @Autowired
    private DiaChiService diaChiService;
    @Autowired
    private ThongTinSinhVienService thongTinSinhVienService;
    @Autowired
    private ThongTinThemService thongTinThemService;

    @GetMapping("/")
    public String fileUploadForm(Model model) {

        try {

            FileInputStream excelFile = new FileInputStream(new File("D:/SingleFileUpload/ttsv.xlsx"));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            List<Map<String, String>> list = new ArrayList<>();
            Iterator<Row> iterator = datatypeSheet.iterator();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sdfsql = new SimpleDateFormat("yyyy-MM-dd");
            datatypeSheet.forEach(cells -> {
                Map<String, String> map = new HashMap<>();
                cells.forEach(cell -> {
                    if (cells.getRowNum() > 0 && cell.getCellTypeEnum() != CellType.BLANK) {

                        switch (cell.getColumnIndex()) {
                            case 0:
                                map.put("khoaHoc", "9");
                                map.put("maSv", cell.getStringCellValue());
                                break;
                            case 1:
                                map.put("ho", cell.getStringCellValue());
                                break;
                            case 2:
                                map.put("ten", cell.getStringCellValue());
                                break;
                            case 3:
                                Diachi dc = new Diachi();
                                dc.setTinh(cell.getStringCellValue());
                                Diachi dcr = diaChiService.saveDiaChi(dc);
                                map.put("noiSinh", dcr.getId().toString());
                                break;
                            case 4:
                                try {
                                    map.put("ngaySinh",
                                            sdfsql.format(sdf.parse(cell.getStringCellValue())));
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 5:
                                String diaChi = cell.getStringCellValue();
                                String[] strc = diaChi.split(" - ");
                                Diachi dchi = new Diachi();
                                dchi.setThonXom(strc[0]);
                                dchi.setXaPhuong(strc[1]);
                                dchi.setQuanHuyen(strc[2]);
                                dchi.setTinh(strc[3]);
                                Diachi dchk = diaChiService.saveDiaChi(dchi);
                                map.put("hoKhauThuongChu", dchk.getId().toString());
                            case 6:
                                map.put("gioiTinh", cell.getStringCellValue().equals("Nam") ? "1" : "0");
                                break;
                            case 7:
                                map.put("danToc", cell.getStringCellValue());
                                break;
                        }
                    }
                });
                if (cells.getRowNum() > 0 && cells.getCell(0).getCellTypeEnum() != CellType.BLANK) list.add(map);

            });
            list.forEach(System.out::println);
            list.forEach(stringObjectMap -> {
                thongTinSinhVienService.saveTT(stringObjectMap);
            });


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Map<String, Object>> listCall = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("order", "desc");
        map.put("property", "id");
        List<Thongtinsinhvien> lstr = thongTinSinhVienService.listOrderBy(listCall, 0, 0);
        lstr.forEach(System.out::println);
        model.addAttribute("listTTT", thongTinThemService.list());
        model.addAttribute("thongtinsinhvien", lstr);
        return "thongtinsinhvien/index";
    }

    // Handling single file upload request
    @PostMapping("/singleFileUpload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file, Model model)
            throws IOException {

        // Save file on system
        if (!file.getOriginalFilename().isEmpty()) {
            BufferedOutputStream outputStream = new BufferedOutputStream(
                    new FileOutputStream(
                            new File("D:/SingleFileUpload", file.getOriginalFilename())));
            outputStream.write(file.getBytes());
            outputStream.flush();
            outputStream.close();
//            apachePOIExcelRead.ReadExel("D:/SingleFileUpload/"+file.getOriginalFilename());
            model.addAttribute("msg", "File uploaded successfully.");
        } else {
            model.addAttribute("msg", "Please select a valid file..");
        }

        return "fileUploadForm";
    }

    // Handling multiple files upload request
    @PostMapping("/multipleFileUpload")
    public String multipleFileUpload(@RequestParam("file") MultipartFile[] files,
                                     Model model) throws IOException {

        // Save file on system
        for (MultipartFile file : files) {
            if (!file.getOriginalFilename().isEmpty()) {
                BufferedOutputStream outputStream = new BufferedOutputStream(
                        new FileOutputStream(
                                new File("D:/MultipleFileUpload", file.getOriginalFilename())));

                outputStream.write(file.getBytes());
                outputStream.flush();
                outputStream.close();
            } else {
                model.addAttribute("msg", "Please select at least one file..");
                return "fileUploadForm";
            }
        }
        model.addAttribute("msg", "Multiple files uploaded successfully.");
        return "fileUploadForm";
    }
}
