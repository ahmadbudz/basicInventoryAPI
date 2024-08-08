package inventory.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	/*
	 * in memory users
	 * hamed is an EMPLOYEE can only use the http method get
	 * yousef is an MANAGER can use http method get , post and put
	 * omar is an ADMIN can use all the http methods which are get, post, put and delete
	 */
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		UserDetails hamed = User.builder()
								.username("hamed")
								.password("{noop}123123")
								.roles("EMPLOYEE")
								.build();
		
		UserDetails yousef = User.builder()
				.username("yousef")
				.password("{noop}123123")
				.roles("MANAGER", "EMPLOYEE")
				.build();
		
		UserDetails omar = User.builder()
				.username("omar")
				.password("{noop}123123")
				.roles("EMPLOYEE", "MANAGER", "ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(hamed,yousef,omar);
	}
	
	/*
	 * limits the accessibility of the api based on roles
	 * EMPLOYEE can only use http method get
	 * MANAGER can use http methods of get, post and put
	 * ADMIN can use all the http methods which are get, post, put and delete 
	 */
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http
	    	.csrf(csrf -> csrf.disable())
	    	.authorizeHttpRequests(authorizeRequests ->
	            authorizeRequests
	                .requestMatchers(HttpMethod.GET, "/api/**").hasRole("EMPLOYEE")
	                .requestMatchers(HttpMethod.POST, "/api/**").hasRole("MANAGER")
	                .requestMatchers(HttpMethod.PUT, "/api/**").hasRole("MANAGER")
	                .requestMatchers(HttpMethod.DELETE, "/api/**").hasRole("ADMIN")
	        )
	        .httpBasic(Customizer.withDefaults());
	    return http.build();
	}

	
}
