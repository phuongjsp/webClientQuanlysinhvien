package hoang.phuong.client.service.Impl;

import hoang.phuong.client.model.Thongtinthem;
import hoang.phuong.client.service.ThongTinThemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("thongTinThemService")
@Transactional(readOnly = true)
public class ThongTinThemServiceImpl extends AbstractService<Thongtinthem> implements ThongTinThemService {
    public ThongTinThemServiceImpl(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    public Thongtinthem saveTTT(Thongtinthem thongtinthem) {
        return saveAndReturnId("qlsv/thongtinthem", thongtinthem);
    }

    @Override
    public boolean updateTTT(Thongtinthem thongtinthem) {
        return update("qlsv/thongtinthem", thongtinthem);
    }

    @Override
    public boolean deleteTTT(int id) {
        return delete("qlsv/thongtinthem/" + id);
    }

    @Override
    public Thongtinthem getbyId(int id) {
        return getObject("qlsv/thongtinthem/" + id);
    }

    @Override
    public List<Thongtinthem> listByMaSv(String maSv) {
        return getListEntity("qlsv/thongtinthem/maSv-" + maSv);
    }

    @Override
    public List<Thongtinthem> list() {
        return getListEntity("qlsv/thongtinthem");
    }
}
