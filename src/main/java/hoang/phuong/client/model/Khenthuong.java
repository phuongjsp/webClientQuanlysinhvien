package hoang.phuong.client.model;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dinhchisinhvien")
@JsonSerialize(include = JsonSerialize.Inclusion.ALWAYS)
@org.codehaus.jackson.annotate.JsonIgnoreProperties(ignoreUnknown = true)
public class Khenthuong {
    @JsonProperty(value = "id")
    private int id;
    @JsonProperty(value = "idSv")
    private int idSv;
    @JsonProperty(value = "lyDo")
    private String lyDo;
    @JsonProperty(value = "ngay")
    private Long ngay;
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

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public Long getNgay() {
        return ngay;
    }

    public void setNgay(Long ngay) {
        this.ngay = ngay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Khenthuong that = (Khenthuong) o;

        if (getId() != that.getId()) return false;
        if (getIdSv() != that.getIdSv()) return false;
        if (getLyDo() != null ? !getLyDo().equals(that.getLyDo()) : that.getLyDo() != null) return false;
        return getNgay() != null ? getNgay().equals(that.getNgay()) : that.getNgay() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getIdSv();
        result = 31 * result + (getLyDo() != null ? getLyDo().hashCode() : 0);
        result = 31 * result + (getNgay() != null ? getNgay().hashCode() : 0);
        return result;
    }
}
