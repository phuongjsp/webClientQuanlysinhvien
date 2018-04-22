package hoang.phuong.client.service;

import hoang.phuong.client.model.Lopsv;

import java.util.List;

public interface LopService {
    Lopsv saveLop(Lopsv lopsv);

    Lopsv getbyId(int id);

    boolean deleteLop(String maLop);

    boolean updateLop(Lopsv lopsv);

    Lopsv getByMaLop(String maLop);

    List<Lopsv> listLop();
}
