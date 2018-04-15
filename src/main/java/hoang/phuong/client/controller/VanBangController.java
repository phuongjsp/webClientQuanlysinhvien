package hoang.phuong.client.controller;

import hoang.phuong.client.model.Vanbang;
import hoang.phuong.client.service.VanBangService;
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
@RequestMapping(path = "vanbang")
public class VanBangController {

    @Autowired
    private VanBangService vanBangService;

    @RequestMapping(path = {"/add"}, method = RequestMethod.GET)
    public String addKhoa(Model model) {
        Vanbang vanbang = new Vanbang();
        model.addAttribute("vanbang", vanbang);
        return "vanbang/formAddVanBang";
    }

    @RequestMapping(path = {"/add"}, method = RequestMethod.POST)
    public String addSuccess(Model model, @ModelAttribute("vanbang") @Validated Vanbang vanbang) {
        vanBangService.saveVanBang(vanbang);
        return "redirect:/vanbang//";
    }

    @RequestMapping(path = {""}, method = RequestMethod.GET)
    public String sayHello(Model model) {
        model.addAttribute("vanbang", vanBangService.lsitVB());
        return "vanbang/index";
    }

    @RequestMapping(path = {"/del/{maVanBang}"}, method = RequestMethod.GET)
    public String del(Model model, @PathVariable("maVanBang") String maVanBang) {
        vanBangService.deleteVanBang(maVanBang);
        return "redirect:/vanbang/";
    }

    @RequestMapping(path = {"/update/{maVanBang}"}, method = RequestMethod.GET)
    public String update(Model model, @PathVariable("maVanBang") String maVanBang) {
        Vanbang vanbang = vanBangService.getByMaVanBang(maVanBang);
        model.addAttribute("vanbang", vanbang);
        return "vanbang/formAddVanBang";
    }

    @RequestMapping(path = {"/update/{maVanBang}"}, method = RequestMethod.POST)
    public String updateSuccess(Model model, @ModelAttribute("vanbang") @Validated Vanbang vanbang) {
        vanBangService.updateVangBang(vanbang);
        return "redirect:/vanbang//";
    }

    @RequestMapping(path = {"/maVanBang/{maVanBang}"}, method = RequestMethod.GET)
    public String getKhoa(Model model, @PathVariable("maVanBang") String maVanBang) {
        List<Vanbang> lst = new ArrayList<>();
        lst.add(vanBangService.getByMaVanBang(maVanBang));
        model.addAttribute("vanbang", lst);
        model.addAttribute("model", "showOnly");
        return "vanbang/index";
    }
}
