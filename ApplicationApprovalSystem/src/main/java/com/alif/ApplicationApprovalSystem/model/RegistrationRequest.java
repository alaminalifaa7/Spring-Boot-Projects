package com.alif.ApplicationApprovalSystem.model;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class RegistrationRequest {
    private String firstName;
    private  String lastName;
    private  String email;
    private  String password;


}
