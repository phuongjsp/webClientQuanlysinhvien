package hoang.phuong.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dinhchisinhvien")
@JsonSerialize(include = JsonSerialize.Inclusion.ALWAYS)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Nganhdaotao {
    @JsonProperty(value = "id")
    private Integer id;
    @JsonProperty(value = "tenNganh")
    private String tenNganh;
    @JsonProperty(value = "maNganh")
    private String maNganh;
    @JsonProperty(value = "khoa")
    private String khoa;
    @JsonProperty(value = "ghiChu")
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

    public String getTenNganh() {
        return tenNganh;
    }

    public void setTenNganh(String tenNganh) {
        this.tenNganh = tenNganh;
    }

    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Nganhdaotao that = (Nganhdaotao) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (tenNganh != null ? !tenNganh.equals(that.tenNganh) : that.tenNganh != null) return false;
        if (maNganh != null ? !maNganh.equals(that.maNganh) : that.maNganh != null) return false;
        if (khoa != null ? !khoa.equals(that.khoa) : that.khoa != null) return false;
        if (ghiChu != null ? !ghiChu.equals(that.ghiChu) : that.ghiChu != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (tenNganh != null ? tenNganh.hashCode() : 0);
        result = 31 * result + (maNganh != null ? maNganh.hashCode() : 0);
        result = 31 * result + (khoa != null ? khoa.hashCode() : 0);
        result = 31 * result + (ghiChu != null ? ghiChu.hashCode() : 0);
        return result;
    }


}
