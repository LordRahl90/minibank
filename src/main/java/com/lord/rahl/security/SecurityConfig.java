package com.lord.rahl.security;

import com.lord.rahl.service.CurrentMerchantDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by lordrahl on 13/10/2017.
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

    @Autowired
    private CurrentMerchantDetailsService merchantDetailsService;

//    @Autowired
//    public void setMerchantDetailsService(CurrentMerchantDetailsService merchantDetailsService) {
//        this.merchantDetailsService = merchantDetailsService;
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","/admin/**").permitAll()
                .antMatchers("/merchant/**").hasAuthority("MERCHANT")
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin()
                .loginPage("/merchant/login")
                .loginProcessingUrl("/merchant/login")
                .defaultSuccessUrl("/merchant/dashboard")
                .failureUrl("/merchant/login?error")
                .usernameParameter("email")
                .permitAll()
                .and()
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll();

//        http.authorizeRequests()
//                .antMatchers("/customer/**").hasAuthority("CUSTOMER")
//                .anyRequest().fullyAuthenticated()
//                .and()
//                .formLogin()
//                .loginPage("/customer/login")
//                .defaultSuccessUrl("/customer/dashboard")
//                .failureUrl("/customer/login?error")
//                .usernameParameter("email")
//                .permitAll()
//                .and()
//            .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/")
//                .permitAll();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(merchantDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }
}
