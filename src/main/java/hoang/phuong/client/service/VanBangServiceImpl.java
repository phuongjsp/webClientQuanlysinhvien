package hoang.phuong.client.service;

import hoang.phuong.client.model.Vanbang;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class VanBangServiceImpl extends AbstractService<Vanbang> implements VanBangService {
    @Override
    public Vanbang saveVanBang(Vanbang vanbang) {
        return saveAndReturnId("vanbang", vanbang);
    }

    @Override
    public boolean deleteVanBang(String maVanBang) {
        return delete("vanbang/maVB-" + maVanBang);
    }

    @Override
    public boolean updateVangBang(Vanbang vanbang) {
        return update("vanbang/update", vanbang);
    }

    @Override
    public Vanbang getByMaVanBang(String maVanBang) {
        return getObject("vanbang/maVB-" + maVanBang);
    }

    @Override
    public List<Vanbang> lsitVB() {
        return getListEntity("vanbang");
    }
}
