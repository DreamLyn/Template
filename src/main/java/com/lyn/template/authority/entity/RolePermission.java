package com.lyn.template.authority.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity
public class RolePermission {
	@Id
	@GeneratedValue
	private long id;
	private long roleId;
	private long permissionId;
}
