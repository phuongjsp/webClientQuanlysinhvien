package hoang.phuong.client.service;

import hoang.phuong.client.model.Khoa;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class KhoaServiceImpl extends AbstractService<Khoa> implements KhoaService {


    @Override
    public Khoa getKhoaByMaKhoa(String maKhoa) {
        return getObject("/khoa/maKhoa-" + maKhoa);
    }

    @Override
    public List<Khoa> getListKhoa() {
        return getListEntity("khoa");
    }

    @Override
    public Khoa saveKhoa(Khoa khoa) {
        khoa.setId(null);
        return saveAndReturnId("khoa", khoa);
    }

    @Override
    public boolean deleteKhoa(int id) {
        return delete("khoa/" + id);
    }

    @Override
    public boolean update(Khoa khoa) {
        return update("khoa/" + khoa.getId(), khoa);
    }
}
