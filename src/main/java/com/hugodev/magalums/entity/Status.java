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
public class Status {

    @Id
    private Long id;

    private String description;

    public enum Values{

        PENDING(1L, "pending"),
        SUCESS(2L, "sucess"),
        ERROR(3L, "error"),
        CANCELED(4L, "canceled");

        private Long id;
        private String description;

        Values(Long id, String description){
            this.id = id;
            this.description = description;
        }

        public Status toStatus(){
            return new Status(id, description);
        }
    }
}
