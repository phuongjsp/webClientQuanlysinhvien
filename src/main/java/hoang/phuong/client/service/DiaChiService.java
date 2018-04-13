package hoang.phuong.client.service;

import hoang.phuong.client.model.Diachi;

import java.util.List;
import java.util.Map;

public interface DiaChiService {
    void saveDiaChi(Diachi diachi);
    void updateDiaChi(Diachi diachi);
    void deleteDiaChi(int id);
    Diachi getByIdDiaChi(int id);
    List<Diachi> listDiaChi();
    List<Diachi> listByPropertiesDiaChi(Diachi diachi);
}
