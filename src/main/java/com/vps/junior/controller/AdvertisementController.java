package com.vps.junior.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.vps.junior.entity.Advertisement;
import com.vps.junior.service.AdvertisementInterface;


@CrossOrigin("*")
@RestController
@RequestMapping(path = "/advertisement")
public class AdvertisementController {
	
	@Autowired
	AdvertisementInterface adve;
	

	
	@GetMapping(path = "/listar")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Advertisement> listarUsusarios() {
		return adve.findAll();
		
	}
	
	@GetMapping(path = "/listar/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Advertisement getAdvertisementByid(@PathVariable Long id) {
		return adve.findById(id);
		
	}
	
	@PostMapping(path = "/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Advertisement create(@RequestBody Advertisement Advertisement) {
		return adve.save(Advertisement);
		
	}
	
	@DeleteMapping(path = "/Advertisement/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		adve.delete(id);
		
	}
	

}
