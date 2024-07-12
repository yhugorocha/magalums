package com.hugodev.magalums.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Channel {

    @Id
    private Long id;

    private String description;

    public enum Values{

        EMAIL(1L, "email"),
        SMS(2L, "sms"),
        WHATSAPP(3L, "whatsapp"),
        PUSH(4L, "push");

        private Long id;
        private String description;

        Values(Long id, String description){
            this.id = id;
            this.description = description;
        }

        public Channel toChannel(){
            return new Channel(id, description);
        }

    }

}
