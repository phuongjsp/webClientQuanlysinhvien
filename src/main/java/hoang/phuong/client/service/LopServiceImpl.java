package hoang.phuong.client.service;

import hoang.phuong.client.model.Lopsv;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(readOnly = true)
public class LopServiceImpl extends AbstractService<Lopsv> implements LopService {
    @Override
    public void saveLop(Lopsv lopsv) {
        lopsv.setId(null);
        save("lopsv",lopsv);
    }

    @Override
    public void deleteLop(String maLop) {
    delete("lopsv/maLop-"+maLop);
    }

    @Override
    public void updateLop(Lopsv lopsv) {
        update("lopsv/maLop-"+lopsv.getMaLop(),lopsv);
    }



    @Override
    public Lopsv getByMaLop(String maLop) {
        return getObject("lopsv/maLop-"+maLop);
    }

    @Override
    public List<Lopsv> listLop() {
        return getListEntity("lopsv");
    }
}
