package net.weg.wegproject.security;

import com.auth0.jwt.exceptions.JWTDecodeException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.weg.wegproject.ConcreteClasses.user.model.entity.User;
import net.weg.wegproject.security.util.CookieUtil;
import net.weg.wegproject.security.util.JWTUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class Filter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)

            throws ServletException, IOException {
        if(!rotaPublicas(request.getRequestURI())) {
            try{
                String token = CookieUtil.getCookie(request);
                User user = JWTUtil.getUsuario(token);
                response.addCookie(CookieUtil.generateCookie(user));
                Authentication authentication = new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        null,
                        user.getAuthorities()
                );
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (JWTDecodeException e){
                System.out.println("Token inválido!!");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
//            catch (CookieNaoEncontrado e){
//                System.out.println(e.getMessage());
//                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            }
        }
        filterChain.doFilter(request, response);
    }

    private boolean rotaPublicas(String url) {
        return url.equals("/login") || url.equals("/user") || url.equals("/company");
    }
}
