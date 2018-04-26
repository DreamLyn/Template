package com.lyn.template.authority.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;


@Data
@Entity
public class Role {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	
	@ManyToOne
	private UserRole userRole;
}
