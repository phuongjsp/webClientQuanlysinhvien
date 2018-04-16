package hoang.phuong.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Thongtinthem {
    private int id;
    private int idSv;
    private String tenThongTin;
    private String thongTin;
    private Thongtinsinhvien thongtinsinhvien;

    public Thongtinsinhvien getThongtinsinhvien() {
        return thongtinsinhvien;
    }

    public void setThongtinsinhvien(Thongtinsinhvien thongtinsinhvien) {
        this.thongtinsinhvien = thongtinsinhvien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSv() {
        return idSv;
    }

    public void setIdSv(int idSv) {
        this.idSv = idSv;
    }

    public String getTenThongTin() {
        return tenThongTin;
    }

    public void setTenThongTin(String tenThongTin) {
        this.tenThongTin = tenThongTin;
    }

    public String getThongTin() {
        return thongTin;
    }

    public void setThongTin(String thongTin) {
        this.thongTin = thongTin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Thongtinthem that = (Thongtinthem) o;

        if (id != that.id) return false;
        if (idSv != that.idSv) return false;
        if (tenThongTin != null ? !tenThongTin.equals(that.tenThongTin) : that.tenThongTin != null) return false;
        if (thongTin != null ? !thongTin.equals(that.thongTin) : that.thongTin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idSv;
        result = 31 * result + (tenThongTin != null ? tenThongTin.hashCode() : 0);
        result = 31 * result + (thongTin != null ? thongTin.hashCode() : 0);
        return result;
    }
}
