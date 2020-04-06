package com.vps.junior.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(name = "usuarios")
public class User  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@Column(length = 60)
	private String password;

	private String name;

	
	@Column(unique = true)
	private String email;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name="usuarios_roles", joinColumns= @JoinColumn(name="usuario_id"),
	inverseJoinColumns=@JoinColumn(name="role_id"),
	uniqueConstraints= {@UniqueConstraint(columnNames= {"usuario_id", "role_id"})})
	private List<Role> roles;
	
	//@OneToMany(cascade=CascadeType.REMOVE, orphanRemoval = true)
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name="usuarios_my_advertisements", joinColumns= @JoinColumn(name="usuario_id"),
	inverseJoinColumns=@JoinColumn(name="my_advertisements_id"),
	uniqueConstraints= {@UniqueConstraint(columnNames= {"usuario_id", "my_advertisements_id"})})
	private List<Advertisement> myAdvertisements;
	
	public User() {
		
	}
	
	public User(String name, String email, String password ,String roles) {
		super();
		List<Role> nuevoRol = new ArrayList<Role>();
		Role rol = new Role();
		rol.setNombre(roles);
		nuevoRol.add(rol);
		this.password = password;
		this.name = name;
		this.email = email;
		this.roles = nuevoRol;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		List<Role> misRoles = new ArrayList<Role>();
		if ( roles.contains(",") ) {
			String[] roles1 = roles.split(",");
		
			for (int i = 0; i < roles1.length; i++) {
				if ( roles1[i].isEmpty() ) {
					
				} else {
					Role nuevoRol = new Role();
					nuevoRol.setNombre(roles1[i]);
					misRoles.add(nuevoRol);
				}
				
				
			}
			this.roles = misRoles;
		} else {
			if ( roles.isEmpty() ) {
				
			} else {
				Role nuevoRol = new Role();
				nuevoRol.setNombre(roles);
				misRoles.add(nuevoRol);
				this.roles = misRoles;
			}
		}

		
	}
	
	public List<Advertisement> getMyAdvertisements() {
		return myAdvertisements;
	}

	public void setMyAdvertisements(Advertisement advert) {
		this.myAdvertisements.add(advert);
		/*List<Advertisement> advert1 = new ArrayList<Advertisement>();
		advert1.add(advert);*/
		
		//this.myAdvertisements = advert1;
	}
	
	public void removeMyAdvertisements(Advertisement advert) {
		this.myAdvertisements.remove(advert);
		/*List<Advertisement> advert1 = new ArrayList<Advertisement>();
		advert1.add(advert);*/
		
		//this.myAdvertisements = advert1;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
