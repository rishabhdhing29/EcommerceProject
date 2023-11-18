package com.hexaware.ecommerce.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.hexaware.ecommerce.filter.JwtAuthFilter;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	@Autowired
	JwtAuthFilter authFilter;

	@Bean
    //authentication
    public UserDetailsService userDetailsService() {
//        UserDetails admin = User.withUsername("Basant")
//                .password(encoder.encode("Pwd1"))
//                .roles("ADMIN")
//                .build();
//        UserDetails user = User.withUsername("John")
//                .password(encoder.encode("Pwd2"))
//                .roles("USER","ADMIN","HR")
//                .build();
//        return new InMemoryUserDetailsManager(admin, user);
        return new AdminInfoAdminDetailsService();
    }

	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        return http.csrf().disable()
	                .authorizeHttpRequests()
	                .requestMatchers("/api/admin/add","/api/admin/authenticate","/api/customer/add","/api/customer/authenticate","/api/seller/add","/api/seller/authenticate","/api/cart","/api/cart/authenticate","/api/order","/api/order/authenticate","/api/paymentinfo","/api/paymentinfo/authenticate","/api/product","/api/product/authenticate","/api/shipping","/api/shipping/authenticate","/v3/api-docs/**","/api/seller/add","/api/seller/authenticate", "/swagger-ui/**","/swagger-resources/**").permitAll()
	                .and()
	                .authorizeHttpRequests().requestMatchers("/api/admin/**","/api/customer/**","/api/seller/**","/api/cart/**","/api/order/**","/api/product/**","/api/shipping/**","/api/paymentinfo/**")
	                .authenticated().and() //.formLogin().and().build();
	                .sessionManagement()
	                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	                .and()
	                .authenticationProvider(authenticationProvider())
	                .addFilterBefore(authFilter,UsernamePasswordAuthenticationFilter.class)
	                .build();
	    }

	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    public AuthenticationProvider authenticationProvider(){
	        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
	        authenticationProvider.setUserDetailsService(userDetailsService());
	        authenticationProvider.setPasswordEncoder(passwordEncoder());
	        return authenticationProvider;
	    }




	    @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {

	    	return config.getAuthenticationManager();

	    }




}
