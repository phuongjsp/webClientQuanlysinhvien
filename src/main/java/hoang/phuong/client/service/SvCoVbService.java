package hoang.phuong.client.service;

import hoang.phuong.client.model.Svcovb;

import java.util.List;

public interface SvCoVbService {
    Svcovb saveSvCoVb(Svcovb svcovb);

    boolean deleteSvCoVb(int id);

    boolean updateSvCoVb(Svcovb svcovb);

    Svcovb getById(int id);

    List<Svcovb> listByMaSv(String maSv);

    List<Svcovb> listByMaSvMaVb(String maSv, String maVb);

    List<Svcovb> listBymaVb(String maVb);

    List<Integer> listidSvBymaVb(String maVb);
}
