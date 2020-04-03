package com.vps.junior.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.vps.junior.entity.User;

public interface IuserService {
	
	public List<User> findAll();
	
	public User finById(Long id);
	
	public User save( User user );
	
	public void delete( Long id);
	
	public User findByEmailAddress(String email, String name);
	

	

}
