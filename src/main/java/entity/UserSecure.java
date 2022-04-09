package entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users_secure")
@JsonPropertyOrder({"userLogin", "userPassword"})
public class UserSecure {
    @Getter @Id
    private String userLogin;
    @Getter
    String userPassword;

    public UserSecure(String userLogin, String userPassword) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;
    }
}
