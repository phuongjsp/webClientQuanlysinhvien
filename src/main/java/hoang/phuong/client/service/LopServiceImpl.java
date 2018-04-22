package hoang.phuong.client.service;

import hoang.phuong.client.model.Lopsv;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class LopServiceImpl extends AbstractService<Lopsv> implements LopService {
    @Override
    public Lopsv saveLop(Lopsv lopsv) {
        lopsv.setId(null);
        return saveAndReturnId("lopsv", lopsv);
    }

    @Override
    public Lopsv getbyId(int id) {
        return getObject("lopsv/" + id);
    }

    @Override
    public boolean deleteLop(String maLop) {
        return delete("lopsv/maLop-" + maLop);
    }

    @Override
    public boolean updateLop(Lopsv lopsv) {
        return update("lopsv/maLop-" + lopsv.getMaLop(), lopsv);
    }


    @Override
    public Lopsv getByMaLop(String maLop) {
        return getObject("lopsv/maLop-" + maLop);
    }

    @Override
    public List<Lopsv> listLop() {
        return getListEntity("lopsv");
    }
}
