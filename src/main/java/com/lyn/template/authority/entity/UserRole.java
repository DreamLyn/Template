package com.lyn.template.authority.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;


@Data
@Entity
public class UserRole {
	@Id
	@GeneratedValue
	private long id;
	private long userId;
	private long roleId;

}
