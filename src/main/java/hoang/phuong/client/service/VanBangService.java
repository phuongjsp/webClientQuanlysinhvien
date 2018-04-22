package hoang.phuong.client.service;

import hoang.phuong.client.model.Vanbang;

import java.util.List;

public interface VanBangService {
    Vanbang saveVanBang(Vanbang vanbang);

    boolean deleteVanBang(String maVanBang);

    boolean updateVangBang(Vanbang vanbang);

    Vanbang getByMaVanBang(String maVanBang);

    List<Vanbang> lsitVB();
}
