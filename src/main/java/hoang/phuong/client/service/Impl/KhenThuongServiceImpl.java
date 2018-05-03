package hoang.phuong.client.service.Impl;

import hoang.phuong.client.model.Khenthuong;
import hoang.phuong.client.service.KhenThuongService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("khenThuongService")
@Transactional(readOnly = true)
public class KhenThuongServiceImpl extends AbstractService<Khenthuong> implements KhenThuongService {
    public KhenThuongServiceImpl(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    public Khenthuong savekhenthuong(Khenthuong khenthuong) {
        return saveAndReturnId("qlsv/khenthuong", khenthuong);
    }

    @Override
    public Khenthuong getbyId(int id) {
        return getObject("qlsv/khenthuong/" + id);
    }

    @Override
    public List<Khenthuong> listAll() {
        return getListEntity("qlsv/khenthuong");
    }

    @Override
    public List<Khenthuong> listByIdSv(int idSv) {
        return getListEntity("qlsv/khenthuong/idSv/" + idSv);
    }

    @Override
    public List<Khenthuong> listbyYear(String stDate, String endDate) {
        return getListEntity("qlsv/khenthuong/year?stdate=" + stDate + "&eddate=" + endDate);
    }

    @Override
    public boolean updatekhenthuong(Khenthuong khenthuong) {
        return update("/qlsv/khenthuong", khenthuong);
    }

    @Override
    public boolean deletekhenthuong(int id) {
        return delete("qlsv/khenthuong/" + id);
    }
}
