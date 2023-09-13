package org.example.sunlab.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig{

    //    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/css/**", "/images/**", "/error");
//    }
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().requestMatchers("/css/**");
//    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/", "/contact-us", "/search")
//                .permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .usernameParameter("username")
//                .passwordParameter("userpass")
//                .permitAll()
//                .and()
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
////                .logoutSuccessUrl("/logout-success")
//                .permitAll();
//
//        http.headers().frameOptions().disable();
//        http.csrf().disable();
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
//                .authorizeRequests(
//                        requests -> requests
//                                .requestMatchers("/").permitAll()
//                                .anyRequest().authenticated()
//                )
                .formLogin(form -> form
//                        .loginPage("/login")
//                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/admin",true)
//                        .failureUrl("/login.html?error=true")
//                        .usernameParameter("username")
//                        .passwordParameter("userpass")
//                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/")
//                        .permitAll()
                );
//        http.formLogin(Customizer.withDefaults());
        return http.build();
    }

    //    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password("{noop}123456")
//                .roles("USER");
//    }
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("passw0rd")//lol
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

}
