package hoang.phuong.client.service;

import hoang.phuong.client.model.Nganhdaotao;

import java.util.List;

public interface NganhDaoTaoService {
    void saveNganh(Nganhdaotao nganhdaotao);
    void updateNganh(Nganhdaotao nganhdaotao);
    void deleteNganh(String maNganh);
    Nganhdaotao getByMaNganh(String maNganh);
    List<Nganhdaotao> listNganhDT();
}
