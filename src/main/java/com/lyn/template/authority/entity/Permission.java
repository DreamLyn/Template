package com.lyn.template.authority.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity
public class Permission {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String description;
	private String url;
	private int pid;
	
	/**
	 * 预留，为后期支持restful
	 */
	private String method;
}
