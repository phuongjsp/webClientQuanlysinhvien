package hoang.phuong.client.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="khoa")
@JsonSerialize(include=JsonSerialize.Inclusion.ALWAYS)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Khoa {
    @JsonProperty(value = "id")
    private Integer id;
    @JsonProperty(value = "tenKhoa")
    private String tenKhoa;
    @JsonProperty(value = "maKhoa")
    private String maKhoa;
    @JsonProperty(value = "namHoc")
    private String namHoc;
    @JsonProperty(value = "ghiChu")
    private String ghiChu;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int o) {
        this.id = id;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @Override
    public String toString() {
        return "{khoa:{" +
                "id=" + id +
                ", tenKhoa='" + tenKhoa + '\'' +
                ", maKhoa='" + maKhoa + '\'' +
                ", namHoc='" + namHoc + '\'' +
                ", ghiChu='" + ghiChu + '\'' +
                 "}}";
    }
}
