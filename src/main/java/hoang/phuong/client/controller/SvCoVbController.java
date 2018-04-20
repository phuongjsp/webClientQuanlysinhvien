package hoang.phuong.client.controller;

import hoang.phuong.client.model.Svcovb;
import hoang.phuong.client.model.Vanbang;
import hoang.phuong.client.service.SvCoVbService;
import hoang.phuong.client.service.ThongTinSinhVienService;
import hoang.phuong.client.service.VanBangService;
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
@RequestMapping(path = "SvCoVb")
public class SvCoVbController {
    @Autowired
    private SvCoVbService svCoVbService;
    @Autowired
    private ThongTinSinhVienService thongTinSinhVienService;
    @Autowired
    private VanBangService vanBangService;

    @RequestMapping(path = {"/maSv-{maSv}"}, method = RequestMethod.GET)
    public String indexmaaSv(Model model, @PathVariable("maSv") String maSv) {
        List<Svcovb> listSvCoVb = svCoVbService.listByMaSv(maSv);

        model.addAttribute("maSv", maSv);
        model.addAttribute("VB", vanBangService.lsitVB());
        model.addAttribute("svcovb", listSvCoVb);
        return "SvCoVb/index";
    }

    //TODO can phai suy nghi
//    @RequestMapping(path = {"/maVb-{maVb}"}, method = RequestMethod.GET)
//    public String indexMaVb(Model model,@PathVariable("maVb") String maVb){
//        model.addAttribute("svcovb",svCoVbService.listBymaVb(maVb));
//
//        return "SvCoVb/index";
//    }
    @RequestMapping(path = {"/only/maSv-{maSv}-maVb-{maVb}"}, method = RequestMethod.GET)
    public String indexMaSvMaVb(Model model, @PathVariable("maSv") String maSv,
                                @PathVariable("maVb") String maVb) {
        List<Svcovb> listSvCoVb = svCoVbService.listByMaSvMaVb(maSv, maVb);
        List<Vanbang> lstVB = new ArrayList<>();
        Vanbang vb = vanBangService.getByMaVanBang(maVb);
        lstVB.add(vb);
        model.addAttribute("maSv", maSv);
        model.addAttribute("VB", lstVB);
        model.addAttribute("svcovb", listSvCoVb);
        model.addAttribute("model", "only");
        return "SvCoVb/index";
    }

    @RequestMapping(path = {"/add/{maSv}"}, method = RequestMethod.GET)
    public String addKhoa(Model model, @PathVariable("maSv") String maSv) {
        Svcovb svcovb = new Svcovb();
        svcovb.setIdSv(thongTinSinhVienService.getByMaSv(maSv).getId());
        model.addAttribute("VB", vanBangService.lsitVB());
        model.addAttribute("svcovb", svcovb);
        return "SvCoVb/formAddSvCoVb";
    }

    @RequestMapping(path = {"/add/{maSv}"}, method = RequestMethod.POST)
    public String addSuccess(@PathVariable("maSv") String maSv, @ModelAttribute("svcovb") @Validated Svcovb svcovb) {
        svCoVbService.saveSvCoVb(svcovb);
        return "redirect:/SvCoVb/maSv-" + maSv;
    }

    @RequestMapping(path = {"/del/{maSv}-{id}"}, method = RequestMethod.GET)
    public String del(Model model, @PathVariable("id") int id, @PathVariable("maSv") String maSv) {
        svCoVbService.deleteSvCoVb(id);
        return "redirect:/SvCoVb/maSv-" + maSv;
    }

    @RequestMapping(path = {"/update/{maSv}-{id}"}, method = RequestMethod.GET)
    public String update(Model model, @PathVariable("id") int id) {
        model.addAttribute("svcovb", svCoVbService.getById(id));
        return "SvCoVb/formAddSvCoVb";
    }

    @RequestMapping(path = {"/update/{maSv}-{id}"}, method = RequestMethod.POST)
    public String updateSuccess(@PathVariable("maSv") String maSv
            , @ModelAttribute("svcovb") @Validated Svcovb svcovb) {
        svCoVbService.updateSvCoVb(svcovb);
        return "redirect:/SvCoVb/maSv-" + maSv;
    }
}
