package LentoPharmacy.co.za.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by aubrey on 09/10/2017.
 */
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(AuthenticationManagerBuilder amb) throws Exception{
        amb.inMemoryAuthentication().withUser("user").password("password")
        .roles("USER").and().withUser("help").password("please").roles("ADMIN");

    }

    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.httpBasic().and().authorizeRequests().antMatchers("/pharmacy/**")
        .hasRole("USER").and().csrf().disable().headers().frameOptions() .disable();
    }
}
