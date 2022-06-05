package idv.ren.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
public class SecurityConfig implements WebMvcConfigurer{
	
	@Bean
	SecurityFilterChain fileChain(HttpSecurity http) throws Exception{
//		return http.antMatcher("/**")
//				.authorizeRequests(authorize -> authorize.anyRequest().authenticated()
//						)
//				.build();
		
//		return http.anonymous().and().build();
		
		
		http.anonymous();
		return http.build();
	}
	
}
