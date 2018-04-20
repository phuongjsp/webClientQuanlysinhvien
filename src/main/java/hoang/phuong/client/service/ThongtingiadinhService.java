package hoang.phuong.client.service;

import hoang.phuong.client.model.Thongtingiadinh;

import java.util.List;

public interface ThongtingiadinhService {
    void saveTTGD(Thongtingiadinh thongtingiadinh);

    void updateTTGD(Thongtingiadinh thongtingiadinh);

    void deleteTTGD(int id);

    List<Thongtingiadinh> listByIdSv(int idSv);

    Thongtingiadinh getById(int id);
}
