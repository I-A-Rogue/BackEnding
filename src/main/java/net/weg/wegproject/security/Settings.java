package net.weg.wegproject.security;

import lombok.AllArgsConstructor;
import net.weg.wegproject.security.service.JpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

import static net.weg.wegproject.security.model.Profile.ADMIN;
import static net.weg.wegproject.security.model.Profile.CLIENT;

@AllArgsConstructor
@EnableWebSecurity
@Configuration
@EnableMethodSecurity
public class Settings {

    private JpaService jpaService;

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jpaService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOrigins(List.of("http://localhost:3000/"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorization) ->
                authorization
                        .requestMatchers(HttpMethod.POST, "/user").permitAll()
                        .requestMatchers(HttpMethod.GET, "/user/**").hasAnyAuthority("ADMIN", "CLIENT")
                        .requestMatchers(HttpMethod.GET, "/user").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/user/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/user/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/saves/**").hasAnyAuthority("ADMIN", "CLIENT")
                        .requestMatchers(HttpMethod.GET, "/saves/**").hasAnyAuthority("ADMIN", "CLIENT")
                        .requestMatchers(HttpMethod.DELETE, "/saves/**").hasAnyAuthority("ADMIN", "CLIENT")
                        .requestMatchers(HttpMethod.GET, "/saves").hasAnyAuthority("ADMIN", "CLIENT")
                        .requestMatchers(HttpMethod.POST, "/product").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/product/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/product").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/product/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.PATCH, "/product/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/order/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/order/**").hasAnyAuthority("ADMIN", "CLIENT")
                        .requestMatchers(HttpMethod.DELETE, "/order/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/order").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/creditCard").hasAnyAuthority("ADMIN", "CLIENT")
                        .requestMatchers(HttpMethod.GET, "/creditCard").hasAnyAuthority("ADMIN", "CLIENT")
                        .requestMatchers(HttpMethod.GET, "/creditCard/**").hasAnyAuthority("ADMIN", "CLIENT")
                        .requestMatchers(HttpMethod.DELETE, "/creditCard/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/company").permitAll()
                        .requestMatchers(HttpMethod.GET, "/company/**").hasAnyAuthority("ADMIN", "CLIENT")
                        .requestMatchers(HttpMethod.GET, "/company").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/company/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/company/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/cart/** - PUT").hasAnyAuthority("ADMIN", "CLIENT")
                        .requestMatchers(HttpMethod.GET, "/cart/**").hasAnyAuthority("ADMIN", "CLIENT")
                        .requestMatchers(HttpMethod.GET, "/cart").hasAnyAuthority("ADMIN", "CLIENT")
                        .requestMatchers(HttpMethod.DELETE, "/cart/**").hasAnyAuthority("ADMIN", "CLIENT")
                        .requestMatchers(HttpMethod.PUT, "/assessment/**").hasAnyAuthority("ADMIN", "CLIENT")
                        .requestMatchers(HttpMethod.PATCH, "/assessment/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/assessment/**").hasAnyAuthority("ADMIN", "CLIENT")
                        .requestMatchers(HttpMethod.GET, "/assessment").hasAnyAuthority("ADMIN", "CLIENT")
                        .requestMatchers(HttpMethod.DELETE, "/assessment/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/address").hasAnyAuthority("ADMIN", "CLIENT")
                        .requestMatchers(HttpMethod.GET, "/address").hasAnyAuthority("ADMIN", "CLIENT")
                        .requestMatchers(HttpMethod.GET, "/address/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/address/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/address/**").hasAnyAuthority("ADMIN", "CLIENT")
                        .requestMatchers(HttpMethod.POST, "/login").permitAll()
                        .anyRequest().authenticated()
        );
        http.csrf(AbstractHttpConfigurer::disable);
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.cors();
        http.addFilterBefore(
                new Filter(),
                UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
