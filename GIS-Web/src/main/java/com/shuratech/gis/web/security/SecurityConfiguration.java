package com.shuratech.gis.web.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.
                inMemoryAuthentication().withUser("default").password("password").roles("USER");
    }
    
     @Override
    public void configure(WebSecurity web) throws Exception
    {
        web.ignoring().antMatchers("/css/**", "/fonts/**", "/bower_components/**", "/js/**", "/sounds/**",
                        "/img/**", "/partials/**    ", "favicon.ico");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        
        http.csrf().disable();
        
       
        http.authorizeRequests().anyRequest().permitAll();

        http
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated();

        http.
                formLogin().loginPage("/login").permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutUrl("/logout")
                .permitAll();

    }
}
