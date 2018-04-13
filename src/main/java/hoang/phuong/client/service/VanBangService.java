package hoang.phuong.client.service;

import hoang.phuong.client.model.Vanbang;

import java.util.List;

public interface VanBangService {
    void saveVanBang(Vanbang vanbang);
    void deleteVanBang(String maVanBang);
    void updateVangBang(Vanbang vanbang);
    Vanbang getByMaVanBang(String maVanBang);
    List<Vanbang> lsitVB();
}
