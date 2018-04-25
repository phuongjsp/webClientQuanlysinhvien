package hoang.phuong.client.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import hoang.phuong.client.BL.ExcelBuilder;
import hoang.phuong.client.model.Diachi;
import hoang.phuong.client.model.Thongtinsinhvien;
import hoang.phuong.client.service.KhoaService;
import hoang.phuong.client.service.LopService;
import hoang.phuong.client.service.NganhDaoTaoService;
import hoang.phuong.client.service.ThongTinSinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "thongtinsinhvien")
public class ThongTinSinhVienController extends ExceptionHandlerController {

    @Autowired
    private NganhDaoTaoService nganhDaoTaoService;
    @Autowired
    private KhoaService khoaService;
    @Autowired
    private LopService lopService;
    @Autowired
    private ThongTinSinhVienService thongTinSinhVienService;
    @RequestMapping(path = {"/add"}, method = RequestMethod.GET)
    public String addKhoa(Model model) {
        Diachi diachi = new Diachi();
        model.addAttribute("diachi", diachi);
        model.addAttribute("nganhdaotao", nganhDaoTaoService.listNganhDT());
        model.addAttribute("khoahoc", khoaService.getListKhoa());
        model.addAttribute("lopsv", lopService.listLop());
        model.addAttribute("thongtinsinhvien", new Thongtinsinhvien());
        return "thongtinsinhvien/formAddTTSV";
    }

    @RequestMapping(path = {"/add"}, method = RequestMethod.POST)
    public String addSuccess(@RequestParam Map<String, String> map) {
        thongTinSinhVienService.saveTT(map);
        return "redirect:/thongtinsinhvien/";
    }

    @RequestMapping(path = {"/update/{maSv}"}, method = RequestMethod.GET)
    public String updateKhoa(Model model, @PathVariable("maSv") String maSv) {
        Thongtinsinhvien thongtinsinhvien = thongTinSinhVienService.getByMaSv(maSv);
        Diachi diachi = new Diachi();
        model.addAttribute("diachi", diachi);
        model.addAttribute("nganhdaotao", nganhDaoTaoService.listNganhDT());
        model.addAttribute("khoahoc", khoaService.getListKhoa());
        model.addAttribute("lopsv", lopService.listLop());
        model.addAttribute("thongtinsinhvien", thongtinsinhvien);
        return "thongtinsinhvien/formAddTTSV";
    }

    @RequestMapping(path = {"/update/{maSv}"}, method = RequestMethod.POST)
    public String updateTTSVSuccess(@RequestParam Map<String, String> map) {
        thongTinSinhVienService.updateTT(map);
        return "redirect:/thongtinsinhvien/";
    }

    @RequestMapping(path = {"/del/{maSv}"}, method = RequestMethod.GET)
    public String deleteTTSV(Model model, @PathVariable("maSv") String maSv) {
        thongTinSinhVienService.deleteByMaSv(maSv);
        return "redirect:/thongtinsinhvien/";
    }

    //


    /*
    *
    {
        "property": "ten",
        "type": "eq",
        "value": "nhu"
    },
    {
        "property": "maSv",
        "order": "desc"
    }
    * */
    @RequestMapping(path = {"/maSv/{maSv}"}, method = RequestMethod.GET)
    public String getOnly(Model model, @PathVariable("maSv") String maSv) {
        List<Thongtinsinhvien> lstTTSV = new ArrayList<>();
        Thongtinsinhvien thongtinsinhvien = thongTinSinhVienService.getByMaSv(maSv);
        lstTTSV.add(thongtinsinhvien);
        model.addAttribute("thongtinsinhvien", lstTTSV);
        model.addAttribute("model", "only");
        return "thongtinsinhvien/index";
    }

