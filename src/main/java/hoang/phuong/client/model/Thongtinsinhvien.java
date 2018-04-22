package hoang.phuong.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Thongtinsinhvien {
    @JsonProperty(value = "id")
    private Integer id;
    @JsonProperty(value = "maSv")
    private String maSv;
    @JsonProperty(value = "ho")
    private String ho;
    @JsonProperty(value = "ten")
    private String ten;
    @JsonProperty(value = "ngayVaoHoc")
    private Date ngayVaoHoc;
    @JsonProperty(value = "khoaHoc")
    private Integer khoaHoc;
    @JsonProperty(value = "ngaySinh")
    private Date ngaySinh;
    @JsonProperty(value = "nganhDk")
    private Integer nganhDk;
    @JsonProperty(value = "anhThe")
    private String anhThe;
    @JsonProperty(value = "gioiTinh")
    private Integer gioiTinh;
    @JsonProperty(value = "ngaySinh")
    private String danToc;
    @JsonProperty(value = "noiSinh")
    private Integer noiSinh;
    @JsonProperty(value = "hoKhauThuongChu")
    private Integer hoKhauThuongChu;
    @JsonProperty(value = "lop")
    private Integer lop;
    private Khoa khoaByKhoaHoc;
    private Nganhdaotao nganhdaotaoByNganhDk;
    private Diachi diachiByNoiSinh;
    private Diachi diachiByHoKhauThuongChu;
    private Lopsv lopsvByLop;
    private List<Thongtinthem> thongtinthemList = new ArrayList<>();

    public List<Thongtinthem> getThongtinthemList() {
        return thongtinthemList;
    }

    public void setThongtinthemList(List<Thongtinthem> thongtinthemList) {
        this.thongtinthemList = thongtinthemList;
    }

    public Khoa getKhoaByKhoaHoc() {
        return khoaByKhoaHoc;
    }

    public void setKhoaByKhoaHoc(Khoa khoaByKhoaHoc) {
        this.khoaByKhoaHoc = khoaByKhoaHoc;
    }

    public Nganhdaotao getNganhdaotaoByNganhDk() {
        return nganhdaotaoByNganhDk;
    }

    public void setNganhdaotaoByNganhDk(Nganhdaotao nganhdaotaoByNganhDk) {
        this.nganhdaotaoByNganhDk = nganhdaotaoByNganhDk;
    }

    public Diachi getDiachiByNoiSinh() {
        return diachiByNoiSinh;
    }

    public void setDiachiByNoiSinh(Diachi diachiByNoiSinh) {
        this.diachiByNoiSinh = diachiByNoiSinh;
    }

    public Diachi getDiachiByHoKhauThuongChu() {
        return diachiByHoKhauThuongChu;
    }

    public void setDiachiByHoKhauThuongChu(Diachi diachiByHoKhauThuongChu) {
        this.diachiByHoKhauThuongChu = diachiByHoKhauThuongChu;
    }

    public Lopsv getLopsvByLop() {
        return lopsvByLop;
    }

    public void setLopsvByLop(Lopsv lopsvByLop) {
        this.lopsvByLop = lopsvByLop;
    }

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

    public Integer getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(Integer khoaHoc) {
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

    public Integer getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Integer gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDanToc() {
        return danToc;
    }

    public void setDanToc(String danToc) {
        this.danToc = danToc;
    }

    public Integer getNoiSinh() {
        return noiSinh;
    }

    public void setNoiSinh(Integer noiSinh) {
        this.noiSinh = noiSinh;
    }

    public Integer getHoKhauThuongChu() {
        return hoKhauThuongChu;
    }

    public void setHoKhauThuongChu(Integer hoKhauThuongChu) {
        this.hoKhauThuongChu = hoKhauThuongChu;
    }

    public Integer getLop() {
        return lop;
    }

    public void setLop(Integer lop) {
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