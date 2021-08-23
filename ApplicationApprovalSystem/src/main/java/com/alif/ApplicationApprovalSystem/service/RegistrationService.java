package com.alif.ApplicationApprovalSystem.service;

import com.alif.ApplicationApprovalSystem.model.Applicant;
import com.alif.ApplicationApprovalSystem.model.ApplicantRole;
import com.alif.ApplicationApprovalSystem.model.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final ApplicantService applicantService;

    public String register(RegistrationRequest registrationRequest) {
        applicantService.saveApplication(new Applicant(
                registrationRequest.getFirstName(),
                registrationRequest.getLastName(),
                registrationRequest.getEmail(),
                registrationRequest.getPassword(),
                UUID.randomUUID(),
                ApplicantRole.USER,
                false
        ));
     return "works from my  request to submit an application";
    }
}
