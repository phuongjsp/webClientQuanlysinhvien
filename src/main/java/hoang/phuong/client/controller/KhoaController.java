package hoang.phuong.client.controller;

import hoang.phuong.client.model.Khoa;
import hoang.phuong.client.service.KhoaService;
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
@RequestMapping(path = "khoa")
public class KhoaController {
    @Autowired
    private KhoaService khoaService;

    @RequestMapping(path = {"/add"}, method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String addKhoa(Model model) {
        Khoa khoa = new Khoa();
        model.addAttribute("khoa", khoa);
        return "khoa/formAddKhoa";
    }

    @RequestMapping(path = {"/add"}, method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String addSuccess(Model model, @ModelAttribute("khoa") @Validated Khoa khoa) {
        System.out.println(khoa.getTenKhoa());
        khoaService.saveKhoa(khoa);
        return "redirect:/khoa/";
    }

    @RequestMapping(path = {""}, method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String sayHello(Model model) {
        model.addAttribute("khoa", khoaService.getListKhoa());
        return "khoa/index";
    }

    @RequestMapping(path = {"/del/{maKhoa}"}, method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String del(Model model, @PathVariable("maKhoa") String maKhoa) {
        khoaService.deleteKhoa(khoaService.getKhoaByMaKhoa(maKhoa).getId());
        return "redirect:/khoa/";
    }

    @RequestMapping(path = {"/update/{maKhoa}"}, method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String update(Model model, @PathVariable("maKhoa") String maKhoa) {
        model.addAttribute("khoa", khoaService.getKhoaByMaKhoa(maKhoa));
        return "khoa/formAddKhoa";
    }

    @RequestMapping(path = {"/update/{maKhoa}"}, method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String updateSuccess(Model model, @ModelAttribute("maKhoa") @Validated Khoa khoa) {
        khoaService.update(khoa);
        return "redirect:/khoa/";
    }

    @RequestMapping(path = {"/maKhoa/{maKhoa}"}, method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getKhoa(Model model, @PathVariable("maKhoa") String maKhoa) {
        List<Khoa> lst = new ArrayList<>();
        lst.add(khoaService.getKhoaByMaKhoa(maKhoa));
        model.addAttribute("khoa", lst);
        model.addAttribute("model", "showOnly");
        return "khoa/index";
    }
}
