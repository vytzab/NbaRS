package lt.viko.eif.vytzab.restws.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Vytautas
 *
 *         Class for the web security configuration
 */
@SuppressWarnings("deprecation")
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * Allows HTTP requests to the h2-console endpoint.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().cors().disable().authorizeRequests().antMatchers("/h2-console/**").permitAll()
				.anyRequest().authenticated();
		http.headers().frameOptions().sameOrigin();
	}

	/**
	 * General HTPP requests security configuration.
	 */
	@Override
	public void configure(WebSecurity webSecurity) throws Exception {
		webSecurity.ignoring().antMatchers(HttpMethod.POST, "/**").antMatchers(HttpMethod.OPTIONS, "/**").and()

				.ignoring().antMatchers(HttpMethod.GET, "/**").and().ignoring().antMatchers(HttpMethod.DELETE, "/**")
				.and().ignoring().antMatchers(HttpMethod.PUT, "/**");
	}
}