package com.Spring.SpringDataRest.entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="users")


public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="first_name", nullable=false)
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    private String email;
}
