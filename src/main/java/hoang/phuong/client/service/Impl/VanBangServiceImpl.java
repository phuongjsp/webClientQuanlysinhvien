package hoang.phuong.client.service.Impl;

import hoang.phuong.client.model.Vanbang;
import hoang.phuong.client.service.VanBangService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class VanBangServiceImpl extends AbstractService<Vanbang> implements VanBangService {
    public VanBangServiceImpl(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    public Vanbang saveVanBang(Vanbang vanbang) {
        return saveAndReturnId("qlsv/vanbang", vanbang);
    }

    @Override
    public boolean deleteVanBang(String maVanBang) {
        return delete("qlsv/vanbang/maVB-" + maVanBang);
    }

    @Override
    public boolean updateVangBang(Vanbang vanbang) {
        return update("qlsv/vanbang/update", vanbang);
    }

    @Override
    public Vanbang getByMaVanBang(String maVanBang) {
        return getObject("qlsv/vanbang/maVB-" + maVanBang);
    }

    @Override
    public List<Vanbang> lsitVB() {
        return getListEntity("qlsv/vanbang");
    }
}
