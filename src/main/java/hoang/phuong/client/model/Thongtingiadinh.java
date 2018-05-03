package hoang.phuong.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dinhchisinhvien")
@JsonSerialize(include = JsonSerialize.Inclusion.ALWAYS)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Thongtingiadinh {
    @JsonProperty(value = "id")
    private int id;
    @JsonProperty(value = "idSv")
    private int idSv;
    @JsonProperty(value = "quanHe")
    private String quanHe;
    @JsonProperty(value = "ten")
    private String ten;
    @JsonProperty(value = "sdt")
    private String sdt;
    @JsonProperty(value = "ngheNghiep")
    private String ngheNghiep;

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

    public String getQuanHe() {
        return quanHe;
    }

    public void setQuanHe(String quanHe) {
        this.quanHe = quanHe;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Thongtingiadinh that = (Thongtingiadinh) o;

        if (id != that.id) return false;
        if (idSv != that.idSv) return false;
        if (quanHe != null ? !quanHe.equals(that.quanHe) : that.quanHe != null) return false;
        if (ten != null ? !ten.equals(that.ten) : that.ten != null) return false;
        if (sdt != null ? !sdt.equals(that.sdt) : that.sdt != null) return false;
        if (ngheNghiep != null ? !ngheNghiep.equals(that.ngheNghiep) : that.ngheNghiep != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idSv;
        result = 31 * result + (quanHe != null ? quanHe.hashCode() : 0);
        result = 31 * result + (ten != null ? ten.hashCode() : 0);
        result = 31 * result + (sdt != null ? sdt.hashCode() : 0);
        result = 31 * result + (ngheNghiep != null ? ngheNghiep.hashCode() : 0);
        return result;
    }
}
