package hoang.phuong.client.service.Impl;

import hoang.phuong.client.model.Lopsv;
import hoang.phuong.client.service.LopService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class LopServiceImpl extends AbstractService<Lopsv> implements LopService {
    public LopServiceImpl(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    public Lopsv saveLop(Lopsv lopsv) {
        lopsv.setId(null);
        return saveAndReturnId("qlsv/lopsv", lopsv);
    }

    @Override
    public Lopsv getbyId(int id) {
        return getObject("qlsv/lopsv/" + id);
    }

    @Override
    public boolean deleteLop(String maLop) {
        return delete("qlsv/lopsv/maLop-" + maLop);
    }

    @Override
    public boolean updateLop(Lopsv lopsv) {
        return update("qlsv/lopsv", lopsv);
    }


    @Override
    public Lopsv getByMaLop(String maLop) {
        return getObject("qlsv/lopsv/maLop-" + maLop);
    }

    @Override
    public List<Lopsv> listLop() {
        return getListEntity("qlsv/lopsv");
    }
}
