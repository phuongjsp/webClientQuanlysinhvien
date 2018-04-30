package hoang.phuong.client.service;

import hoang.phuong.client.model.Diachi;

public interface DiaChiService {
    Diachi saveDiaChi(Diachi diachi);

    boolean updateDiaChi(Diachi diachi);

    boolean deleteDiaChi(int id);

    Diachi getByIdDiaChi(int id);

}
