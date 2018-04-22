package hoang.phuong.client.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import hoang.phuong.client.model.Diachi;
import hoang.phuong.client.model.Thongtinsinhvien;
import hoang.phuong.client.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "thongtinsinhvien")
public class ThongTinSinhVienController {
    @Autowired
    private ThongtingiadinhService thongtingiadinhService;
    @Autowired
    private DiaChiService diaChiService;
    @Autowired
    private NganhDaoTaoService nganhDaoTaoService;
    @Autowired
    private KhoaService khoaService;
    @Autowired
    private LopService lopService;
    @Autowired
    private ThongTinSinhVienService thongTinSinhVienService;
    @Autowired
    private ThongTinThemService thongTinThemService;
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
    @RequestMapping(path = {""}, method = RequestMethod.GET)
    public String sayHello(Model model) {
        List<Map<String, Object>> listCall = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("order", "desc");
        map.put("property", "id");
        listCall.add(map);

        List<Thongtinsinhvien> thongtinsinhvienList = new ArrayList<>();
        thongtinsinhvienList = thongTinSinhVienService.listOrderBy(listCall, 0, 0);
        model.addAttribute("diachi", diaChiService.listDiaChi());
        model.addAttribute("listTTT", thongTinThemService.list());
        model.addAttribute("thongtinsinhvien", thongtinsinhvienList);
        return "thongtinsinhvien/index";
    }

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
        List<Map<String, Object>> listCall = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("order", "desc");
        map.put("property", "id");
        Map<String, Object> map2 = new HashMap<>();
        map2.put("property", "maSv");
        map2.put("type", "eq");
        map2.put("value", maSv);
        listCall.add(map);
        List<Thongtinsinhvien> thongtinsinhvienList = new ArrayList<>();
        thongtinsinhvienList = thongTinSinhVienService.listOrderBy(listCall, 0, 0);
        model.addAttribute("listTTT", thongTinThemService.listByMaSv(maSv));
        model.addAttribute("listTTGD", thongtingiadinhService.listByIdSv(thongTinSinhVienService.getByMaSv(maSv).getId()));
        model.addAttribute("thongtinsinhvien", thongtinsinhvienList);
        model.addAttribute("model", "only");
        return "thongtinsinhvien/index";
    }

    @RequestMapping(path = {"search"}, method = RequestMethod.GET)
    public String doGet(Model model) {
        List<String> listProperties = new ArrayList<>();
        //String : eq,like
        listProperties.add("maSv");
        listProperties.add("ho");
        listProperties.add("ten");
        listProperties.add("danToc");
        //eq
        listProperties.add("gioiTinh");
        listProperties.add("khoaHoc");
        listProperties.add("lop");
        listProperties.add("nganhDk");
        //can tim 1 phuong phap moi

        listProperties.add("HoKhauThuongChu");
        listProperties.add("NoiSinh");
//      eq beetwen
        listProperties.add("ngayVaoHoc");
        listProperties.add("ngaySinh");
        model.addAttribute("khoahoc", khoaService.getListKhoa());
        model.addAttribute("lopsv", lopService.listLop());
        lopService.listLop().forEach(System.out::println);
        model.addAttribute("nganhdt", nganhDaoTaoService.listNganhDT());
        model.addAttribute("properties", listProperties);
        return "thongtinsinhvien/formSearch";
    }

    @RequestMapping(path = {"search"}, method = RequestMethod.POST)
    public String doPost(Model model, @RequestParam("list") String list) {
        List<Map<String, Object>> lst = new ArrayList<>();
        lst = listTByJsonString(list);
        lst.forEach(stringObjectMap -> {
            if (stringObjectMap.get("property").equals("lop") ||
                    stringObjectMap.get("property").equals("nganhDk") ||
                    stringObjectMap.get("property").equals("khoaHoc")) {
                if (stringObjectMap.get("value") != null)
                    stringObjectMap.replace("value", Integer.valueOf(stringObjectMap.get("value").toString()));
            }
        });
        model.addAttribute("messages", list);
        model.addAttribute("thongtinsinhvien", thongTinSinhVienService.listOrderBy(lst, 0, 0));
        return "thongtinsinhvien/index";
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
        return list;
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
