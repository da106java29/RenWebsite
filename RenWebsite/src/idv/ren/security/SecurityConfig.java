package idv.ren.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 暫停使用sitemesh3
 * @author Ren
 *
 */
@EnableWebSecurity
public class SecurityConfig{
	
	@Bean
	SecurityFilterChain fileChain(HttpSecurity http) throws Exception{
//		return http.antMatcher("/**")
//				.authorizeRequests(authorize -> authorize.anyRequest().authenticated()
//						)
//				.build();
//		
//		return http.anonymous().and().build();
		
//		http.httpBasic();
//		http.anonymous();
		
		http.
			authorizeHttpRequests()
			.antMatchers("/**")
			.hasRole("ROLE_USER")
			.and()
			.logout().logoutUrl("/index").logoutSuccessUrl("/index").deleteCookies("JSESSIONID").invalidateHttpSession(true)
			.and()
			.httpBasic();
		
		System.out.println("ASDADASDASD");
		return http.build();
	}
	
	
	
}
