package hoang.phuong.client.controller;

import hoang.phuong.client.model.Giayto;
import hoang.phuong.client.service.GiayToService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "giayto")
public class GiayToController extends ExceptionHandlerController {
    @Autowired
    private GiayToService giayToService;

    @RequestMapping(path = {"/add"}, method = RequestMethod.GET)
    public String addKhoa(Model model) {
        Giayto giayto = new Giayto();
        model.addAttribute("giayto", giayto);
        return "giayto/formAddGiayTo";
    }

    @RequestMapping(path = {"/add"}, method = RequestMethod.POST)
    public String addSuccess(Model model, @ModelAttribute("giayto") @Validated Giayto giayto) {
        giayToService.saveGiayto(giayto);
        return "redirect:/giayto/";
    }

    @RequestMapping(path = {""}, method = RequestMethod.GET)
    public String sayHello(Model model) {
        model.addAttribute("giayto", giayToService.listGiayto());
        return "giayto/index";
    }

    @RequestMapping(path = {"/del/{id}"}, method = RequestMethod.GET)
    public String del(Model model, @PathVariable("id") int id) {
        giayToService.deleteGiayto(id);
        return "redirect:/giayto/";
    }

    @RequestMapping(path = {"/update/{maGt}"}, method = RequestMethod.GET)
    public String update(Model model, @PathVariable("maGt") String maGt) {
        Giayto giayto = giayToService.getByMaGT(maGt);
        model.addAttribute("giayto", giayto);
        return "giayto/formAddGiayTo";
    }

    @RequestMapping(path = {"/update/{maGt}"}, method = RequestMethod.POST)
    public String updateSuccess(Model model, @ModelAttribute("giayto") @Validated Giayto giayto) {
        giayToService.updateGiayto(giayto);
        return "redirect:/giayto/";
    }
}
