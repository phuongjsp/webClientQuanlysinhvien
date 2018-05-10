package hoang.phuong.client.controller;

import hoang.phuong.client.model.Khenthuong;
import hoang.phuong.client.model.Thongtinsinhvien;
import hoang.phuong.client.service.KhenThuongService;
import hoang.phuong.client.service.ThongTinSinhVienService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(path = "khenthuong")
public class KhenthuongController {
    private final KhenThuongService khenThuongService;
    private final ThongTinSinhVienService thongTinSinhVienService;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

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

    public KhenthuongController(KhenThuongService khenThuongService, ThongTinSinhVienService thongTinSinhVienService) {
        this.khenThuongService = khenThuongService;
        this.thongTinSinhVienService = thongTinSinhVienService;
    }

    @RequestMapping(path = {"/add"}, method = RequestMethod.GET)
    public String add(Model model) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        model.addAttribute("now", sdf.format(new Date()));
        return "khenthuong/formAddKhenThuong";
    }

    @RequestMapping(path = {"/add"}, method = RequestMethod.POST)
    public String addSuccess(Model model, @RequestParam MultiValueMap<String, String> requestParams) {
        List<Khenthuong> khenthuongList = new LinkedList<>();

        requestParams.get("maSv[]").forEach(s1 -> {
            Khenthuong khenthuong = new Khenthuong();
            khenthuong.setIdSv(thongTinSinhVienService.getByMaSv(s1).getId());
            khenthuong.setLyDo(requestParams.get("lyDo").get(0));

            Date date = new Date();
            try {
                date = simpleDateFormat.parse(requestParams.get("ngay").get(0));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            khenthuong.setNgay(date.getTime());
            khenthuongList.add(khenthuong);
        });
        khenthuongList.forEach(khenthuong -> khenThuongService.savekhenthuong(khenthuong));
        return "redirect:/khenthuong";
    }

    @RequestMapping(path = {"/update/{id}"}, method = RequestMethod.GET)
    public String update(Model model, @PathVariable("id") int id) {
        Khenthuong khenthuong = khenThuongService.getbyId(id);
        model.addAttribute("khenthuong", khenthuong);
        Date date = new Date();
        date.setTime(khenthuong.getNgay());
        model.addAttribute("now", simpleDateFormat.format(date));
        model.addAttribute("model", "update");
        return "khenthuong/formAddKhenThuong";
    }

    @RequestMapping(path = {"/update/{id}"}, method = RequestMethod.POST)
    public String updateResult(Model model, @PathVariable("id") int id, @RequestParam Map<String, String> request) {
        Khenthuong khenthuong = khenThuongService.getbyId(id);
        khenthuong.setLyDo(request.get("lyDo"));
        try {
            khenthuong.setNgay(simpleDateFormat.parse(request.get("ngay")).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        khenThuongService.updatekhenthuong(khenthuong);
        return "redirect:/khenthuong";
    }

    @RequestMapping(path = {"/delete/{id}"}, method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id) {
        khenThuongService.deletekhenthuong(id);
        return "redirect:/khenthuong";
    }
}
