package com.alif.ApplicationApprovalSystem.controller;

import com.alif.ApplicationApprovalSystem.model.Applicant;
import com.alif.ApplicationApprovalSystem.service.ApplicantService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class MainController {

    private final ApplicantService applicantService;
    @GetMapping("/login")
    public String home() {
        return "login";
    }
    @GetMapping("/")
    public String nid(Model model) {
        UserDetails userDetails =
                (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      Applicant applicant = applicantService.retrieveApplicant(userDetails.getUsername());

      model.addAttribute("applicant",applicant);
        return "nid";
    }
    @GetMapping("/admin")
    public String admin(Model model) {
        List<Applicant> applicants = applicantService.getAllApplicant();
        model.addAttribute("applicants",applicants);
        return "adminApproval";
    }
}
