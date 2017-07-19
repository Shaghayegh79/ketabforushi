package com.example;
import com.example.security.AccountAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity

public class SecurityConfiguration {

    @Autowired
    private AccountAuthenticationProvider accountAuthenticationProvider;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(accountAuthenticationProvider);
    }
    @Configuration
   // @Order(1)
    public static class ApiWebSecurityConfigurerAdapter
            extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            // @formatter:off
            http.csrf().disable();
        	http.cors().and()
        	.httpBasic()
        	.and()
        	.authorizeRequests()
             	.antMatchers("/libreria").permitAll()
             	.anyRequest().hasAuthority("USER");
        }

    }

}
