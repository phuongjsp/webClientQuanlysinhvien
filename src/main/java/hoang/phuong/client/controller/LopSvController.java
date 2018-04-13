package hoang.phuong.client.controller;

import hoang.phuong.client.model.Lopsv;
import hoang.phuong.client.service.LopService;
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
@RequestMapping(path = "lopsv")
public class LopSvController {
    @Autowired
    private LopService lopService;

    @RequestMapping(path = {"/add"}, method = RequestMethod.GET)
    public String addKhoa(Model model) {
        Lopsv lopsv = new Lopsv();
        model.addAttribute("lopsv", lopsv);
        return "lopsv/formAddLopSv";
    }

    @RequestMapping(path = {"/add"}, method = RequestMethod.POST)
    public String addSuccess(Model model, @ModelAttribute("lopsv") @Validated Lopsv lopsv) {
        lopService.saveLop(lopsv);
        return "redirect:/lopsv";
    }

    @RequestMapping(path = {""}, method = RequestMethod.GET)
    public String sayHello(Model model) {
        model.addAttribute("lopsv", lopService.listLop());
        return "lopsv/index";
    }
    @RequestMapping(path = {"/del/{maLop}"}, method = RequestMethod.GET)
    public String del(Model model,@PathVariable("maLop") String maLop) {
        lopService.deleteLop(maLop);
        return "redirect:/lopsv";
    }
    @RequestMapping(path = {"/update/{maLop}"}, method = RequestMethod.GET)
    public String update(Model model,@PathVariable("maLop") String maLop) {
        Lopsv lopsv = lopService.getByMaLop(maLop);
        model.addAttribute("lopsv", lopsv);
        return "lopsv/formAddLopSv";
    }
    @RequestMapping(path = {"/update/{maLop}"}, method = RequestMethod.POST)
    public String updateSuccess(Model model, @ModelAttribute("lopsv") @Validated Lopsv lopsv) {
        lopService.updateLop(lopsv);
        return "redirect:/lopsv";
    }
    @RequestMapping(path = {"/maLop/{maLop}"}, method = RequestMethod.GET)
    public String getKhoa(Model model,@PathVariable("maLop") String maLop) {
        List<Lopsv> lst = new ArrayList<>();
        lst.add(lopService.getByMaLop(maLop));
        model.addAttribute("lopsv", lst);
        model.addAttribute("model","showOnly");
        return "lopsv/index";
    }
}
