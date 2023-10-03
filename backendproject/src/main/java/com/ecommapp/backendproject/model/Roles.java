package com.ecommapp.backendproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.Set;
import java.util.HashSet;

@Entity
public class Roles {

   
	@Id
    @Column(name="Role_ID",nullable=false)
    private int roleId;
    @Column(name="Role_Name",nullable=false)
    private String roleName;
    
    @ManyToMany(mappedBy = "roles")
    Set<User> user = new HashSet<>();
    
    public Roles(int roleId, String roleName, Set<User> user) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.user=user;
	}
    
    public Roles() {
    	super();
    }
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Set<User> getUser() {
		return user;
	}
	public void setUser(Set<User> user) {
		this.user = user;
	}
    
}
