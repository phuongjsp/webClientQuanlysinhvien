package hoang.phuong.client.service;

import hoang.phuong.client.model.Thongtinthem;

import java.util.List;

public interface ThongTinThemService {
    void saveTTT(Thongtinthem thongtinthem);

    void updateTTT(Thongtinthem thongtinthem);

    void deleteTTT(int id);

    Thongtinthem getbyId(int id);

    List<Thongtinthem> listByMaSv(String maSv);

    List<Thongtinthem> list();
}
