package hoang.phuong.client.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "giayto")
@JsonSerialize(include = JsonSerialize.Inclusion.ALWAYS)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Giayto {
    @JsonProperty(value = "id")
    private int id;
    @JsonProperty(value = "tenGiayTo")
    private String tenGiayTo;
    @JsonProperty(value = "maGiayTo")
    private String maGiayTo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenGiayTo() {
        return tenGiayTo;
    }

    public void setTenGiayTo(String tenGiayTo) {
        this.tenGiayTo = tenGiayTo;
    }

    public String getMaGiayTo() {
        return maGiayTo;
    }

    public void setMaGiayTo(String maGiayTo) {
        this.maGiayTo = maGiayTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Giayto giayto = (Giayto) o;

        if (id != giayto.id) return false;
        if (tenGiayTo != null ? !tenGiayTo.equals(giayto.tenGiayTo) : giayto.tenGiayTo != null) return false;
        if (maGiayTo != null ? !maGiayTo.equals(giayto.maGiayTo) : giayto.maGiayTo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (tenGiayTo != null ? tenGiayTo.hashCode() : 0);
        result = 31 * result + (maGiayTo != null ? maGiayTo.hashCode() : 0);
        return result;
    }
}
