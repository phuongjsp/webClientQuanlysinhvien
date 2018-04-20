package hoang.phuong.client.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "sinhviencogiayto")
@JsonSerialize(include = JsonSerialize.Inclusion.ALWAYS)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sinhviencogiayto {
    @JsonProperty(value = "id")
    private int id;
    @JsonProperty(value = "idSv")
    private int idSv;
    @JsonProperty(value = "idGiayTo")
    private int idGiayTo;

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

    public int getIdGiayTo() {
        return idGiayTo;
    }

    public void setIdGiayTo(int idGiayTo) {
        this.idGiayTo = idGiayTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sinhviencogiayto that = (Sinhviencogiayto) o;

        if (id != that.id) return false;
        if (idSv != that.idSv) return false;
        if (idGiayTo != that.idGiayTo) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idSv;
        result = 31 * result + idGiayTo;
        return result;
    }
}
