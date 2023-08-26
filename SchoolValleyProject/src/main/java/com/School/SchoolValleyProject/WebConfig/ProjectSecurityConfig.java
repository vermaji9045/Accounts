package com.School.SchoolValleyProject.WebConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
    public class ProjectSecurityConfig  {

        @Bean
        SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

            http.csrf().ignoringRequestMatchers("/saveMsg").ignoringRequestMatchers("/public/**")
                    .ignoringRequestMatchers("/api/**").and()
                    .authorizeHttpRequests()
                .requestMatchers("/home").permitAll()
                .requestMatchers("/displayProfile").authenticated()
                .requestMatchers("/api/**").authenticated()
                .requestMatchers("/updateProfile").authenticated()
                .requestMatchers("/course").permitAll()
                .requestMatchers("/about").permitAll()
                .requestMatchers("/contact").permitAll()
                .requestMatchers("/holidays/**").permitAll()
                .requestMatchers("/saveMsg").permitAll()
                .requestMatchers("/courses").permitAll()
                .requestMatchers("/dashboard").authenticated()
                .requestMatchers("/displayMessages/**").hasRole("ADMIN")
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/student/**").hasRole("STUDENT")
                    .requestMatchers("/assets/**").permitAll()
                //.mvcMatchers("/subscribe/").permitAll()
                .requestMatchers("/login").permitAll()
                .requestMatchers("/public/**").permitAll()
                .and().formLogin().loginPage("/login")
                .defaultSuccessUrl("/dashboard")
                .failureUrl("/login?error=true").permitAll()
                .and().logout().logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll()
              //.and().authorizeRequests().antMatchers("/h2-console/**").permitAll()
                .and().httpBasic();


            return http.build();
        }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

}
