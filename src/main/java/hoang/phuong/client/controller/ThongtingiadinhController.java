package hoang.phuong.client.controller;

import hoang.phuong.client.model.Thongtingiadinh;
import hoang.phuong.client.service.ThongTinSinhVienService;
import hoang.phuong.client.service.ThongtingiadinhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "thongtingiadinh")
public class ThongtingiadinhController extends ExceptionHandlerController {
    @Autowired
    private ThongtingiadinhService thongtingiadinhService;
    @Autowired
    private ThongTinSinhVienService thongTinSinhVienService;

    @RequestMapping(path = {"/add/{maSv}"}, method = RequestMethod.GET)
    public String addKhoa(Model model, @PathVariable("maSv") String maSv) {
        Thongtingiadinh thongtingiadinh = new Thongtingiadinh();
        thongtingiadinh.setIdSv(thongTinSinhVienService.getByMaSv(maSv).getId());
        model.addAttribute("thongtingiadinh", thongtingiadinh);
        return "thongtingiadinh/formAddTTGD";
    }

    @RequestMapping(path = {"/add/{maSv}"}, method = RequestMethod.POST)
    public String addSuccess(@PathVariable("maSv") String maSv,
                             @ModelAttribute("thongtinthem") @Validated Thongtingiadinh thongtingiadinh) {
        thongtingiadinhService.saveTTGD(thongtingiadinh);
        return "redirect:/thongtinsinhvien/maSv/" + maSv;
    }

    @RequestMapping(path = {"/del/{maSv}-{id}"}, method = RequestMethod.GET)
    public String del(Model model, @PathVariable("id") int id, @PathVariable("maSv") String maSv) {
        thongtingiadinhService.deleteTTGD(id);
        return "redirect:/thongtinsinhvien/maSv/" + maSv;
    }

    @RequestMapping(path = {"/update/{maSv}-{id}"}, method = RequestMethod.GET)
    public String update(Model model, @PathVariable("id") int id) {
        model.addAttribute("thongtingiadinh", thongtingiadinhService.getById(id));
        return "thongtingiadinh/formAddTTGD";
    }

    @RequestMapping(path = {"/update/{maSv}-{id}"}, method = RequestMethod.POST)
    public String updateSuccess(@PathVariable("maSv") String maSv, @ModelAttribute("thongtinthem") @Validated Thongtingiadinh thongtingiadinh) {
        thongtingiadinhService.updateTTGD(thongtingiadinh);
        return "redirect:/thongtinsinhvien/maSv/" + maSv;
    }

    @RequestMapping(path = {"/maSv/{maSv}"}, method = RequestMethod.GET)
    public String getByMaSv(Model model, @PathVariable("maSv") String maSv) {
        model.addAttribute("maSv", maSv);
        model.addAttribute("thongtingiadinh", thongtingiadinhService.listByIdSv(thongTinSinhVienService.getByMaSv(maSv).getId()));
        return "thongtingiadinh/index";
    }


}
