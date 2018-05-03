package hoang.phuong.client.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dinhchisinhvien")
@JsonSerialize(include = JsonSerialize.Inclusion.ALWAYS)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @JsonProperty(value = "id")
    private Integer id;
    @JsonProperty(value = "userName")
    private String userName;
    @JsonProperty(value = "userLastName")
    private String userLastName;
    @JsonProperty(value = "password")
    private String password;
    @JsonProperty(value = "email")
    private String email;
    @JsonProperty(value = "enabled")
    private Boolean enabled;
    @JsonProperty(value = "admin")
    private Boolean admin;
    @JsonProperty(value = "registered")
    private Long registered;

    public User() {
    }

    public User(Integer id, String userName, String userLastName, String password, String email,
                Boolean enabled, Boolean admin, Long registered) {
        this.id = id;
        this.userName = userName;
        this.userLastName = userLastName;
        this.password = password;
        this.email = email;
        this.enabled = enabled;
        this.admin = admin;
        this.registered = registered;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        admin = admin;
    }

    public Long getRegistered() {
        return registered;
    }

    public void setRegistered(Long registered) {
        this.registered = registered;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        User that = (User) o;
        return null != getId() && getId().equals(that.getId());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", enabled=" + enabled +
                ", admin=" + admin +
                ", registered=" + registered +
                '}';
    }

    @Override
    public int hashCode() {
        return (getId() == null) ? 0 : getId();
    }

}