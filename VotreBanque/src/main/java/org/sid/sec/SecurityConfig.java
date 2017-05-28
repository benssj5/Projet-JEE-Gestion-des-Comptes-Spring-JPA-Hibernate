package org.sid.sec;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//pour definir la maniere dont on va chercher les utilisateurs
/*		auth.inMemoryAuthentication()
			.withUser("admin").password("1234").roles("ADMIN","USER");
		auth.inMemoryAuthentication()
			.withUser("user").password("1234").roles("USER"); */
		
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("Select username as principal, password as credentials, active from Users where username=? ")
			.authoritiesByUsernameQuery("Select username as principal, roles as role from users_roles where username=? ")
			.rolePrefix("ROLE_")
			.passwordEncoder(new Md5PasswordEncoder());
		
		
		
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// pour definir les strategies de securités,, les regles
		//on demande a Spring qu'on a besoin de passer par une authentification basée par un formulaire
		http.formLogin().loginPage("/login");
		//securiser les ressources de l'appli
		http.authorizeRequests().antMatchers("/operations","/consulterCompte").hasRole("USER");  
		http.authorizeRequests().antMatchers("/saveOperation").hasRole("ADMIN");
		
		http.exceptionHandling().accessDeniedPage("/403");
	}
	
}
