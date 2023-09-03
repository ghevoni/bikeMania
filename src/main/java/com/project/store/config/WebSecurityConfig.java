package com.project.store.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import javax.sql.DataSource;

import static org.hibernate.criterion.Restrictions.and;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/frontpage", "/login", "/imagines/**",
                "/bike/view/*", "/bike/edit/*", "/register", "/aboutUs", "/service",
                "/contact", "/termsConditions", "/return", "/privacy", "/cookie",
        "/freeRevisions", "/men", "/ladies", "/children", "/electric", "/sport").permitAll();

        http.authorizeRequests().anyRequest().authenticated();
        http.formLogin()
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/frontpage")
                        .failureUrl("/login");
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/frontpage").deleteCookies("JSESSIONID").clearAuthentication(true).invalidateHttpSession(true);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth, DataSource dataSource, PasswordEncoder passwordEncoder) throws Exception {

        auth.jdbcAuthentication().passwordEncoder(passwordEncoder).dataSource(dataSource);
        System.out.println(passwordEncoder.encode("user"));

    }
}
