package hoang.phuong.client.service;

import hoang.phuong.client.model.Svcovb;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class SvCoVbServiceImpl extends AbstractService<Svcovb> implements SvCoVbService {
    @Override
    public void saveSvCoVb(Svcovb svcovb) {
        save("svcovb", svcovb);
    }

    @Override
    public void deleteSvCoVb(int id) {
        delete("svcovb/" + id);
    }

    @Override
    public void updateSvCoVb(Svcovb svcovb) {
        update("svcovb/" + svcovb.getId(), svcovb);
    }

    @Override
    public Svcovb getById(int id) {
        return getObject("svcovb/" + id);
    }

    @Override
    public List<Svcovb> listByMaSv(String maSv) {
        return getListEntity("svcovb/maSV-" + maSv);
    }

    @Override
    public List<Svcovb> listByMaSvMaVb(String maSv, String maVb) {
        return getListEntity("svcovb/only/maSV-" + maSv + "-maVB-" + maVb);
    }

    @Override
    public List<Svcovb> listBymaVb(String maVb) {
        return getListEntity("svcovb/maVB-" + maVb);
    }

    @Override
    public List<Integer> listidSvBymaVb(String maVb) {
        List<Integer> list = new ArrayList<>();
        List<Svcovb> svcovbList = getListEntity("svcovb/maVB-" + maVb);
        svcovbList.forEach(svcovb -> {
            if (list.indexOf(svcovb.getId()) == -1) list.add(svcovb.getId());
        });
        return list;
    }

}
