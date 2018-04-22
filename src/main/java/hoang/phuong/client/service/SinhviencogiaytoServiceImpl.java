package hoang.phuong.client.service;

import hoang.phuong.client.model.Sinhviencogiayto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SinhviencogiaytoServiceImpl extends AbstractService<Sinhviencogiayto> implements SinhviencogiaytoService {
    @Override
    public Sinhviencogiayto getbyId(int id) {
        return getObject("sinhviencogiayto/" + id);
    }

    @Override
    public Sinhviencogiayto save(Sinhviencogiayto sinhviencogiayto) {
        return saveAndReturnId("sinhviencogiayto", sinhviencogiayto);
    }

    @Override
    public boolean update(Sinhviencogiayto sinhviencogiayto) {
        return update("sinhviencogiayto", sinhviencogiayto);
    }

    @Override
    public boolean delete(int id) {
        return delete("sinhviencogiayto/" + id);
    }

    @Override
    public List<Sinhviencogiayto> listByMaSv(String maSv) {
        return getListEntity("sinhviencogiayto/maSv-" + maSv);
    }
}
