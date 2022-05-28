package com.suyash.deubank.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Entity
@Data
@NoArgsConstructor
public class Blog {

    @Id
    private String title;
    private String description;
    private LocalDateTime dateTime;
    private String createdBy;
    private String status;

    public Blog( String title, String description, LocalDateTime dateTime, String createdBy, String status) {

        this.title = title;
        this.description = description;
        this.dateTime = dateTime;
        this.createdBy = createdBy;
        this.status = status;
    }
}