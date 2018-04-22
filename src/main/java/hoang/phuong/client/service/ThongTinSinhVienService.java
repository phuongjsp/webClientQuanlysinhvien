package hoang.phuong.client.service;

import hoang.phuong.client.model.Thongtinsinhvien;

import java.util.List;
import java.util.Map;

public interface ThongTinSinhVienService {
    Thongtinsinhvien saveTT(Map<String, String> map);

    Thongtinsinhvien saveTTSV(Thongtinsinhvien thongtinsinhvien);

    boolean updateTT(Map<String, String> map);

    boolean deleteByMaSv(String maSv);

    Thongtinsinhvien getByMaSv(String maSv);

    Thongtinsinhvien getbyId(int id);
    List<Thongtinsinhvien> listOrderBy(List<Map<String, Object>> mapOrder, int min, int max);
}
