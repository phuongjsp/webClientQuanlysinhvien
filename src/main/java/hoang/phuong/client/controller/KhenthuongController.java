package hoang.phuong.client.controller;

import hoang.phuong.client.model.Khenthuong;
import hoang.phuong.client.model.Thongtinsinhvien;
import hoang.phuong.client.service.KhenThuongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "khenthuong")
public class KhenthuongController {
    private final KhenThuongService khenThuongService;

    public KhenthuongController(KhenThuongService khenThuongService) {
        this.khenThuongService = khenThuongService;
    }

    @RequestMapping(path = {""}, method = RequestMethod.GET)
    public String ListAll(Model model) {
        model.addAttribute("khenthuong", khenThuongService.listAll());
        model.addAttribute("model", "all");
        return "khenthuong/index";
    }

    @RequestMapping(path = {"/year/{stdate}/{eddate}"}, method = RequestMethod.GET)
    public String ListbyYear(Model model
            , @PathVariable("stdate") String stdate
            , @PathVariable("eddate") String eddate) {
        model.addAttribute("khenthuong", khenThuongService.listbyYear(stdate, eddate));
        model.addAttribute("model", "all");
        return "khenthuong/index";
    }

    @RequestMapping(path = {"/idSv/{idSv}"}, method = RequestMethod.GET)
    public String ListByIdSv(Model model, @PathVariable("idSv") int idSv) {
        List<Khenthuong> lst = khenThuongService.listByIdSv(idSv);
        Thongtinsinhvien thongtinsinhvien = new Thongtinsinhvien();
        if (lst != null) {
            thongtinsinhvien = lst.get(0).getThongtinsinhvien();
        }
        model.addAttribute("khenthuong", lst);
        model.addAttribute("thongtinsinhvien", thongtinsinhvien);
        model.addAttribute("model", "only");
        return "khenthuong/index";
    }

    @RequestMapping(path = {"/id/{id}"}, method = RequestMethod.GET)
    public String getById(Model model
            , @PathVariable("id") int id) {
        List<Khenthuong> lst = new ArrayList<>();
        lst.add(khenThuongService.getbyId(id));
        model.addAttribute("khenthuong", lst);
        model.addAttribute("model", "all");
        return "khenthuong/index";
    }

    @RequestMapping(path = {"/add"}, method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("now", new Date());
        return "khenthuong/formAddKhenThuong";
    }

    @RequestMapping(path = {"/add"}, method = RequestMethod.POST)
    public String addSuccess(Model model, @RequestParam MultiValueMap<String, List<String>> requestParams) {
        requestParams.forEach((s, lists) -> {
            System.out.println(s + " : ");
            lists.forEach(strings -> {
                System.out.printf(strings + "  ");
            });
        });
        return "khenthuong/index";
    }
}
