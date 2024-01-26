package com.learning.demo.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.demo.entity.User;
import com.learning.demo.enums.Status;
import com.learning.demo.globalException.UserResponseException;
import com.learning.demo.model.UserRequest;
import com.learning.demo.model.UserResponse;
import com.learning.demo.repository.UserRepo;
import com.learning.demo.utils.Convertor;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private Convertor convertor;

	public UserResponse create(UserRequest userRequest) {
		UserResponse userResponse = null;
		if (Objects.nonNull(userRequest)) {
			User userEntity = convertor.requestToEntity(userRequest);
			userEntity = userRepo.save(userEntity);
			userResponse = convertor.entityToResponse(userEntity);
		}
		return userResponse;
	}

	public UserResponse findUserById(Long id){
			return userRepo.findById(id).map(convertor::entityToResponse)
					.orElseThrow(()->new UserResponseException("user with id " + id + " not found"));
	}
	

	public UserResponse update(Long id, UserRequest userRequest) {
			return userRepo.findById(id).map(userEntity -> {
				User updatedUserEntity = convertor.updateEntity(userRequest, userEntity);
				User savedUserEntity = userRepo.save(updatedUserEntity);
				return convertor.entityToResponse(savedUserEntity);
			}).orElseThrow(()->new UserResponseException("user with id " + id  + " details not updated "));
	}

	
	
	public Status deleteUserById(Long id) {
		Optional<User> optionalEntity = userRepo.findById(id);
		if (optionalEntity.isPresent()) {
			userRepo.deleteById(id);
			return Status.SUCCESS;
		}
		return Status.FAILED;
	}

}

