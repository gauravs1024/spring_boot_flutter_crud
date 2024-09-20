package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo repo;
	public String saveUser(User user) {
		repo.save(user);
		return "User Registered Successful";
	

	}
	
	// method to fetch all users
	public List<User>getAllUsers(){
		return repo.findAll();
	}
	
	// method to find user by id
	public Optional<User>getUserById(Integer id){
		return repo.findById(id);
	}
	
	/*
	
	// method to update the exisiting user
	public String updateUser(Integer id,User updateuser) {
		// Find the existing user by ID
		
		Optional<User>existingUserOpt=repo.findById(id);
		if(existingUserOpt.isPresent()) {
			User existingUser=existingUserOpt.get();
			
			//Update fileds
			existingUser.setName(updateuser.getName());
			existingUser.setEmail(updateuser.getEmail());
			existingUser.setAddress(updateuser.getAddress());
			existingUser.setPhone(updateuser.getPhone());
		
			// save the updated user
			repo.save(existingUser);
		return "User updated successfully";
	}
	else {
		return "User not Found";
	}
	}
	*/
	
	// function to delete the user by id
	public String deleteUser(Integer id) {
		Optional<User> existingUserOpt=repo.findById(id);
		if(existingUserOpt.isPresent()) {
			repo.deleteById(id);
			return "User deleted successfully";
			}
		else {
			return "User not found";
		}
	}
	
	 public String updateUser(User updateRequest) {
	        // Find the existing user by ID
	        Optional<User> existingUserOpt = repo.findById(updateRequest.getId());
	        if (existingUserOpt.isPresent()) {
	            User existingUser = existingUserOpt.get();
	            
	            // Update fields
	            existingUser.setName(updateRequest.getName());
	            existingUser.setEmail(updateRequest.getEmail());
	            existingUser.setAddress(updateRequest.getAddress());
	            existingUser.setPhone(updateRequest.getPhone());

	            // Save the updated user
	            repo.save(existingUser);
	            return "User updated successfully";
	        } else {
	            return "User not found";
	        }
	    }
	
	
	
}
