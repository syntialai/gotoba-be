package com.example.goToba.config;


import com.example.goToba.security.AuthenticationManager;
import com.example.goToba.security.SecurityContextRepository;
import io.netty.handler.codec.http.HttpMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * Created by Sogumontar Hendra Simangunsong on 27/03/2020.
 */
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfig {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SecurityContextRepository securityContextRepository;

    @Bean
    public SecurityWebFilterChain securitygWebFilterChain(ServerHttpSecurity http) {
        return http
                .exceptionHandling().and().csrf().disable()
//				.authenticationEntryPoint((swe, e) -> {
//					return Mono.fromRunnable(() -> {
//						swe.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//					});
//				}).accessDeniedHandler((swe, e) -> {
//					return Mono.fromRunnable(() -> {
//						swe.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
//					});
//				}).and()
				.csrf().disable()
				.formLogin().disable()
				.httpBasic().disable()
				.authenticationManager(authenticationManager)
				.securityContextRepository(securityContextRepository)
				.authorizeExchange()
//				.pathMatchers(HttpMethod.OPTIONS).permitAll()
				.pathMatchers("/auth/login").permitAll()
				.pathMatchers("/auth/signup").permitAll()
				.pathMatchers("/wisata/**").permitAll()
				.pathMatchers("/gallery/**").permitAll()
				.pathMatchers("/restaurant/**").permitAll()
				.anyExchange().authenticated()
				.and().build();
    }
}
