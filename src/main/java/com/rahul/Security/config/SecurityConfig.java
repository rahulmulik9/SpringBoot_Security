package com.rahul.Security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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


        http.authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/myAccount","/myBalance","/myLoans","/myCards").authenticated()  //for password and username
                        .requestMatchers("/notices","/contact").permitAll())                                //for all
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

}

