package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@CrossOrigin	// dont forgot  to add this
public class UserController {

	
		@Autowired
		private UserService service;
		
		@PostMapping("/register")
		private ResponseEntity<String>registerUser(@RequestBody User user){
			//save the user
			String msg=service.saveUser(user);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		
		@GetMapping("/users/all")
		public List<User>getAllUsers(){
			return service.getAllUsers();
		}
		
		// Fetching a user by id
		@PostMapping("/user/{id}")
		public Optional<User>getUserById(@PathVariable Integer id){
			return service.getUserById(id);
		}
		
		/*
		// updating a user by Id
		@PostMapping("/update/{id}")
		public ResponseEntity<String>updateUser(@PathVariable Integer id,@RequestBody User updateUser){
			String response =service.updateUser(id,updateUser);
			if(response.equals("User updated successfully")) {
				return ResponseEntity.ok(response);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		
		}
		*/
		@PostMapping("delete/{id}")
		public ResponseEntity<String>deleteUser(@PathVariable Integer id){
			String response=service.deleteUser(id);
			if(response.equals("User deleted successfully")) {
				return ResponseEntity.ok(response);
			}
			else {
				return ResponseEntity.notFound().build();
			}

			
		}
		
		 @PostMapping("/update")
		    public ResponseEntity<String> updateUser(@RequestBody User updateRequest) {
		        String responseMessage = service.updateUser(updateRequest);
		        
		        if ("User updated successfully".equals(responseMessage)) {
		            return ResponseEntity.ok(responseMessage); // HTTP 200
		        } else {
		            return ResponseEntity.status(404).body(responseMessage); // HTTP 404
		        }
		    }
		
		  
		   
		  
		
		
		
		
}
