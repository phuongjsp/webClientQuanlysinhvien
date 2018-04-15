package hoang.phuong.client.service;

import hoang.phuong.client.model.Diachi;

import java.util.List;

public interface DiaChiService {
    Diachi saveDiaChi(Diachi diachi);

    void updateDiaChi(Diachi diachi);

    void deleteDiaChi(int id);

    Diachi getByIdDiaChi(int id);

    List<Diachi> listDiaChi();

    List<Diachi> listByPropertiesDiaChi(Diachi diachi);
}
