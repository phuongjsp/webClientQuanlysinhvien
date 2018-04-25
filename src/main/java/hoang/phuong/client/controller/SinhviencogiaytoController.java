package hoang.phuong.client.controller;

import hoang.phuong.client.model.Sinhviencogiayto;
import hoang.phuong.client.service.GiayToService;
import hoang.phuong.client.service.SinhviencogiaytoService;
import hoang.phuong.client.service.ThongTinSinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "sinhviencogiayto")
public class SinhviencogiaytoController extends ExceptionHandlerController {

    @Autowired
    private GiayToService giayToService;
    @Autowired
    private SinhviencogiaytoService sinhviencogiaytoService;
    @Autowired
    private ThongTinSinhVienService thongTinSinhVienService;

    @RequestMapping(path = {"/add/maSv-{maSv}"}, method = RequestMethod.GET)
    public String addKhoa(Model model, @PathVariable("maSv") String maSv) {
        Sinhviencogiayto sinhviencogiayto = new Sinhviencogiayto();
        sinhviencogiayto.setIdSv(thongTinSinhVienService.getByMaSv(maSv).getId());
        model.addAttribute("listGiayToKhongCo", giayToService.listGiayToSinhVienKhongCo(maSv));
        model.addAttribute("sinhviencogiayto", sinhviencogiayto);
        return "sinhviencogiayto/formAddSinhviencogiayto";
    }

    @RequestMapping(path = {"/add/maSv-{maSv}"}, method = RequestMethod.POST)
    public String addSuccess(Model model, @PathVariable("maSv") String maSv,
                             @ModelAttribute("sinhviencogiayto") @Validated Sinhviencogiayto sinhviencogiayto) {
        sinhviencogiaytoService.save(sinhviencogiayto);
        return "redirect:/sinhviencogiayto/maSv-" + maSv;
    }

    @RequestMapping(path = {"/maSv-{maSv}"}, method = RequestMethod.GET)
    public String sayHello(Model model, @PathVariable("maSv") String maSv) {
        model.addAttribute("sinhviencogiayto", sinhviencogiaytoService.listByMaSv(maSv));
        model.addAttribute("maSv", maSv);
        model.addAttribute("giayto", giayToService.listGiayto());
        return "sinhviencogiayto/index";
    }

    @RequestMapping(path = {"/del/maSv-{maSv}-{id}"}, method = RequestMethod.GET)
    public String del(Model model, @PathVariable("id") int id, @PathVariable("maSv") String maSv) {
        sinhviencogiaytoService.delete(id);
        return "redirect:/sinhviencogiayto/maSv-" + maSv;
    }

    @RequestMapping(path = {"/update/maSv-{maSv}-{id}"}, method = RequestMethod.GET)
    public String update(Model model, @PathVariable("maSv") String maSv,
                         @PathVariable("id") int id) {
        model.addAttribute("update", giayToService.getById(id).getTenGiayTo());
        model.addAttribute("sinhviencogiayto", sinhviencogiaytoService.getbyId(id));
        return "sinhviencogiayto/formAddSinhviencogiayto";
    }

    @RequestMapping(path = {"/update/maSv-{maSv}-{id}"}, method = RequestMethod.POST)
    public String updateSuccess(Model model, @ModelAttribute("sinhviencogiayto")
    @Validated Sinhviencogiayto sinhviencogiayto, @PathVariable("maSv") String maSv) {
        sinhviencogiaytoService.update(sinhviencogiayto);
        return "redirect:/sinhviencogiayto/maSv-" + maSv;
    }
}
