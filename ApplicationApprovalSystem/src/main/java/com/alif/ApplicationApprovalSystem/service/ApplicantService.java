package com.alif.ApplicationApprovalSystem.service;
import com.alif.ApplicationApprovalSystem.model.Applicant;
import com.alif.ApplicationApprovalSystem.repository.ApplicantRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ApplicantService implements UserDetailsService {

    private final ApplicantRepository applicantRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return applicantRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("User Not Found FROM applicant SERVICE"));
    }

    public Applicant retrieveApplicant(String email){
       return  applicantRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("User Not Found FROM applicant SERVICE"));
    }
    public String saveApplication(Applicant applicant){
        boolean applicantExists = applicantRepository.findByEmail(applicant.getEmail()).isPresent();

        if(applicantExists){
            throw new IllegalStateException("EMAIL ALREADY TAKEN");
        }
        applicantRepository.save(applicant);
        return "works";
    }


}
