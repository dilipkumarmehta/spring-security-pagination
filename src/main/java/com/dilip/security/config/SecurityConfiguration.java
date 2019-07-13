package com.dilip.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests()
		 .anyRequest()
		 .fullyAuthenticated()
		 //.permitAll()
		.and().addFilterBefore(customeFilter(),BasicAuthenticationFilter.class)
		.httpBasic();
		//.and.httpBasic();
		httpSecurity.csrf().disable();

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("user")
		.password("{noop}password")
		.roles("USER")
		.and().withUser("admin")
		.password("{noop}password").roles("ADMIN");

	}
	@Bean
	public CustomeFilter customeFilter() {
		return new CustomeFilter();
	}

}
