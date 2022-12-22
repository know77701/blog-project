package com.cos.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.cos.blog.config.auth.PrincipalDetailService;

@Configuration
public class SecurityConfig  {

	@Autowired
	private PrincipalDetailService principalDetailService;
	
	@Bean
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        	.csrf().disable() // csrf 토큰 비활성화(테스트 시 걸어두기)
    		.authorizeRequests()
        		.antMatchers("/","/auth/**", "/js/**","/css/**","/image/**")
        		.permitAll()
        		.anyRequest()
        		.authenticated()
        	.and()
        		.formLogin()
        		.loginPage("/auth/loginForm")
        		.loginProcessingUrl("/auth/login") //  시큐리티가 해당 주소로 요청오는 로그인을 가로채서 로그인해줌
        		.defaultSuccessUrl("/")
        		.failureUrl("/auth/loginForm");

        return http.build();
	
	}
}