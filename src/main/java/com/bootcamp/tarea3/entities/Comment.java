package com.bootcamp.tarea3.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private String id;
    private Date date;
    private String name;
    private String status;
    private String comment;
    private int userId;
}
