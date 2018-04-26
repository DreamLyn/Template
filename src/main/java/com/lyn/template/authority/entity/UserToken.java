package com.lyn.template.authority.entity;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class UserToken {
	@Id
	@GeneratedValue
	private long id;
	private long userId;
	private String token;
	private Timestamp createTime;
	private Timestamp refreshTime;
	private Timestamp validTime;
	private boolean isValid;
	
	
}
