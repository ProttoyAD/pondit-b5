package com.pondit.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity(name = "USER")
@Table(name = "TBL_USER")
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String password;

    public User() {}
}