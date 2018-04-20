package hoang.phuong.client.service;

import hoang.phuong.client.model.Sinhviencogiayto;

import java.util.List;

public interface SinhviencogiaytoService {
    Sinhviencogiayto getbyId(int id);

    Sinhviencogiayto save(Sinhviencogiayto sinhviencogiayto);

    boolean update(Sinhviencogiayto sinhviencogiayto);

    boolean delete(int id);

    List<Sinhviencogiayto> listByMaSv(String maSv);
}
