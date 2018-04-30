package hoang.phuong.client.service.Impl;

import hoang.phuong.client.model.Nganhdaotao;
import hoang.phuong.client.service.NganhDaoTaoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class NganhDaoTaoServiceImpl extends AbstractService<Nganhdaotao> implements NganhDaoTaoService {
    public NganhDaoTaoServiceImpl(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    public Nganhdaotao saveNganh(Nganhdaotao nganhdaotao) {
        return saveAndReturnId("qlsv/nganhdaotao", nganhdaotao);
    }

    @Override
    public boolean updateNganh(Nganhdaotao nganhdaotao) {
        return update("qlsv/nganhdaotao", nganhdaotao);
    }

    @Override
    public boolean deleteNganh(String maNganh) {
        return delete("qlsv/nganhdaotao/maNganh-" + maNganh);
    }

    @Override
    public Nganhdaotao getByMaNganh(String maNganh) {
        return getObject("qlsv/nganhdaotao/maNganh-" + maNganh);
    }

    @Override
    public List<Nganhdaotao> listNganhDT() {
        return getListEntity("qlsv/nganhdaotao");
    }
}
