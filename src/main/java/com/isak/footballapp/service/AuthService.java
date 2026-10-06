package com.isak.footballapp.service;
import com.isak.footballapp.dto.RegisterRequest;
import com.isak.footballapp.entity.User;
import com.isak.footballapp.enums.Role;
import com.isak.footballapp.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.isak.footballapp.dto.LoginRequest;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(RegisterRequest request) {

        // Sjekker om e-post allerede finnes
        if (userRepository.findUserByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email er allerede registrert");
        }

        // Lager et nytt User-objekt
        User user = new User();

        // Flytter data fra DTO -> User
        user.setUserName(request.getUserName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setMobileNr(request.getMobileNr());

        // Klienten får ikke bestemme rollen selv
        user.setRole(Role.USER);

        // Lagrer brukeren i PostgreSQL
        return userRepository.save(user);
    }

    public String login(LoginRequest request) {
        User user = userRepository.findUserByEmail(request.getEmail())
            .orElseThrow(() -> new RuntimeException("Bruker finnes ikke"));
        boolean passwordMatches = passwordEncoder.matches(
            request.getPassword(),
            user.getPassword()
        );

        if(!passwordMatches) {
            throw new RuntimeException("Feil passord");
        }
        return "Innlogging vellykket";
    }

}