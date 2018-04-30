package hoang.phuong.client.service.Impl;

import hoang.phuong.client.model.Giayto;
import hoang.phuong.client.service.GiayToService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Transactional
public class GiayToServiceImpl extends AbstractService<Giayto> implements GiayToService {
    public GiayToServiceImpl(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    public Giayto saveGiayto(Giayto giayto) {
        return saveAndReturnId("qlsv/giayto", giayto);
    }

    @Override
    public boolean updateGiayto(Giayto giayto) {
        return update("qlsv/giayto", giayto);
    }

    @Override
    public boolean deleteGiayto(int id) {
        return delete("qlsv/giayto/" + id);
    }

    @Override
    public Giayto getById(int id) {
        return getObject("qlsv/giayto/" + id);
    }

    @Override
    public Giayto getByMaGT(String maGT) {
        return getObject("qlsv/giayto/maGT-" + maGT);
    }

    @Override
    public List<Giayto> listGiayto() {
        return getListEntity("qlsv/giayto");
    }

    @Override
    public List<Giayto> listGiayToSinhVienKhongCo(String maSv) {
        return getListEntity("qlsv/giayto/SVisEmpty-" + maSv);
    }
}
