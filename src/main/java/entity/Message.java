package entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message {
    @Id @GeneratedValue @Getter
    private String id;
    @Getter
    private String userNameFrom;
    @Getter
    private String userNameTo;
    @Getter
    @Setter
    private String text;
    @Getter
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private final LocalDateTime time;

    public Message(String userNameFrom, String userNameTo, String text) {
        this.userNameFrom = userNameFrom;
        this.userNameTo = userNameTo;
        this.text = text;
        this.time = LocalDateTime.now();
    }

    @JsonCreator
    public Message(
            @JsonProperty("userNameFrom")
                    String userNameFrom,
            @JsonProperty("userNameTo")
                    String userNameTo,
            @JsonProperty("text")
                    String text,
            @JsonProperty("time")
                    LocalDateTime time) {
        this.userNameFrom = userNameFrom;
        this.userNameTo = userNameTo;
        this.text = text;
        this.time = time;
    }
}
