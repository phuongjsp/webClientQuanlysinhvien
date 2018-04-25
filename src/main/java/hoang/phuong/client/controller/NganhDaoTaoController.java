package hoang.phuong.client.controller;

import hoang.phuong.client.model.Nganhdaotao;
import hoang.phuong.client.service.NganhDaoTaoService;
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
@RequestMapping(path = "nganhdaotao")
public class NganhDaoTaoController extends ExceptionHandlerController {
    @Autowired
    private NganhDaoTaoService nganhDaoTaoService;

    @RequestMapping(path = {"/add"}, method = RequestMethod.GET)
    public String addKhoa(Model model) {
        Nganhdaotao nganhdaotao = new Nganhdaotao();
        model.addAttribute("nganhdaotao", nganhdaotao);
        return "nganhdaotao/formAddNganhDaoTao";
    }

    @RequestMapping(path = {"/add"}, method = RequestMethod.POST)
    public String addSuccess(Model model, @ModelAttribute("nganhdaotao") @Validated Nganhdaotao nganhdaotao) {
        nganhDaoTaoService.saveNganh(nganhdaotao);
        return "redirect:/nganhdaotao/";
    }

    @RequestMapping(path = {""}, method = RequestMethod.GET)
    public String sayHello(Model model) {
        model.addAttribute("nganhdaotao", nganhDaoTaoService.listNganhDT());
        return "nganhdaotao/index";
    }

    @RequestMapping(path = {"/del/{maNganh}"}, method = RequestMethod.GET)
    public String del(Model model, @PathVariable("maNganh") String maNganh) {
        nganhDaoTaoService.deleteNganh(maNganh);
        return "redirect:/nganhdaotao/";
    }

    @RequestMapping(path = {"/update/{maNganh}"}, method = RequestMethod.GET)
    public String update(Model model, @PathVariable("maNganh") String maNganh) {
        Nganhdaotao nganhdaotao = nganhDaoTaoService.getByMaNganh(maNganh);
        model.addAttribute("nganhdaotao", nganhdaotao);
        return "nganhdaotao/formAddNganhDaoTao";
    }

    @RequestMapping(path = {"/update/{maNganh}"}, method = RequestMethod.POST)
    public String updateSuccess(Model model, @ModelAttribute("nganhdaotao") @Validated Nganhdaotao nganhdaotao) {
        nganhDaoTaoService.updateNganh(nganhdaotao);
        return "redirect:/nganhdaotao/";
    }

    @RequestMapping(path = {"/maNganh/{maNganh}"}, method = RequestMethod.GET)
    public String getKhoa(Model model, @PathVariable("maNganh") String maNganh) {
        List<Nganhdaotao> lst = new ArrayList<>();
        lst.add(nganhDaoTaoService.getByMaNganh(maNganh));
        model.addAttribute("nganhdaotao", lst);
        model.addAttribute("model", "showOnly");
        return "nganhdaotao/index";
    }
}
