package hoang.phuong.client.service.Impl;

import hoang.phuong.client.model.Sinhviencogiayto;
import hoang.phuong.client.service.SinhviencogiaytoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Transactional
public class SinhviencogiaytoServiceImpl extends AbstractService<Sinhviencogiayto> implements SinhviencogiaytoService {
    public SinhviencogiaytoServiceImpl(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    public Sinhviencogiayto getbyId(int id) {
        return getObject("qlsv/sinhviencogiayto/" + id);
    }

    @Override
    public Sinhviencogiayto save(Sinhviencogiayto sinhviencogiayto) {
        return saveAndReturnId("qlsv/sinhviencogiayto", sinhviencogiayto);
    }

    @Override
    public boolean update(Sinhviencogiayto sinhviencogiayto) {
        return update("qlsv/sinhviencogiayto", sinhviencogiayto);
    }

    @Override
    public boolean delete(int id) {
        return delete("qlsv/sinhviencogiayto/" + id);
    }

    @Override
    public List<Sinhviencogiayto> listByMaSv(String maSv) {
        return getListEntity("qlsv/sinhviencogiayto/maSv-" + maSv);
    }
}
