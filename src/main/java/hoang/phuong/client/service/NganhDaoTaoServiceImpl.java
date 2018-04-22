package hoang.phuong.client.service;

import hoang.phuong.client.model.Nganhdaotao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class NganhDaoTaoServiceImpl extends AbstractService<Nganhdaotao> implements NganhDaoTaoService {
    @Override
    public Nganhdaotao saveNganh(Nganhdaotao nganhdaotao) {
        return saveAndReturnId("nganhdaotao", nganhdaotao);
    }

    @Override
    public boolean updateNganh(Nganhdaotao nganhdaotao) {
        return update("nganhdaotao/id-" + nganhdaotao.getId(), nganhdaotao);
    }

    @Override
    public boolean deleteNganh(String maNganh) {
        return delete("nganhdaotao/maNganh-" + maNganh);
    }

    @Override
    public Nganhdaotao getByMaNganh(String maNganh) {
        return getObject("nganhdaotao/maNganh-" + maNganh);
    }

    @Override
    public List<Nganhdaotao> listNganhDT() {
        return getListEntity("nganhdaotao");
    }
}
