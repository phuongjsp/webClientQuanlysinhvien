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
        try {
            update("sinhviencogiayto", sinhviencogiayto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            delete("sinhviencogiayto/" + id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public List<Sinhviencogiayto> listByMaSv(String maSv) {
        return getListEntity("sinhviencogiayto/maSv-" + maSv);
    }
}