    @RequestMapping(path = {""}, method = RequestMethod.GET)
    public String doGet(Model model) {
        List<String> listProperties = new ArrayList<>();
        List<String> listSX = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        listProperties.add("maSv");
        map.put("maSv", "Mã Sinh Viên");
        listProperties.add("ho");
        map.put("ho", "Họ");
        listProperties.add("ten");
        map.put("ten", "Tên");
        listProperties.add("danToc");
        map.put("danToc", "Dân Tộc");
        listProperties.add("gioiTinh");
        map.put("gioiTinh", "Giới Tính");
        listProperties.add("khoaHoc");
        map.put("khoaHoc", "Khóa Học");
        listProperties.add("lop");
        map.put("lop", "Lớp");
        listProperties.add("nganhDk");
        map.put("nganhDk", "Ngành Đào Tạo");
        listProperties.add("HoKhauThuongChu");
        map.put("HoKhauThuongChu", "Hộ Khẩu thường chú");
        listProperties.add("NoiSinh");
        map.put("NoiSinh", "Nơi sinh");
        listProperties.add("ngayVaoHoc");
        map.put("ngayVaoHoc", "Ngày Vào Học");
        listProperties.add("ngaySinh");
        map.put("ngaySinh", "Ngày Sinh");

        listSX.add("maSv");
        listSX.add("ho");
        listSX.add("ten");
        listSX.add("danToc");
        listSX.add("gioiTinh");
        listSX.add("ngayVaoHoc");
        listSX.add("ngaySinh");
        model.addAttribute("listSX", listSX);
        model.addAttribute("mapproperties", map);
        model.addAttribute("khoahoc", khoaService.getListKhoa());
        model.addAttribute("lopsv", lopService.listLop());
        lopService.listLop().forEach(System.out::println);
        model.addAttribute("nganhdt", nganhDaoTaoService.listNganhDT());
        model.addAttribute("properties", listProperties);
        return "thongtinsinhvien/formSearch";
    }

    @Autowired
    private ExcelBuilder excelBuilder;

    @RequestMapping(path = {""}, method = RequestMethod.POST)
    public String doPost(Model model, @RequestParam("list") String list) {
        if (list.length() == 0) {
            return "redirect:/thongtinsinhvien/";
        } else {
            model.addAttribute("listBy", list);
            model.addAttribute("thongtinsinhvien", thongTinSinhVienService.listOrderBy(listTByJsonString(list), 0, 0));
            return "thongtinsinhvien/index";
        }
    }

    private List<Map<String, Object>> listTByJsonString(String jsonString) {
        System.out.println(jsonString);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        try {
            Gson gson = new Gson();
            JsonArray arry = new JsonParser().parse(jsonString).getAsJsonArray();
            for (JsonElement jsonElement : arry) {
                list.add(gson.fromJson(jsonElement, (Type) Map.class));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        list.forEach(stringObjectMap -> {
            if (stringObjectMap.get("property") != null) if (stringObjectMap.get("property").equals("lop") ||
                    stringObjectMap.get("property").equals("nganhDk") ||
                    stringObjectMap.get("property").equals("khoaHoc") ||
                    stringObjectMap.get("property").equals("gioiTinh")) {
                if (stringObjectMap.get("value") != null)
                    stringObjectMap.replace("value", Integer.valueOf(stringObjectMap.get("value").toString()));
            }
        });
        return list;
    }

    @RequestMapping(value = "/download/Thongtinsinhvien", method = RequestMethod.POST)
    public ModelAndView downloadExcel(@RequestParam("list") String list) {
        List<Thongtinsinhvien> thongtinsinhvienList = thongTinSinhVienService.listOrderBy(listTByJsonString(list), 0, 0);
        // return a view which will be resolved by an excel view resolver
        return new ModelAndView(excelBuilder, "listTTSV", thongtinsinhvienList);
    }
//    @RequestMapping(path = {"/del/{maVanBang}"}, method = RequestMethod.GET)
//    public String del(Model model,@PathVariable("maVanBang") String maVanBang) {
//        vanBangService.deleteVanBang(maVanBang);
//        return "redirect:/vanbang/";
//    }
//    @RequestMapping(path = {"/update/{maVanBang}"}, method = RequestMethod.GET)
//    public String update(Model model,@PathVariable("maVanBang") String maVanBang) {
//        Vanbang vanbang = vanBangService.getByMaVanBang(maVanBang);
//        model.addAttribute("vanbang", vanbang);
//        return "vanbang/formAddVanBang";
//    }
//    @RequestMapping(path = {"/update/{maVanBang}"}, method = RequestMethod.POST)
//    public String updateSuccess(Model model, @ModelAttribute("vanbang") @Validated Vanbang vanbang) {
//        vanBangService.updateVangBang(vanbang);
//        return "redirect:/vanbang//";
//    }
//    @RequestMapping(path = {"/maVanBang/{maVanBang}"}, method = RequestMethod.GET)
//    public String getKhoa(Model model,@PathVariable("maVanBang") String maVanBang) {
//        List<Vanbang> lst = new ArrayList<>();
//        lst.add(vanBangService.getByMaVanBang(maVanBang));
//        model.addAttribute("vanbang", lst);
//        model.addAttribute("model","showOnly");
//        return "vanbang/index";
//    }
}
