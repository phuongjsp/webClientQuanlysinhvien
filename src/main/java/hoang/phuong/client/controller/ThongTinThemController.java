package hoang.phuong.client.controller;

import hoang.phuong.client.model.Thongtinthem;
import hoang.phuong.client.service.ThongTinSinhVienService;
import hoang.phuong.client.service.ThongTinThemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "thongtinthem")
public class ThongTinThemController {
    @Autowired
    private ThongTinThemService thongTinThemService;
    @Autowired
    private ThongTinSinhVienService thongTinSinhVienService;

    @RequestMapping(path = {"/add"}, method = RequestMethod.GET)
    public String addKhoa(Model model) {
        Thongtinthem thongtinthem = new Thongtinthem();
        model.addAttribute("thongtinthem", thongtinthem);
        return "thongtinthem/formAddTTT";
    }

    //TODO update path = "/add/MaSv/{maSv}
    @RequestMapping(path = {"/add"}, method = RequestMethod.POST)
    public String addSuccess(Model model, @ModelAttribute("thongtinthem") @Validated Thongtinthem thongtinthem) {
        thongTinThemService.saveTTT(thongtinthem);
        return "redirect:/thongtinthem/";
    }

    //TODO delete this method
    @RequestMapping(path = {""}, method = RequestMethod.GET)
    public String sayHello(Model model) {
        model.addAttribute("thongtinthem", thongTinThemService.list());
        return "thongtinthem/index";
    }

    @RequestMapping(path = {"/del/{maSv}-{id}"}, method = RequestMethod.GET)
    public String del(Model model, @PathVariable("id") int id, @PathVariable("maSv") String maSv) {
        thongTinThemService.deleteTTT(id);
        return "redirect:/thongtinthem/maSv/" + maSv;
    }

    @RequestMapping(path = {"/update/{maSv}-{id}"}, method = RequestMethod.GET)
    public String update(Model model, @PathVariable("id") int id) {
        model.addAttribute("thongtinthem", thongTinThemService.getbyId(id));
        return "thongtinthem/formAddTTT";
    }

    @RequestMapping(path = {"/update/{maSv}-{id}"}, method = RequestMethod.POST)
    public String updateSuccess(@PathVariable("maSv") String maSv, @ModelAttribute("thongtinthem") @Validated Thongtinthem thongtinthem) {
        thongTinThemService.updateTTT(thongtinthem);
        return "redirect:/thongtinthem/maSv/" + maSv;
    }

    @RequestMapping(path = {"/maSv/{maSv}"}, method = RequestMethod.GET)
    public String getByMaSv(Model model, @PathVariable("maSv") String maSv) {
        model.addAttribute("thongtinthem", thongTinThemService.listByMaSv(maSv));
        return "thongtinthem/index";
    }
}
