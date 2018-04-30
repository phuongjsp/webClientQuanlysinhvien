package hoang.phuong.client.service.Impl;

import hoang.phuong.client.model.Diachi;
import hoang.phuong.client.service.DiaChiService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@Transactional(readOnly = true)
public class DiaChiServiceImpl extends AbstractService<Diachi> implements DiaChiService {


    public DiaChiServiceImpl(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    public Diachi saveDiaChi(Diachi diachi) {
        return saveAndReturnId("qlsv/diachi", diachi);
    }

    @Override
    public boolean updateDiaChi(Diachi diachi) {
        return update("qlsv/diachi", diachi);
    }


    @Override
    public boolean deleteDiaChi(int id) {
        return delete("qlsv/diachi/" + id);
    }

    @Override
    public Diachi getByIdDiaChi(int id) {
        return getObject("qlsv/diachi/" + id);
    }


}
