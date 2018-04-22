package hoang.phuong.client.service;

import hoang.phuong.client.model.Thongtinthem;

import java.util.List;

public interface ThongTinThemService {
    Thongtinthem saveTTT(Thongtinthem thongtinthem);

    boolean updateTTT(Thongtinthem thongtinthem);

    boolean deleteTTT(int id);

    Thongtinthem getbyId(int id);

    List<Thongtinthem> listByMaSv(String maSv);

    List<Thongtinthem> list();
}
