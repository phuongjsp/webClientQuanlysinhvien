package hoang.phuong.client.service.Impl;

import hoang.phuong.client.model.Khoa;
import hoang.phuong.client.service.KhoaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("khoaService")
@Transactional(readOnly = true)
public class KhoaServiceImpl extends AbstractService<Khoa> implements KhoaService {


    public KhoaServiceImpl(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    public Khoa getKhoaByMaKhoa(String maKhoa) {
        return getObject("qlsv//khoa/maKhoa-" + maKhoa);
    }

    @Override
    public List<Khoa> getListKhoa() {
        return getListEntity("qlsv/khoa");
    }

    @Override
    public Khoa saveKhoa(Khoa khoa) {
        khoa.setId(null);
        return saveAndReturnId("qlsv/khoa", khoa);
    }

    @Override
    public boolean deleteKhoa(int id) {
        return delete("qlsv/khoa/" + id);
    }

    @Override
    public boolean update(Khoa khoa) {
        return update("qlsv/khoa", khoa);
    }
}
