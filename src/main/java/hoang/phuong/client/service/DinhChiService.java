package hoang.phuong.client.service;

import hoang.phuong.client.model.Dinhchisinhvien;

import java.util.List;
import java.util.Map;

public interface DinhChiService {
    Dinhchisinhvien saveDinhchisinhvien(Map<String, Object> mapSave);

    List<Dinhchisinhvien> findAllDinhchisinhvien();

    List<Dinhchisinhvien> listConDinhChi();

    Dinhchisinhvien getOneDinhchisinhvien(int id);

    boolean updateDinhchisinhvien(Map<String, Object> mapUpdate);

    boolean deleteDinhchisinhvien(int id);
}
