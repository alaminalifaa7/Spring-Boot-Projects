package com.alif.UserLoginRegistration.appuser;

import com.alif.UserLoginRegistration.registration.token.ConfirmationToken;
import com.alif.UserLoginRegistration.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG="user with email %s not found";
    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email).orElseThrow(()->
                new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG,email)));
    }

    public String signUp(AppUser appUser){
       boolean userExists = appUserRepository.findByEmail(appUser.getEmail())
                .isPresent();
       if(userExists){
           throw new IllegalStateException("email already taken");
       }
       String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
       appUser.setPassword(encodedPassword);
       appUserRepository.save(appUser);
       //todo send confirmation token
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken =
                new ConfirmationToken(
                        token,
                        LocalDateTime.now(),
                        LocalDateTime.now().plusMinutes(15),
                        appUser
                        );
        confirmationTokenService.saveConfirmationToken(confirmationToken);
       return token;
    }
}
