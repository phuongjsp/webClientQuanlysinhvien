package hoang.phuong.client.service;

import hoang.phuong.client.model.Lopsv;

import java.util.List;

public interface   LopService {
    void saveLop(Lopsv lopsv);
    void deleteLop(String maLop);
    void updateLop(Lopsv lopsv);
    Lopsv getByMaLop(String maLop);
    List<Lopsv> listLop();
}
