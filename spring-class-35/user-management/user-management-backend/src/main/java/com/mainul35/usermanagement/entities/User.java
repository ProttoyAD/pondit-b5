package com.mainul35.usermanagement.entities;

import jakarta.persistence.*;
import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="user-table")                        //"user" is a built in syntax in postgresql, so we need to change name
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private int id;
    private String name;
    private String email;
    private String jobTitle;
    private String phone;

}