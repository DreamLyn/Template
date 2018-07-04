package com.lyn.modules.user.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity
public class Role {
	@Id
	@GeneratedValue
	private long id;
	private String name;
}
