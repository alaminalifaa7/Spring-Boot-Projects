package com.alif.ApplicationApprovalSystem.controller;

import com.alif.ApplicationApprovalSystem.model.RegistrationRequest;
import com.alif.ApplicationApprovalSystem.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/registration")
@AllArgsConstructor
public class ApplicationController {

    private final RegistrationService registrationService;

    @ModelAttribute("registration")
    public RegistrationRequest registrationRequest() {
        return new RegistrationRequest();
    }

    //GET - registration form to send the model
    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String register(@ModelAttribute("registration") RegistrationRequest registrationRequest){
        registrationService.register(registrationRequest);
        return "redirect:/registration?success";
    }
}
