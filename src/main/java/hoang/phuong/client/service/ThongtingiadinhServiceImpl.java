package hoang.phuong.client.service;

import hoang.phuong.client.model.Thongtingiadinh;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ThongtingiadinhServiceImpl extends AbstractService<Thongtingiadinh> implements ThongtingiadinhService {
    @Override
    public Thongtingiadinh saveTTGD(Thongtingiadinh thongtingiadinh) {
        return saveAndReturnId("thongtingiadinh", thongtingiadinh);
    }

    @Override
    public boolean updateTTGD(Thongtingiadinh thongtingiadinh) {
        return update("thongtingiadinh/" + thongtingiadinh.getId(), thongtingiadinh);
    }

    @Override
    public boolean deleteTTGD(int id) {
        return delete("thongtingiadinh/" + id);
    }

    @Override
    public List<Thongtingiadinh> listByIdSv(int idSv) {
        return getListEntity("thongtingiadinh/IDSV-" + idSv);
    }

    @Override
    public Thongtingiadinh getById(int id) {
        return getObject("thongtingiadinh/" + id);
    }
}
