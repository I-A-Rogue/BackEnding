package net.weg.wegproject.security.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import net.weg.wegproject.ConcreteClasses.user.model.entity.User;
import org.springframework.web.util.WebUtils;

public class CookieUtil {

    public static Cookie generateCookie(User user) {
        String token = JWTUtil.generateToken(user);
        Cookie cookie = new Cookie("Cookie", token);
        cookie.setPath("/");
        cookie.setMaxAge(1800);
        return cookie;
    }

    public static String getCookie(HttpServletRequest request) {
        Cookie cookie = WebUtils.getCookie(request, "Cookie");
        if(cookie != null){
            return cookie.getValue();
        }
        throw new RuntimeException();
    }

}
