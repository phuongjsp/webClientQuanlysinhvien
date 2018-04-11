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
        return getObject("/khoa/maKhoa-"+maKhoa);
    }

    @Override
    public List<Khoa> getListKhoa() {
        return getListEntity("khoa");
    }

    @Override
    public boolean saveKhoa(Khoa khoa) {
        khoa.setId(null);
       return save("khoa", khoa);
    }

    @Override
    public void deleteKhoa(int id) {
        delete("khoa/"+id);
    }

    @Override
    public void update(Khoa khoa) {
        update("khoa/"+khoa.getId(),khoa);
    }
}
