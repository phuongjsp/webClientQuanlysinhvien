package hoang.phuong.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dinhchisinhvien")
@JsonSerialize(include = JsonSerialize.Inclusion.ALWAYS)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Lopsv {
    @JsonProperty(value = "id")
    private Integer id;
    @JsonProperty(value = "maLop")
    private String maLop;
    @JsonProperty(value = "tenLop")
    private String tenLop;

    public void setId(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lopsv lopsv = (Lopsv) o;

        if (id != null ? !id.equals(lopsv.id) : lopsv.id != null) return false;
        if (maLop != null ? !maLop.equals(lopsv.maLop) : lopsv.maLop != null) return false;
        if (tenLop != null ? !tenLop.equals(lopsv.tenLop) : lopsv.tenLop != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (maLop != null ? maLop.hashCode() : 0);
        result = 31 * result + (tenLop != null ? tenLop.hashCode() : 0);
        return result;
    }


}
