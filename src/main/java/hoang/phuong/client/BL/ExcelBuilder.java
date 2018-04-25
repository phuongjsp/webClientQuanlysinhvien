package hoang.phuong.client.BL;

import hoang.phuong.client.model.Diachi;
import hoang.phuong.client.model.Thongtinsinhvien;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

public class ExcelBuilder extends AbstractExcelView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model,
                                      HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // get data model which is passed by the Spring container
        List<Thongtinsinhvien> thongtinsinhvienList = (List<Thongtinsinhvien>) model.get("listTTSV");

        // create a new Excel sheet
        HSSFSheet sheet = workbook.createSheet("Thong tin sinh vien");
        sheet.setDefaultColumnWidth(30);

        // create style for header cells
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.BLUE.index);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);
        // create header row
        HSSFRow header = sheet.createRow(0);

        header.createCell(0).setCellValue("Mã Sv");
        header.getCell(0).setCellStyle(style);

        header.createCell(1).setCellValue("Ngày vào học");
        header.getCell(1).setCellStyle(style);

        header.createCell(2).setCellValue("Họ");
        header.getCell(2).setCellStyle(style);

        header.createCell(3).setCellValue("Tên");
        header.getCell(3).setCellStyle(style);

        header.createCell(4).setCellValue("Dân tộc");
        header.getCell(4).setCellStyle(style);

        header.createCell(5).setCellValue("Giới tính");
        header.getCell(5).setCellStyle(style);

        header.createCell(6).setCellValue("Ngày Sinh");
        header.getCell(6).setCellStyle(style);

        header.createCell(7).setCellValue("Nơi sinh");
        header.getCell(7).setCellStyle(style);

        header.createCell(8).setCellValue("Hộ Khẩu Thường Chú");
        header.getCell(8).setCellStyle(style);

        header.createCell(9).setCellValue("Lớp");
        header.getCell(9).setCellStyle(style);

        header.createCell(10).setCellValue("Khóa");
        header.getCell(10).setCellStyle(style);

        header.createCell(11).setCellValue("Ngành");
        header.getCell(11).setCellStyle(style);

        header.createCell(12).setCellValue("Link Ảnh thẻ");
        header.getCell(12).setCellStyle(style);

        // create data rows
        int rowCount = 1;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        for (Thongtinsinhvien thongtinsinhvien : thongtinsinhvienList) {
            HSSFRow aRow = sheet.createRow(rowCount++);
            aRow.createCell(0).setCellValue(thongtinsinhvien.getMaSv());
            if (thongtinsinhvien.getNgayVaoHoc() != null)
                aRow.createCell(1).setCellValue(sdf.format(thongtinsinhvien.getNgayVaoHoc()));
            aRow.createCell(2).setCellValue(thongtinsinhvien.getHo());
            aRow.createCell(3).setCellValue(thongtinsinhvien.getTen());
            aRow.createCell(4).setCellValue(thongtinsinhvien.getDanToc());
            aRow.createCell(5).setCellValue(thongtinsinhvien.getGioiTinh() == 1 ? "Nam" : "Nữ");
            if (thongtinsinhvien.getNgaySinh() != null)
                aRow.createCell(6).setCellValue(sdf.format(thongtinsinhvien.getNgaySinh()));
            Diachi dcByns = thongtinsinhvien.getDiachiByNoiSinh();
            String dcns = dcByns.getTinh();
            if (dcByns.getQuanHuyen() != null) dcns += " - " + dcByns.getQuanHuyen();
            if (dcByns.getXaPhuong() != null) dcns += " - " + dcByns.getXaPhuong();
            if (dcByns.getThonXom() != null) dcns += " - " + dcByns.getThonXom();
            Diachi dcByhk = thongtinsinhvien.getDiachiByHoKhauThuongChu();
            String dchk = dcByhk.getTinh();
            if (dcByhk.getQuanHuyen() != null) dchk += " - " + dcByhk.getQuanHuyen();
            if (dcByhk.getXaPhuong() != null) dchk += " - " + dcByhk.getXaPhuong();
            if (dcByhk.getThonXom() != null) dchk += " - " + dcByhk.getThonXom();
            aRow.createCell(7).setCellValue(dcns);
            aRow.createCell(8).setCellValue(dchk);
            if (thongtinsinhvien.getLopsvByLop() != null)
                aRow.createCell(9).setCellValue(thongtinsinhvien.getLopsvByLop().getTenLop());
            if (thongtinsinhvien.getKhoaByKhoaHoc() != null)
                aRow.createCell(10).setCellValue(thongtinsinhvien.getKhoaByKhoaHoc().getTenKhoa());
            if (thongtinsinhvien.getNganhdaotaoByNganhDk() != null)
                aRow.createCell(11).setCellValue(thongtinsinhvien.getNganhdaotaoByNganhDk().getTenNganh());
            if (thongtinsinhvien.getAnhThe() != null)
                aRow.createCell(12).setCellValue(thongtinsinhvien.getAnhThe());
        }
    }

}