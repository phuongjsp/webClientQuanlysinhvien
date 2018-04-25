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

@Controller
@RequestMapping(path = "thongtinthem")
public class ThongTinThemController extends ExceptionHandlerController {
    @Autowired
    private ThongTinThemService thongTinThemService;
    @Autowired
    private ThongTinSinhVienService thongTinSinhVienService;

    @RequestMapping(path = {"/add/{maSv}"}, method = RequestMethod.GET)
    public String addKhoa(Model model, @PathVariable("maSv") String maSv) {
        Thongtinthem thongtinthem = new Thongtinthem();
        thongtinthem.setIdSv(thongTinSinhVienService.getByMaSv(maSv).getId());
        model.addAttribute("thongtinthem", thongtinthem);
        return "thongtinthem/formAddTTT";
    }

    @RequestMapping(path = {"/add/{maSv}"}, method = RequestMethod.POST)
    public String addSuccess(@PathVariable("maSv") String maSv, @ModelAttribute("thongtinthem") @Validated Thongtinthem thongtinthem) {
        thongTinThemService.saveTTT(thongtinthem);
        return "redirect:/thongtinsinhvien/maSv/" + maSv;
    }

    @RequestMapping(path = {"/del/{maSv}-{id}"}, method = RequestMethod.GET)
    public String del(Model model, @PathVariable("id") int id, @PathVariable("maSv") String maSv) {
        thongTinThemService.deleteTTT(id);
        return "redirect:/thongtinsinhvien/maSv/" + maSv;
    }

    @RequestMapping(path = {"/update/{maSv}-{id}"}, method = RequestMethod.GET)
    public String update(Model model, @PathVariable("id") int id) {
        model.addAttribute("thongtinthem", thongTinThemService.getbyId(id));
        return "thongtinthem/formAddTTT";
    }

    @RequestMapping(path = {"/update/{maSv}-{id}"}, method = RequestMethod.POST)
    public String updateSuccess(@PathVariable("maSv") String maSv, @ModelAttribute("thongtinthem") @Validated Thongtinthem thongtinthem) {
        thongTinThemService.updateTTT(thongtinthem);
        return "redirect:/thongtinsinhvien/maSv/" + maSv;
    }

    @RequestMapping(path = {"/maSv/{maSv}"}, method = RequestMethod.GET)
    public String getByMaSv(Model model, @PathVariable("maSv") String maSv) {
        model.addAttribute("thongtinthem", thongTinThemService.listByMaSv(maSv));
        return "thongtinthem/index";
    }


}
