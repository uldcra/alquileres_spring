package com.vps.junior;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vps.junior.dao.IAdvertisementDao;
import com.vps.junior.dao.IuserDao;
import com.vps.junior.entity.User;
import com.vps.junior.entity.Advertisement;

@Component
public class iniBBDD {
	
	   @Autowired
	   IuserDao userRepository;
	   @Autowired
	   IAdvertisementDao AdvertisementRepository;
	   /**
	 *  Esto funciona si properties tiene la propiedad create or create-drop
	 */
	/*@PostConstruct
	    public void init(){

	        
	        User User2 = new User();
	        User2.setName("Edu");
	        User2.setEmail("edu@gmail.com");
	        User2.setPassword("12345678");
	        User2.setRoles("ROLE_USER");
	        userRepository.save(User2);
	        
	        User User3 = new User();
	        User3.setName("Mortadelo");
	        User3.setEmail("filemon@gmail.com");
	        User3.setPassword("12345678");
	        User3.setRoles("ROLE_USER");
	        userRepository.save(User3);
	        System.out.println("User insertado");
	      
	        User admin = new User("admin", "admin@gmail.com","admin","ROLE_ADMIN");
	        userRepository.save(admin);
	      
	     
	        User User4 = new User("Karol","karol@gmail.com","12345678","ROLE_ADMIN");
	        userRepository.save(User4);
	        
	        User User5 = new User("Sebastian","sebastian@gmail.com","12345678","ROLE_USER");
	        userRepository.save(User5);
	        
	        Advertisement anun1 = new Advertisement("Venta","Casa",(Integer)4,(Integer)2,120,"Madrid","calle amarillo,2",(double)200000);
	        AdvertisementRepository.save(anun1);
	        
	        Advertisement anun2 = new Advertisement("Venta","Casa",(Integer)4,(Integer)2,120,"Madrid","calle azul,2",(double)200000);
	        AdvertisementRepository.save(anun2);
	        
	        Advertisement anun3 = new Advertisement("Venta","Casa",(Integer)4,(Integer)2,120,"Madrid","calle verde,2",(double)200000);
	        AdvertisementRepository.save(anun3);
	        }*/

}
