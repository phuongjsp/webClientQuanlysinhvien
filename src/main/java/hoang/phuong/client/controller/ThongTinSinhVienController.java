package hoang.phuong.client.controller;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "thongtinsinhvien")
public class ThongTinSinhVienController {
    @Autowired
    private ThongTinSinhVienService ttsvService;
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
        model.addAttribute("thongtinsinhvien", thongTinSinhVienService.listOrderBy(listCall, 0, 0));
        return "thongtinsinhvien/index";
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
