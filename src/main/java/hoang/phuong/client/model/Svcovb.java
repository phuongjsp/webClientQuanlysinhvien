package hoang.phuong.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Svcovb {
    private int id;
    private int idSv;
    private int loaiVb;
    private String tenThuocTinh;
    private String thuocTinh;

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

    public int getLoaiVb() {
        return loaiVb;
    }

    public void setLoaiVb(int loaiVb) {
        this.loaiVb = loaiVb;
    }

    public String getTenThuocTinh() {
        return tenThuocTinh;
    }

    public void setTenThuocTinh(String tenThuocTinh) {
        this.tenThuocTinh = tenThuocTinh;
    }

    public String getThuocTinh() {
        return thuocTinh;
    }

    public void setThuocTinh(String thuocTinh) {
        this.thuocTinh = thuocTinh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Svcovb svcovb = (Svcovb) o;

        if (id != svcovb.id) return false;
        if (idSv != svcovb.idSv) return false;
        if (loaiVb != svcovb.loaiVb) return false;
        if (tenThuocTinh != null ? !tenThuocTinh.equals(svcovb.tenThuocTinh) : svcovb.tenThuocTinh != null)
            return false;
        if (thuocTinh != null ? !thuocTinh.equals(svcovb.thuocTinh) : svcovb.thuocTinh != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idSv;
        result = 31 * result + loaiVb;
        result = 31 * result + (tenThuocTinh != null ? tenThuocTinh.hashCode() : 0);
        result = 31 * result + (thuocTinh != null ? thuocTinh.hashCode() : 0);
        return result;
    }
}
