package com.springsecurity.securitydemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

//custom security configurations
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http)throws Exception{
        http.authorizeHttpRequests((requests)->requests.anyRequest().authenticated());

        // making the api stateless by remove the session
        http.sessionManagement(session->session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // form based authentication
//        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }

    // in memory Authentication
    @Bean
    public UserDetailsService userDetailsService(){

        // this gives the user details objects
        UserDetails user1 = User.withUsername("user1")
                // prefix {noop} password save as plain text not coded
                .password("{noop}pass1")
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                // use of {noop} is a bad practice but in production we use of encrypted one
                .password("{noop}admin")
                .roles("ADMIN")
                .build();


        return new InMemoryUserDetailsManager(user1,admin);
    }

}
