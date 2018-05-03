package hoang.phuong.client.model;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dinhchisinhvien")
@JsonSerialize(include = JsonSerialize.Inclusion.ALWAYS)
@org.codehaus.jackson.annotate.JsonIgnoreProperties(ignoreUnknown = true)
public class Dinhchisinhvien {
    @JsonProperty(value = "id")
    private int id;
    @JsonProperty(value = "idSv")
    private int idSv;
    @JsonProperty(value = "id")
    private String lyDo;
    @JsonProperty(value = "tuNgay")
    private Long tuNgay;
    @JsonProperty(value = "denNgay")
    private Long denNgay;
    private Thongtinsinhvien thongtinsinhvienbyDinhchisinhvien;

    public Thongtinsinhvien getThongtinsinhvienbyDinhchisinhvien() {
        return thongtinsinhvienbyDinhchisinhvien;
    }

    public void setThongtinsinhvienbyDinhchisinhvien(Thongtinsinhvien thongtinsinhvienbyDinhchisinhvien) {
        this.thongtinsinhvienbyDinhchisinhvien = thongtinsinhvienbyDinhchisinhvien;
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

    public Long getTuNgay() {
        return tuNgay;
    }

    public void setTuNgay(Long tuNgay) {
        this.tuNgay = tuNgay;
    }

    public Long getDenNgay() {
        return denNgay;
    }

    public void setDenNgay(Long denNgay) {
        this.denNgay = denNgay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dinhchisinhvien that = (Dinhchisinhvien) o;

        if (getId() != that.getId()) return false;
        if (getIdSv() != that.getIdSv()) return false;
        if (getLyDo() != null ? !getLyDo().equals(that.getLyDo()) : that.getLyDo() != null) return false;
        if (getTuNgay() != null ? !getTuNgay().equals(that.getTuNgay()) : that.getTuNgay() != null) return false;
        return getDenNgay() != null ? getDenNgay().equals(that.getDenNgay()) : that.getDenNgay() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getIdSv();
        result = 31 * result + (getLyDo() != null ? getLyDo().hashCode() : 0);
        result = 31 * result + (getTuNgay() != null ? getTuNgay().hashCode() : 0);
        result = 31 * result + (getDenNgay() != null ? getDenNgay().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Dinhchisinhvien{" +
                "id=" + id +
                ", idSv=" + idSv +
                ", lyDo='" + lyDo + '\'' +
                ", tuNgay=" + tuNgay +
                ", denNgay=" + denNgay +
                ", thongtinsinhvienbyDinhchisinhvien=" + thongtinsinhvienbyDinhchisinhvien +
                '}';
    }
}
