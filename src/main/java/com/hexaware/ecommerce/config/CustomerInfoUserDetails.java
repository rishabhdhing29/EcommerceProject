package com.hexaware.ecommerce.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hexaware.ecommerce.entities.Customer;


public class CustomerInfoUserDetails implements UserDetails {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String password;
	private List<GrantedAuthority>authorities;
	public CustomerInfoUserDetails(Customer customerInfo) {
        name=customerInfo.getCustomerFirstName();
        password=customerInfo.getCustomerLastName();
        authorities= Arrays.stream(customerInfo.getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities;
	}
	@Override
	public String getPassword() {
		
		return password;
	}
	@Override
	public String getUsername() {
		
		return name;
	}
	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	

}
