package hoang.phuong.client.service;

import hoang.phuong.client.model.Khoa;

import java.util.List;

public interface KhoaService {
    Khoa getKhoaByMaKhoa(String maKhoa);

    List<Khoa> getListKhoa();

    Khoa saveKhoa(Khoa khoa);

    boolean deleteKhoa(int id);

    boolean update(Khoa khoa);
}
