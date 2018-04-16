package hoang.phuong.client.service;

import hoang.phuong.client.model.Thongtinthem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ThongTinThemServiceImpl extends AbstractService<Thongtinthem> implements ThongTinThemService {
    @Override
    public void saveTTT(Thongtinthem thongtinthem) {
        save("thongtinthem", thongtinthem);
    }

    @Override
    public void updateTTT(Thongtinthem thongtinthem) {
        update("/thongtinthem/" + thongtinthem.getId(), thongtinthem);
    }

    @Override
    public void deleteTTT(int id) {
        delete("/thongtinthem/" + id);
    }

    @Override
    public Thongtinthem getbyId(int id) {
        return getObject("/thongtinthem/" + id);
    }

    @Override
    public List<Thongtinthem> listByMaSv(String maSv) {
        return getListEntity("thongtinthem/maSv-" + maSv);
    }

    @Override
    public List<Thongtinthem> list() {
        return getListEntity("thongtinthem");
    }
}
