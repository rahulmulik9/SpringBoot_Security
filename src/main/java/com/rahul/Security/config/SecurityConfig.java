package com.rahul.Security.config;

import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        /*
         *  Below is the custom security configurations
         * In below pages if you have password and username then you are able to access that information
         *
         */

        http.csrf((csrf)->csrf.disable()).authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()  //for password and username
                        .requestMatchers("/notices", "/contact", "/register").permitAll())                                //for all
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();

        // Configuration to deny all the requests

        /*http.authorizeHttpRequests(requests -> requests.anyRequest().denyAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();*/


        // Configuration to permit all the requests
        /*http.authorizeHttpRequests(requests -> requests.anyRequest().permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();*/

    }


    //if you are using JDBC user management then comment this method
    //inMemory user management
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        //*Approach 1 where we use NoOpPasswordEncoder Bean
//        //while creating the user details*//*
//        //By default this method will encode the password
//        //if you don't want then use {noop} e.g password("{noop}1234")
//        //InMemoryUserDetailsManager can take as many arguments
//
//        UserDetails admin = User.withUsername("admin")
//                .password("12345")
//                .authorities("admin")
//                .build();
//        UserDetails user = User.withUsername("user")
//                .password("12345")
//                .authorities("read")
//                .build();
//        return new InMemoryUserDetailsManager(admin, user);
//    }

    //this is used to get plain text password


    //for JDBC user manager
    //for this database is active and has user table
    //create table User and files as we do in InMemoryuser manager
//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//
    @Bean public PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
   }


}



