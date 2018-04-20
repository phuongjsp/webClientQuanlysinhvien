package hoang.phuong.client.service;

import hoang.phuong.client.model.Giayto;

import java.util.List;

public interface GiayToService {
    Giayto saveGiayto(Giayto giayto);

    boolean updateGiayto(Giayto giayto);

    boolean deleteGiayto(int id);

    Giayto getById(int id);

    Giayto getByMaGT(String maGT);

    List<Giayto> listGiayto();

    List<Giayto> listGiayToSinhVienKhongCo(String maSv);
}
