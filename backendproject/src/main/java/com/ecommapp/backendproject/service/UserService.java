package com.ecommapp.backendproject.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommapp.backendproject.dto.UserDTO;
import com.ecommapp.backendproject.model.User;
import com.ecommapp.backendproject.repository.UserRepository;

import com.ecommapp.backendproject.Exception.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private ModelMapper mapper;
	private UserDTO userdtoobj;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public UserDTO createUser(UserDTO userdto) {
		
		User user = this.mapper.map(userdto, User.class);
		String passEncode = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(passEncode);
		User saveuser = this.userRepo.save(user);
		UserDTO savedto = this.mapper.map(saveuser, UserDTO.class);
		return savedto;
	}
    
	public UserDTO getUserById(int userId) {
		
		Optional<User> user = this.userRepo.findById(userId);
		user.ifPresentOrElse(userobj -> {userdtoobj = this.mapper.map(userobj,UserDTO.class);}, ()-> new ResourceNotFoundException("UserId not found"));
		return userdtoobj;
		
	}
	
	public void deleteUser(int userId) {
		
		Optional<User> user = this.userRepo.findById(userId);
		 user.ifPresentOrElse(userobj -> this.userRepo.delete(userobj), ()-> new ResourceNotFoundException("UserId not found"));
		
	}
	
	public List<UserDTO> findAllUser(){
		
		List<User> allUsers = this.userRepo.findAll();
		return allUsers.stream().map(user -> this.mapper.map(user, UserDTO.class)).collect(Collectors.toList());
		
	}
	
	public UserDTO updateUser(int userId, UserDTO userdto) {
		
		Optional<User> user = this.userRepo.findById(userId);
		user.ifPresentOrElse(userobj -> 
			{
				userobj.setAbout(userdto.getAbout());
				userobj.setAbout(userdto.getAddress());
				userobj.setActive(userdto.isActive());
				userobj.setDate(userdto.getDate());
				userobj.setEmail(userdto.getEmail());
				userobj.setGender(userdto.getGender());
				userobj.setName(userdto.getName());
				userobj.setPassword(userdto.getPassword());
				userobj.setPhone(userdto.getPhone());
				this.userRepo.save(userobj);
				userdtoobj = this.mapper.map(userobj,UserDTO.class);}, ()-> new ResourceNotFoundException("UserId not found"));
		
		return userdtoobj;
	}
}
