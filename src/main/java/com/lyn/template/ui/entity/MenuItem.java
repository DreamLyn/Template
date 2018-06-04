package com.lyn.template.ui.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class MenuItem {
	@Id
	@GeneratedValue
	private long id;

	private String menuValue;
	private long parendId;
}
