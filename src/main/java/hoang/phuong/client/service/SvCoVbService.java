package hoang.phuong.client.service;

import hoang.phuong.client.model.Svcovb;

import java.util.List;

public interface SvCoVbService {
    void saveSvCoVb(Svcovb svcovb);

    void deleteSvCoVb(int id);

    void updateSvCoVb(Svcovb svcovb);

    Svcovb getById(int id);

    List<Svcovb> listByMaSv(String maSv);

    List<Svcovb> listByMaSvMaVb(String maSv, String maVb);

    List<Svcovb> listBymaVb(String maVb);

    List<Integer> listidSvBymaVb(String maVb);
}
