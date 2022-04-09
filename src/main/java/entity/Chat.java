package entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "chats")
@JsonPropertyOrder({"ownerUser", "friendUser", "messages"})
@AllArgsConstructor
public class Chat {
    @Id @GeneratedValue @Getter
    private String id;
    @Getter
    private User ownerUser;
    @Getter
    private User friendUser;
    @Getter
    private List<Message> messages = new ArrayList<>();

    public Chat(User ownerUser, User friendUser) {
        this.ownerUser = ownerUser;
        this.friendUser = friendUser;
    }

    public void addMessage(Message message) {
        messages.add(message);
    }
}
