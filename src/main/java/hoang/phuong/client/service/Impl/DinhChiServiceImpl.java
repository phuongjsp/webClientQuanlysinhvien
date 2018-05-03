package hoang.phuong.client.service.Impl;

import hoang.phuong.client.model.Dinhchisinhvien;
import hoang.phuong.client.service.DinhChiService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service("DinhChiService")
@Transactional
public class DinhChiServiceImpl extends AbstractService<Dinhchisinhvien> implements DinhChiService {
    public DinhChiServiceImpl(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    public Dinhchisinhvien saveDinhchisinhvien(Map<String, Object> mapSave) {
        return saveByMap("qlsv/dinhchisinhvien", mapSave);
    }

    @Override
    public List<Dinhchisinhvien> findAllDinhchisinhvien() {
        return getListEntity("qlsv/dinhchisinhvien");
    }

    @Override
    public List<Dinhchisinhvien> listConDinhChi() {
        return getListEntity("qlsv/dinhchisinhvien/condinhchi");
    }

    @Override
    public Dinhchisinhvien getOneDinhchisinhvien(int id) {
        return getObject("qlsv/dinhchisinhvien/id/" + id);
    }

    @Override
    public boolean updateDinhchisinhvien(Map<String, Object> mapUpdate) {
        return updateByMap("qlsv/dinhchisinhvien", mapUpdate);
    }

    @Override
    public boolean deleteDinhchisinhvien(int id) {
        return delete("qlsv/dinhchisinhvien/" + id);
    }
}
