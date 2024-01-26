package com.learning.demo.utils;

import org.springframework.stereotype.Component;

import com.learning.demo.entity.User;
import com.learning.demo.model.UserRequest;
import com.learning.demo.model.UserResponse;

@Component
public class Convertor {
	
	public User requestToEntity(UserRequest userRequest) {
		User userEntity = new User();
		userEntity.setPassword(userRequest.getPassword());
		userEntity.setPhoneNumber(userRequest.getPhoneNumber());
		userEntity.setEmail(userRequest.getEmail());
		userEntity.setRole(userRequest.getRole());
		return userEntity;
	}
	
	public UserResponse entityToResponse(User userEntity) {
		UserResponse userResponse = new UserResponse();
		userResponse.setId(userEntity.getId());
		userResponse.setPassword(userEntity.getPassword());
		userResponse.setPhoneNumber(userEntity.getPhoneNumber());
		userResponse.setRole(userEntity.getRole());
		userResponse.setEmail(userEntity.getEmail());
		return userResponse;
	}
	
	public User updateEntity(UserRequest userRequest, User userEntity) {
		userEntity.setPassword(userRequest.getPassword());
		userEntity.setPhoneNumber(userRequest.getPhoneNumber());
		userEntity.setEmail(userRequest.getEmail());
		userEntity.setRole(userRequest.getRole());
		return userEntity;
	}
}
