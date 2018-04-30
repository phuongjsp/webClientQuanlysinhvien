package hoang.phuong.client.service.Impl;

import hoang.phuong.client.model.Svcovb;
import hoang.phuong.client.service.SvCoVbService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class SvCoVbServiceImpl extends AbstractService<Svcovb> implements SvCoVbService {
    public SvCoVbServiceImpl(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    public Svcovb saveSvCoVb(Svcovb svcovb) {
        return saveAndReturnId("qlsv/svcovb", svcovb);
    }

    @Override
    public boolean deleteSvCoVb(int id) {
        return delete("qlsv/svcovb/" + id);
    }

    @Override
    public boolean updateSvCoVb(Svcovb svcovb) {
        return update("qlsv/svcovb", svcovb);
    }

    @Override
    public Svcovb getById(int id) {
        return getObject("qlsv/svcovb/" + id);
    }

    @Override
    public List<Svcovb> listByMaSv(String maSv) {
        return getListEntity("qlsv/svcovb/maSV-" + maSv);
    }

    @Override
    public List<Svcovb> listByMaSvMaVb(String maSv, String maVb) {
        return getListEntity("qlsv/svcovb/only/maSV-" + maSv + "-maVB-" + maVb);
    }

    @Override
    public List<Svcovb> listBymaVb(String maVb) {
        return getListEntity("qlsv/svcovb/maVB-" + maVb);
    }

    @Override
    public List<Integer> listidSvBymaVb(String maVb) {
        List<Integer> list = new ArrayList<>();
        List<Svcovb> svcovbList = getListEntity("qlsv/svcovb/maVB-" + maVb);
        svcovbList.forEach(svcovb -> {
            if (list.indexOf(svcovb.getId()) == -1) list.add(svcovb.getId());
        });
        return list;
    }

}
