package com.vps.junior.dao;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.vps.junior.entity.User;


public interface IuserDao extends CrudRepository<User, Long> {

	// @Query("select u from users u where u.emailAddress = ?1")
	/*@Transactional
	@Query("SELECT * FROM users")
	public User email(String email);*/
	@Query(value = "SELECT * FROM clasesDos.usuarios where (email= ?1 or name=?1) and (password= ?2);", nativeQuery = true)
	 User findByEmail(String email, String password);
	
	@Query(value = "SELECT * FROM clasesDos.usuarios;", nativeQuery = true)
	 List<User> findAllUsers();
}
