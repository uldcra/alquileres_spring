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

import com.vps.junior.entity.Advertisement;
import com.vps.junior.entity.User;
import com.vps.junior.service.AdvertisementInterface;
import com.vps.junior.service.IuserService;



@CrossOrigin("*")
@RestController
@RequestMapping(path = "/user")
public class UserCotroller {
	
	
	@Autowired
	IuserService userService;
	
	@Autowired
	AdvertisementInterface advertisementService;
	
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
	
	@GetMapping(path = "/addfavo")
	@ResponseStatus(code = HttpStatus.OK)
	public User updateFavo(@RequestParam Long id, @RequestParam Long id_advfo) {
		User user1 = userService.finById(id);
		Advertisement advert = advertisementService.findById(id_advfo);
        //Advertisement anun2 = new Advertisement("Venta","Casa",(Integer)4,(Integer)2,120,"Madrid","calle azul,2",(double)200000);
		if (user1.getMyAdvertisements().contains(advert) ) {
			return null;
		}
		user1.setMyAdvertisements(advert);
		return userService.save(user1);
	}
	
	@GetMapping(path = "/removeFavo")
	@ResponseStatus(code = HttpStatus.OK)
	public User removeFavo(@RequestParam Long id, @RequestParam Long id_advfo) {
		User user1 = userService.finById(id);
		Advertisement advert = advertisementService.findById(id_advfo);
        //Advertisement anun2 = new Advertisement("Venta","Casa",(Integer)4,(Integer)2,120,"Madrid","calle azul,2",(double)200000);
		if (user1.getMyAdvertisements().contains(advert) ) {
			user1.removeMyAdvertisements(advert);
			return userService.save(user1);
		}
		//user1.removeMyAdvertisements(advert);
		return null;
	}
	
}
