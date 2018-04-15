package hoang.phuong.client.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Diachi {
    private Integer id;
    private String tinh;
    private String quanHuyen;
    private String xaPhuong;
    private String thonXom;

    public void setId(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTinh() {
        return tinh;
    }

    public void setTinh(String tinh) {
        this.tinh = tinh;
    }

    public String getQuanHuyen() {
        return quanHuyen;
    }

    public void setQuanHuyen(String quanHuyen) {
        this.quanHuyen = quanHuyen;
    }

    public String getXaPhuong() {
        return xaPhuong;
    }

    public void setXaPhuong(String xaPhuong) {
        this.xaPhuong = xaPhuong;
    }

    public String getThonXom() {
        return thonXom;
    }

    public void setThonXom(String thonXom) {
        this.thonXom = thonXom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Diachi diachi = (Diachi) o;

        if (id != null ? !id.equals(diachi.id) : diachi.id != null) return false;
        if (tinh != null ? !tinh.equals(diachi.tinh) : diachi.tinh != null) return false;
        if (quanHuyen != null ? !quanHuyen.equals(diachi.quanHuyen) : diachi.quanHuyen != null) return false;
        if (xaPhuong != null ? !xaPhuong.equals(diachi.xaPhuong) : diachi.xaPhuong != null) return false;
        if (thonXom != null ? !thonXom.equals(diachi.thonXom) : diachi.thonXom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (tinh != null ? tinh.hashCode() : 0);
        result = 31 * result + (quanHuyen != null ? quanHuyen.hashCode() : 0);
        result = 31 * result + (xaPhuong != null ? xaPhuong.hashCode() : 0);
        result = 31 * result + (thonXom != null ? thonXom.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getTinh() + " - " + getQuanHuyen() + " - " + getXaPhuong() + " - " + getThonXom();
    }
}
