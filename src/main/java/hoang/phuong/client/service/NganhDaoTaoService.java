package hoang.phuong.client.service;

import hoang.phuong.client.model.Nganhdaotao;

import java.util.List;

public interface NganhDaoTaoService {
    Nganhdaotao saveNganh(Nganhdaotao nganhdaotao);

    boolean updateNganh(Nganhdaotao nganhdaotao);

    boolean deleteNganh(String maNganh);

    Nganhdaotao getByMaNganh(String maNganh);

    List<Nganhdaotao> listNganhDT();
}
