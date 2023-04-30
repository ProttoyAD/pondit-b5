package com.pondit.model.entities;

import com.pondit.model.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@Entity
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
    @Column
    @Enumerated(EnumType.STRING)
    private UserRole role;

    public User() {}
}