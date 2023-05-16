package com.example.springsecuritybasic.configuration;

import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    // set up user credential

    // in memory is mainly for testing
    // H2 -> in memory
//    @Bean
//    public InMemoryUserDetailsManager userDetailService(){
//        UserDetails user1 = User.withUsername("jessica").password("4321").roles("USER").build();
//        UserDetails user2 = User.withUsername("James").password("1234").roles("ADMIN").build();
//        return new InMemoryUserDetailsManager(user1, user2);
//    }


    // config the security
    @Bean
    public SecurityFilterChain filterChain (HttpSecurity httpSecurity) throws Exception{
//        httpSecurity.csrf().disable()
//                .authorizeHttpRequests()
//                .requestMatchers("/admin/**")
//                .hasRole("ADMIN")
//                .requestMatchers("/user/**")
//                .hasRole("USER")
//                .requestMatchers("/home/**")
//                .anonymous()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin();
        httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/home/homepage", "/home/feed", "/email/**")
                .permitAll()
                .requestMatchers("/user/**")
                .hasRole("USER")
                .requestMatchers("/admin/**")
                .hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin();
        return httpSecurity.build();
    }
    // password encoder
//    @Bean
//    public PasswordEncoder passwordEncoder1(){
//        return new BCryptPasswordEncoder();
//    }

    @Bean
    @SuppressWarnings("deprecation")
    public NoOpPasswordEncoder passwordEncoder(){
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}
