package hoang.phuong.client.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Khoa {
    @JsonProperty(value="id")
    private Integer id;
    @JsonProperty(value="tenKhoa")
    private String tenKhoa;
    @JsonProperty(value="maKhoa")
    private String maKhoa;
    @JsonProperty(value="namHoc")
    private String namHoc;
    @JsonProperty(value="ghiChu")
    private String ghiChu;

    public void setId(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        return "Khoa{" +
                "id=" + id +
                ", tenKhoa='" + tenKhoa + '\'' +
                ", maKhoa='" + maKhoa + '\'' +
                ", namHoc='" + namHoc + '\'' +
                ", ghiChu='" + ghiChu + '\'' +
                '}';
    }
}
