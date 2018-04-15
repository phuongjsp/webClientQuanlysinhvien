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
    public void saveTT(Map<String, String> map) {

//can not cast java.util.Date to java.sql.Data then I'm using map
//        Thongtinsinhvien thongtinsinhvien = new Thongtinsinhvien();
//        thongtinsinhvien.setMaSv(map.get("maSv").toString());
//        thongtinsinhvien.setHo(map.get("ho").toString());
//        thongtinsinhvien.setTen(map.get("ten").toString());
//        thongtinsinhvien.setAnhThe(map.get("anhThe").toString());
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            Date ngaySinh = sdf.parse(map.get("ngaySinh").toString());
//            thongtinsinhvien.setNgaySinh(new java.sql.Date(ngaySinh.getTime()));
//            Date ngayVaoHoc = sdf.parse(map.get("ngayVaoHoc").toString());
//            thongtinsinhvien.setNgayVaoHoc(  new java.sql.Date(ngayVaoHoc.getTime())) ;
//            int gioiTinh = Integer.valueOf(String.valueOf(map.get("gioiTinh")));
//            thongtinsinhvien.setGioiTinh((byte) (gioiTinh==0?1:0));
//            float nganhdk = Float.valueOf(String.valueOf(map.get("nganhDk")));
//            thongtinsinhvien.setNganhDk((int) nganhdk);
//            float khoahoc =Float.valueOf(String.valueOf(map.get("khoaHoc")));
//            thongtinsinhvien.setKhoaHoc((int)khoahoc);
//            float lop =Float.valueOf(String.valueOf(map.get("lop")));
//            thongtinsinhvien.setLop((int)lop);
//            float noiSinh =Float.valueOf(String.valueOf(map.get("noisinh")));
//            thongtinsinhvien.setNoiSinh((int) noiSinh);
//            float hoKhauThuongChu =Float.valueOf(String.valueOf(map.get("hoKhauThuongChu")));
//            thongtinsinhvien.setHoKhauThuongChu((int) hoKhauThuongChu);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//
//        thongtinsinhvien.setDanToc(map.get("danToc").toString());
//        System.out.println(thongtinsinhvien);
//        save("thongtinsinhvien",thongtinsinhvien);
        saveByMap("thongtinsinhvien", covertMap(map));
    }

    Map<String, Object> covertMap(Map<String, String> map) {
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
    public void updateTT(Map<String, String> map) {
        Map<String, Object> mapcall = covertMap(map);
        updateByMap("thongtinsinhvien/" + mapcall.get("id"), mapcall);
    }

    @Override
    public void deleteByMaSv(String maSv) {
        delete("thongtinsinhvien/maSV-" + maSv);
    }

    @Override
    public Thongtinsinhvien getByMaSv(String maSv) {
        return getObject("thongtinsinhvien/maSV-" + maSv);
    }

    @Override
    public List<Thongtinsinhvien> listOrderBy(List<Map<String, Object>> mapOrder, int min, int max) {
        return getListByListProperties("thongtinsinhvien/fliter/" + min + "/" + max, mapOrder);
    }
}
