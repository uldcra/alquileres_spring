package com.vps.junior.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vps.junior.dao.IuserDao;
import com.vps.junior.entity.User;

@Service
public class UserService implements IuserService{
	
	@Autowired
	private IuserDao userDao;

	@Override
	@Transactional(readOnly = true)
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return (List<User>) userDao.findAll();
		//return (List<User>) userDao.findAllUsers();
	}

	@Override
	public User finById(Long id) {
		// TODO Auto-generated method stub
		return userDao.findById(id).orElse(null);
	}

	@Override
	public User save(User user ) {
		// TODO Auto-generated method stub
		return userDao.save(user);
	}

	@Override
	public void delete(Long id) {
		userDao.deleteById(id);
		
		
	}

	@Override
	@Transactional
	public User findByEmailAddress(String email,String name) {
		
		return userDao.findByEmail(email, name);
	}




	
	
	
	

}
