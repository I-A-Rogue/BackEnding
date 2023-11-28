package net.weg.wegproject.security.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.user.model.entity.User;
import net.weg.wegproject.security.model.Login;
import net.weg.wegproject.security.util.CookieUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@CrossOrigin
@AllArgsConstructor
public class AutenticationController {

    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login login,
                                   HttpServletResponse response) {;
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(
                        login.getUsername(),
                        login.getPassword());
        Authentication authentication = authenticationManager.authenticate(token);
        if (authentication.isAuthenticated()) {
            User user = (User) authentication.getPrincipal();
            Cookie cookie = CookieUtil.generateCookie(user);
            response.addCookie(cookie);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(401).build();
    }

}
