package com.practice.requestresponsedblogging.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Students {

    @Id
    private Integer studentId;
    private String studentName;
    private String email;
    private String description;

}
