package hoang.phuong.client.controller;

import hoang.phuong.client.model.Diachi;
import hoang.phuong.client.service.DiaChiService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "diachi")
public class DiaChiController extends ExceptionHandlerController {
    DiaChiService diaChiService;

    public DiaChiController(DiaChiService diaChiService) {
        this.diaChiService = diaChiService;
    }
    //
//
//    @RequestMapping(path = {"/{id}"}, method = RequestMethod.GET)
//    public String getById(Model model, @PathVariable("id") int id) {
//        List<Diachi> lst = new ArrayList<>();
//        lst.add(diaChiService.getByIdDiaChi(id));
//        model.addAttribute("search", new Diachi());
//        model.addAttribute("model", "showOnly");
//        model.addAttribute("diachi", lst);
//        return "diachi/index";
//    }
//
//    @RequestMapping(path = {"/add"}, method = RequestMethod.GET)
//    public String addKhoa(Model model) {
//        Diachi diachi = new Diachi();
//        model.addAttribute("diachi", diachi);
//        return "diachi/formAddDiaChi";
//    }

//    @RequestMapping(path = {"/add"}, method = RequestMethod.POST)
//    public String addSuccess(Model model, @ModelAttribute("diachi") @Validated Diachi diachi) {
//        diaChiService.saveDiaChi(diachi);
//        return "redirect:/diachi";
//    }

    @RequestMapping(path = {""}, method = RequestMethod.POST
            , produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Diachi addAjaxSuccess(@RequestBody Diachi diachi) {
        return diaChiService.saveDiaChi(diachi);
    }

//    @RequestMapping(path = {"/del/{id}"}, method = RequestMethod.GET)
//    public String del(Model model, @PathVariable("id") int id) {
//        diaChiService.deleteDiaChi(id);
//        return "redirect:/diachi";
//    }
//
//    @RequestMapping(path = {"/update/{id}"}, method = RequestMethod.GET)
//    public String update(Model model, @PathVariable("id") int id) {
//        Diachi diachi = diaChiService.getByIdDiaChi(id);
//        model.addAttribute("diachi", diachi);
//        return "diachi/formAddDiaChi";
//    }
//
//    @RequestMapping(path = {"/update/{id}"}, method = RequestMethod.POST)
//    public String updateSuccess(Model model, @ModelAttribute("diachi") @Validated Diachi diachi) {
//        diaChiService.updateDiaChi(diachi);
//        return "redirect:/diachi";
//    }
//


}
