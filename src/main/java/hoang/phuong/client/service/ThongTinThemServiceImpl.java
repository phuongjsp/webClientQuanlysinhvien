package hoang.phuong.client.service;

import hoang.phuong.client.model.Thongtinthem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ThongTinThemServiceImpl extends AbstractService<Thongtinthem> implements ThongTinThemService {
    @Override
    public Thongtinthem saveTTT(Thongtinthem thongtinthem) {
        return saveAndReturnId("thongtinthem", thongtinthem);
    }

    @Override
    public boolean updateTTT(Thongtinthem thongtinthem) {
        return update("/thongtinthem/" + thongtinthem.getId(), thongtinthem);
    }

    @Override
    public boolean deleteTTT(int id) {
        return delete("/thongtinthem/" + id);
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
