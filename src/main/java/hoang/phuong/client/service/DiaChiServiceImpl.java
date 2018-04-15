package hoang.phuong.client.service;

import hoang.phuong.client.model.Diachi;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class DiaChiServiceImpl extends AbstractService<Diachi> implements DiaChiService {
    @Override
    public Diachi saveDiaChi(Diachi diachi) {
        return saveAndReturnId("diachi", diachi);
    }

    @Override
    public void updateDiaChi(Diachi diachi) {
        update("diachi/" + diachi.getId(), diachi);
    }

    @Override
    public void deleteDiaChi(int id) {
        delete("diachi/" + id);
    }

    @Override
    public Diachi getByIdDiaChi(int id) {
        return getObject("diachi/" + id);
    }

    @Override
    public List<Diachi> listDiaChi() {
        return getListEntity("diachi");
    }

    @Override
    public List<Diachi> listByPropertiesDiaChi(Diachi diachi) {
        Map<String, String> map = new LinkedHashMap<>();
        if (diachi.getTinh().length() == 0) map.put("tinh", diachi.getTinh());
        if (diachi.getQuanHuyen().length() == 0) map.put("quanHuyen", diachi.getQuanHuyen());
        if (diachi.getXaPhuong().length() == 0) map.put("xaPhuong", diachi.getXaPhuong());
        if (diachi.getThonXom().length() == 0) map.put("thonXom", diachi.getThonXom());
        return getListByProperties("diachi/fliter", map);
    }
}
