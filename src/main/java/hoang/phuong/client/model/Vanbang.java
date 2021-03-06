package hoang.phuong.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dinhchisinhvien")
@JsonSerialize(include = JsonSerialize.Inclusion.ALWAYS)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vanbang {
    @JsonProperty(value = "id")
    private int id;
    @JsonProperty(value = "maVanBang")
    private String maVanBang;
    @JsonProperty(value = "tenVanBang")
    private String tenVanBang;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaVanBang() {
        return maVanBang;
    }

    public void setMaVanBang(String maVanBang) {
        this.maVanBang = maVanBang;
    }

    public String getTenVanBang() {
        return tenVanBang;
    }

    public void setTenVanBang(String tenVanBang) {
        this.tenVanBang = tenVanBang;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vanbang vanbang = (Vanbang) o;

        if (id != vanbang.id) return false;
        if (maVanBang != null ? !maVanBang.equals(vanbang.maVanBang) : vanbang.maVanBang != null) return false;
        if (tenVanBang != null ? !tenVanBang.equals(vanbang.tenVanBang) : vanbang.tenVanBang != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (maVanBang != null ? maVanBang.hashCode() : 0);
        result = 31 * result + (tenVanBang != null ? tenVanBang.hashCode() : 0);
        return result;
    }
}
