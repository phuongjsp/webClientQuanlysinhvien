package hoang.phuong.client.service;

import hoang.phuong.client.model.Thongtingiadinh;

import java.util.List;

public interface ThongtingiadinhService {
    Thongtingiadinh saveTTGD(Thongtingiadinh thongtingiadinh);

    boolean updateTTGD(Thongtingiadinh thongtingiadinh);

    boolean deleteTTGD(int id);

    List<Thongtingiadinh> listByIdSv(int idSv);

    Thongtingiadinh getById(int id);
}
