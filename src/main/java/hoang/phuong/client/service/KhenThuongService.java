package hoang.phuong.client.service;

import hoang.phuong.client.model.Khenthuong;

import java.util.List;

public interface KhenThuongService {
    Khenthuong savekhenthuong(Khenthuong khenthuong);

    Khenthuong getbyId(int id);

    List<Khenthuong> listAll();

    List<Khenthuong> listByIdSv(int idSv);

    List<Khenthuong> listbyYear(String stDate, String endDate);

    boolean updatekhenthuong(Khenthuong khenthuong);

    boolean deletekhenthuong(int id);
}
