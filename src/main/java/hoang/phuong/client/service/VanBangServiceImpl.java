package hoang.phuong.client.service;

import hoang.phuong.client.model.Vanbang;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class VanBangServiceImpl extends AbstractService<Vanbang> implements VanBangService {
    @Override
    public void saveVanBang(Vanbang vanbang) {
        save("vanbang", vanbang);
    }

    @Override
    public void deleteVanBang(String maVanBang) {
        delete("vanbang/maVB-" + maVanBang);
    }

    @Override
    public void updateVangBang(Vanbang vanbang) {
        update("vanbang/update", vanbang);
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
