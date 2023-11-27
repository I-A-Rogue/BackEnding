package net.weg.wegproject.security.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.AllArgsConstructor;
import net.weg.wegproject.ConcreteClasses.user.model.entity.User;
import net.weg.wegproject.ConcreteClasses.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@AllArgsConstructor
public class JWTUtil {

    @Autowired
    JWTUtil(UserRepository userRepository){
        JWTUtil.userRepository = userRepository;
    }

    static UserRepository userRepository;

    private static final String SenhaForte = "c127a7b6adb013a5ff879ae71afa62afa4b4ceb72afaa54711dbcde67b6dc325";

    public static String generateToken(User user) {
        Algorithm algorithm = Algorithm.HMAC256(SenhaForte);
        return JWT.create().withIssuer("WEG")
                .withSubject(user.getUsername())
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(new Date().getTime() + 1000 * 60 * 30))
                .sign(algorithm);
    }


    public static User getUsuario(String token) {
        String username = JWT.decode(token).getSubject();
        return userRepository.findByEmail(username);
    }

}
