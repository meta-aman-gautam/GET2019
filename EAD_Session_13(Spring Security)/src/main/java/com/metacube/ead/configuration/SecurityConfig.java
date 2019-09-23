package com.example.demo.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * The Class SecurityConfig is spring security manual configuration file 
 * 
 * @author Aman Gautam
 * 
 * Dated :23/9/19
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Configure global authentication for the spring security .
     *
     * @param auth the auth
     * @throws Exception
     */
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.inMemoryAuthentication()
        .withUser("user").password(passwordEncoder().encode("1234")).roles("USER")
        .and()
        .withUser("admin").password(passwordEncoder().encode("123")).roles("ADMIN");
    }
	
	/**
	 * Password encoder is needed to encode password .
	 *
	 * @return the password encoder
	 */
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
    /** Secure the end points with HTTP Basic authentication
     * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests()
        .antMatchers("/welcome").permitAll()
        .antMatchers("/index").authenticated()
		.antMatchers("/addStudent").access("hasRole('ADMIN')")
		.antMatchers("/showStudent").access("hasRole('USER')")
		.antMatchers("/emailSearch").access("hasRole('ADMIN')or hasRole('USER')")
		.antMatchers("/showemail").access("hasRole('ADMIN')or hasRole('USER')")
		.and()
		.formLogin().loginPage("/index")
		.defaultSuccessUrl("/index")
		.failureUrl("/login?error=true")
		.usernameParameter("username").passwordParameter("password")				
		.and()
        .csrf()
        .disable();
    }
}