package com.redcompany.app.security;

import com.redcompany.app.auth.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.redcompany.app.security.ApplicationUserRole.*;
import static com.redcompany.app.security.ApplicationUserPermission.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    private final ApplicationUserService applicationUserService;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder,ApplicationUserService applicationUserService) {
        this.passwordEncoder = passwordEncoder;
        this.applicationUserService = applicationUserService;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","index","/css/*","/js/*").permitAll()
                .antMatchers("/api/**").hasRole(STUDENT.name())
                /*.antMatchers(HttpMethod.POST, "/management/api/**" ).hasAuthority(COURSE_WRITE.getPermission())
                .antMatchers(HttpMethod.PUT, "/management/api/**" ).hasAuthority(COURSE_WRITE.getPermission())
                .antMatchers(HttpMethod.DELETE, "/management/api/**" ).hasAuthority(COURSE_WRITE.getPermission())
                .antMatchers(HttpMethod.GET, "/management/api/**" ).hasAnyRole(ADMIN.name(), ADMIN_TRAINEE.name())*/
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider( daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider  provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(applicationUserService);

        return provider;
    }

















    /*@Bean
    @Override
    protected UserDetailsService userDetailsService() {
        UserDetails reds = User.builder()
                .username("reds")
                .password(passwordEncoder.encode("password"))
               // .roles(STUDENT.name())//ROLE_STUDENT
                .authorities(STUDENT.getGrantedAuthorities())
                .build();


        UserDetails kars = User.builder()
                .username("kars")
                .password(passwordEncoder.encode("password"))
                //.roles(ADMIN.name())//ROLE_ADMIN
                .authorities(ADMIN.getGrantedAuthorities())
                .build();


        UserDetails tom = User.builder()
                .username("tom")
                .password(passwordEncoder.encode("password"))
                //.roles(ADMIN_TRAINEE.name())//ROLE_ADMINTRAINEE
                .authorities(ADMIN_TRAINEE.getGrantedAuthorities())
                .build();
        return new InMemoryUserDetailsManager(
                reds,
                kars,
                tom
        );

    }*/

    @Configuration
    public static class PasswordConfig {
        @Bean
        public PasswordEncoder passwordEncoder(){
            return  new BCryptPasswordEncoder();

        }
    }
}
