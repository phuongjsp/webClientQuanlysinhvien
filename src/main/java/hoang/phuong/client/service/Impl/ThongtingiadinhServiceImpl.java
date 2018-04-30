package hoang.phuong.client.service.Impl;

import hoang.phuong.client.model.Thongtingiadinh;
import hoang.phuong.client.service.ThongtingiadinhService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ThongtingiadinhServiceImpl extends AbstractService<Thongtingiadinh> implements ThongtingiadinhService {
    public ThongtingiadinhServiceImpl(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    public Thongtingiadinh saveTTGD(Thongtingiadinh thongtingiadinh) {
        return saveAndReturnId("qlsv/thongtingiadinh", thongtingiadinh);
    }

    @Override
    public boolean updateTTGD(Thongtingiadinh thongtingiadinh) {
        return update("qlsv/thongtingiadinh", thongtingiadinh);
    }

    @Override
    public boolean deleteTTGD(int id) {
        return delete("qlsv/thongtingiadinh/" + id);
    }

    @Override
    public List<Thongtingiadinh> listByIdSv(int idSv) {
        return getListEntity("qlsv/thongtingiadinh/IDSV-" + idSv);
    }

    @Override
    public Thongtingiadinh getById(int id) {
        return getObject("qlsv/thongtingiadinh/" + id);
    }
}
