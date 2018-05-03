package hoang.phuong.client.controller;

import hoang.phuong.client.model.Dinhchisinhvien;
import hoang.phuong.client.service.DinhChiService;
import hoang.phuong.client.service.ThongTinSinhVienService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "dinhchi")
public class DinhChiSinhVienController extends ExceptionHandlerController {
    private final DinhChiService dinhChiService;
    private final ThongTinSinhVienService thongTinSinhVienService;

    public DinhChiSinhVienController(DinhChiService dinhChiService, ThongTinSinhVienService thongTinSinhVienService) {
        this.dinhChiService = dinhChiService;
        this.thongTinSinhVienService = thongTinSinhVienService;
    }

    @RequestMapping(path = {"/all"}, method = RequestMethod.GET)
    public String ListAll(Model model) {
        model.addAttribute("dinhchi", dinhChiService.findAllDinhchisinhvien());
        return "dinhchi/index";
    }

    @RequestMapping(path = {"/getById/{id}"}, method = RequestMethod.GET)
    public String GetById(Model model, @PathVariable("id") int id) {
        List<Dinhchisinhvien> lst = new ArrayList<>();
        lst.add(dinhChiService.getOneDinhchisinhvien(id));
        model.addAttribute("dinhchi", lst);
        return "dinhchi/index";
    }

    @RequestMapping(path = {"/dangdinhchi"}, method = RequestMethod.GET)
    public String listDangDinhchi(Model model) {
        model.addAttribute("dinhchi", dinhChiService.listConDinhChi());
        return "dinhchi/index";
    }

    @RequestMapping(path = {"/add"}, method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("dinhchi", new Dinhchisinhvien());
        return "dinhchi/formAdd";
    }

    @RequestMapping(path = {"/add"}, method = RequestMethod.POST)
    public String addSuccess(Model model, @RequestParam Map<String, Object> maprequest) {
        int idSv = thongTinSinhVienService.getByMaSv(maprequest.get("maSv").toString()).getId();
        maprequest.remove("maSv");
        maprequest.put("idSv", idSv);
        dinhChiService.saveDinhchisinhvien(maprequest);
        return "redirect:/dinhchi/dangdinhchi";
    }

    @RequestMapping(path = {"/update/{id}"}, method = RequestMethod.GET)
    public String update(Model model, @PathVariable("id") int id) {
        model.addAttribute("dinhchi", dinhChiService.getOneDinhchisinhvien(id));
        return "dinhchi/formAdd";
    }

    @RequestMapping(path = {"/update/{id}"}, method = RequestMethod.POST)
    public String updateSuccess(Model model, @PathVariable("id") int id, @RequestParam Map<String, Object> maprequest) {
        if (dinhChiService.updateDinhchisinhvien(maprequest)) {
            model.addAttribute("messages", "Update Sussess !");
            return "redirect:/dinhchi/getById/" + id;
        }
        model.addAttribute("messages", "Update Fail !");
        return "dinhchi/formAdd";
    }

    @RequestMapping(path = {"/delete/{id}"}, method = RequestMethod.GET)
    public String Delete(Model model, @PathVariable("id") int id) {
        if (dinhChiService.deleteDinhchisinhvien(id)) {
            model.addAttribute("messages", "Delete Sussess !");
            return "redirect:/dinhchi/";
        } else {
            model.addAttribute("messages", "Delete Fail !");
            return "redirect:/dinhchi/all";
        }
    }
}
