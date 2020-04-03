package com.vps.junior.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vps.junior.entity.User;
import com.vps.junior.service.IuserService;


@CrossOrigin("*")
@RestController
@RequestMapping(path = "/user")
public class UserCotroller {
	@Autowired
	IuserService userService;
	
	@GetMapping(path = "/listar")
	@ResponseStatus(code = HttpStatus.OK)
	public List<User> listarUsusarios() {
		return userService.findAll();
		
	}
	
	@GetMapping(path = "/listar/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public User getUserByid(@PathVariable Long id) {
		return userService.finById(id);
		
	}
	
	@PostMapping(path = "/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public User create(@RequestBody User user) {
		return userService.save(user);
		
	}
	
	@DeleteMapping(path = "/user/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		 userService.delete(id);
		
	}
	
	@GetMapping(path = "/login")
	@ResponseStatus(code = HttpStatus.OK)
	@ResponseBody
	public User findByEmailOrName(@RequestParam String email, @RequestParam String password) {
		System.out.println("email" + email);
		//String data ="email: "+ email+ " name: " + name;
		return userService.findByEmailAddress(email, password);
		
		//return  null;
		
	}
}
