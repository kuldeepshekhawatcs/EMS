package com.ems.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {

	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="role_id")
	private Integer roleId;
	
	@Column(name="role_name")
	private String roleName;
	
	@Column(name="permissions")
	@ElementCollection(targetClass=String.class)
	private Set<String> rolePermission = new HashSet<String>();
	
	public Role() {
		super();
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<String> getRolePermission() {
		return rolePermission;
	}

	public void setRolePermission(Set<String> rolePermission) {
		this.rolePermission = rolePermission;
	}

	
	
}
