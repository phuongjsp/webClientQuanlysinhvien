package hoang.phuong.client.service;

import hoang.phuong.client.model.Giayto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GiayToServiceImpl extends AbstractService<Giayto> implements GiayToService {
    @Override
    public Giayto saveGiayto(Giayto giayto) {
        return saveAndReturnId("giayto", giayto);
    }

    @Override
    public boolean updateGiayto(Giayto giayto) {
        return update("giayto", giayto);
    }

    @Override
    public boolean deleteGiayto(int id) {
        return delete("giayto/" + id);
    }

    @Override
    public Giayto getById(int id) {
        return getObject("giayto/" + id);
    }

    @Override
    public Giayto getByMaGT(String maGT) {
        return getObject("giayto/maGT-" + maGT);
    }

    @Override
    public List<Giayto> listGiayto() {
        return getListEntity("giayto");
    }

    @Override
    public List<Giayto> listGiayToSinhVienKhongCo(String maSv) {
        return getListEntity("giayto/SVisEmpty-" + maSv);
    }
}
