package hoang.phuong.client.service;

import hoang.phuong.client.model.Thongtinsinhvien;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class ThongTinSinhVienServiceImpl extends AbstractService<Thongtinsinhvien> implements ThongTinSinhVienService {
    @Override
    public Thongtinsinhvien saveTT(Map<String, String> map) {
        return saveByMap("thongtinsinhvien", covertMap(map));
    }

    @Override
    public Thongtinsinhvien saveTTSV(Thongtinsinhvien thongtinsinhvien) {
        return saveAndReturnId("thongtinsinhvien", thongtinsinhvien);
    }

    private Map<String, Object> covertMap(Map<String, String> map) {
        Map<String, Object> mapcall = new LinkedHashMap<>();
        mapcall.putAll(map);
        mapcall.forEach((k, v) -> {
            if (k.equals("gioiTinh")) mapcall.replace(k, Byte.valueOf(v.toString()));
            if (k.equals("nganhDk") || k.equals("khoaHoc") || k.equals("lop") ||
                    k.equals("noiSinh") || k.equals("hoKhauThuongChu") || k.equals("id")

                    ) {
                try {
                    Float x = Float.valueOf(v.toString());
                    int y = x.intValue();
                    mapcall.replace(k, y);
                } catch (Exception ex) {
                }
            }
        });
        return mapcall;
    }

    @Override
    public boolean updateTT(Map<String, String> map) {
        Map<String, Object> mapcall = covertMap(map);
        return updateByMap("thongtinsinhvien/" + mapcall.get("id"), mapcall);
    }

    @Override
    public boolean deleteByMaSv(String maSv) {
        return delete("thongtinsinhvien/maSV-" + maSv);
    }

    @Override
    public Thongtinsinhvien getByMaSv(String maSv) {
        return getObject("thongtinsinhvien/maSV-" + maSv);
    }

    @Override
    public Thongtinsinhvien getbyId(int id) {
        Thongtinsinhvien thongtinsinhvien = getObject("thongtinthem/" + id);
        return thongtinsinhvien;
    }

    @Override
    public List<Thongtinsinhvien> listOrderBy(List<Map<String, Object>> mapOrder, int min, int max) {

        return getListByListProperties("thongtinsinhvien/fliter/" + min + "/" + max, mapOrder);
    }
}
