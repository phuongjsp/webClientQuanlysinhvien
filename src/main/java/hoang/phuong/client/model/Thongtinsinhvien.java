package hoang.phuong.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Thongtinsinhvien {
    private Integer id;
    private String maSv;
    private String ho;
    private String ten;
    private Date ngayVaoHoc;
    private Khoa khoaHoc;
    private Date ngaySinh;
    private Integer nganhDk;
    private String anhThe;
    private Byte gioiTinh;
    private String danToc;
    private Diachi noiSinh;
    private Diachi hoKhauThuongChu;
    private Lopsv lop;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgayVaoHoc() {
        return ngayVaoHoc;
    }

    public void setNgayVaoHoc(Date ngayVaoHoc) {
        this.ngayVaoHoc = ngayVaoHoc;
    }

    public Khoa getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(Khoa khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Integer getNganhDk() {
        return nganhDk;
    }

    public void setNganhDk(Integer nganhDk) {
        this.nganhDk = nganhDk;
    }

    public String getAnhThe() {
        return anhThe;
    }

    public void setAnhThe(String anhThe) {
        this.anhThe = anhThe;
    }

    public Byte getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Byte gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDanToc() {
        return danToc;
    }

    public void setDanToc(String danToc) {
        this.danToc = danToc;
    }

    public Diachi getNoiSinh() {
        return noiSinh;
    }

    public void setNoiSinh(Diachi noiSinh) {
        this.noiSinh = noiSinh;
    }

    public Diachi getHoKhauThuongChu() {
        return hoKhauThuongChu;
    }

    public void setHoKhauThuongChu(Diachi hoKhauThuongChu) {
        this.hoKhauThuongChu = hoKhauThuongChu;
    }

    public Lopsv getLop() {
        return lop;
    }

    public void setLop(Lopsv lop) {
        this.lop = lop;
    }

    @Override
    public String toString() {
        return "Thongtinsinhvien{" +
                "id=" + id +
                ", maSv='" + maSv + '\'' +
                ", ho='" + ho + '\'' +
                ", ten='" + ten + '\'' +
                ", ngayVaoHoc=" + ngayVaoHoc +
                ", khoaHoc=" + khoaHoc +
                ", ngaySinh=" + ngaySinh +
                ", nganhDk=" + nganhDk +
                ", anhThe='" + anhThe + '\'' +
                ", gioiTinh=" + gioiTinh +
                ", danToc='" + danToc + '\'' +
                ", noiSinh=" + noiSinh +
                ", hoKhauThuongChu=" + hoKhauThuongChu +
                ", lop=" + lop +
                '}';
    }
}