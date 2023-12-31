package com.ecommapp.backendproject.model;

import java.util.Date;
import java.util.Set;
import java.util.HashSet;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="user_info")

public class User  {

	 
	@Id
	  @GeneratedValue(strategy= GenerationType.SEQUENCE)
	  private int userId;
	  
	  @Column(nullable =false)
	  private String name;
	  @Column(unique=true,nullable =false)
	  private String email;
	  @Column(nullable =false)
	  private String password;
	  
	  private String address;
	  private String about;
	  @Column(nullable =false)
	  private String gender;
	  @Column(nullable =false,length=10)
	  private String phone;
	  
	  @Column(name="CreatedOn")
	  private Date date;
	  private boolean active;
	  
	  @ManyToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	  Set<Roles> roles = new HashSet<>();
	  
	  @OneToOne(mappedBy = "user")
	  private Cart cart;
	  
	  public User(int userId, String name, String email, String password, String address, String about, String gender,
				String phone, Date date, boolean active) {
			super();
			this.userId = userId;
			this.name = name;
			this.email = email;
			this.password = password;
			this.address = address;
			this.about = about;
			this.gender = gender;
			this.phone = phone;
			this.date = date;
			this.active = active;
			//this.roles =roles;
			//this.cart=cart;
		}
	  public User() {
		  super();
	  }
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Set<Roles> getRoles() {
		return roles;
	}
	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
}
