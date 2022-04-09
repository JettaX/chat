package entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.*;

@Entity
@Table(name = "users")
@JsonPropertyOrder({"userLogin", "id", "name", "surname"})
@JsonIgnoreProperties({ "image" })
@AllArgsConstructor
public class User {
    @Getter @Id
    private String userLogin;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String surname;
    @Getter @Setter
    private ImageIcon image;

    public User(String userLogin, String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.userLogin = userLogin;
        image = new ImageIcon("src/main/resources/Images/default_icon.png");
    }
}
