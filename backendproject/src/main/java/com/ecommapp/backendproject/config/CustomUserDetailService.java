package com.ecommapp.backendproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecommapp.backendproject.Exception.ResourceNotFoundException;
import com.ecommapp.backendproject.model.User;
import com.ecommapp.backendproject.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	private UserRepository userRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User userbyemail = this.userRepo.findByEmail(email).orElseThrow(()-> new ResourceNotFoundException("No users find by email"));
		
		CustomUserDetails customuserdetails = new CustomUserDetails(userbyemail);
		return customuserdetails;
	
	}

}
