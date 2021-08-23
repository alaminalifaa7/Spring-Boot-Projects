package com.alif.UserLoginRegistration.registration;

import com.alif.UserLoginRegistration.appuser.AppUser;
import com.alif.UserLoginRegistration.appuser.AppUserRole;
import com.alif.UserLoginRegistration.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private final EmailValidator emailValidator;
    public String register(RegistrationRequest request) {
       boolean isValidEmail = emailValidator.test(request.getEmail());

       if(!isValidEmail){
           throw new IllegalStateException("email not valid");
       }
        return appUserService.signUp(new AppUser(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword(),
                AppUserRole.USER
        ));
    }
}
