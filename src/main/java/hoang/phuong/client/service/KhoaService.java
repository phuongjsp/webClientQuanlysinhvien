package hoang.phuong.client.service;

import hoang.phuong.client.model.Khoa;

import java.util.List;

public interface KhoaService {
    Khoa getKhoaByMaKhoa(String maKhoa);

    List<Khoa> getListKhoa();

    boolean saveKhoa(Khoa khoa);

    void deleteKhoa(int id);

    void update(Khoa khoa);
}
