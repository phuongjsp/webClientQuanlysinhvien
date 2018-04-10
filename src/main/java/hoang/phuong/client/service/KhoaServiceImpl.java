package hoang.phuong.client.service;

import hoang.phuong.client.model.Khoa;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(readOnly = true)
public class KhoaServiceImpl extends AbstractService<Khoa> implements KhoaService {


    @Override
    public Khoa getKhoa() {
        return getObject("/khoa/1");
    }

    @Override
    public List<Khoa> getListKhoa() {
        return getListEntity("khoa");
    }
}
