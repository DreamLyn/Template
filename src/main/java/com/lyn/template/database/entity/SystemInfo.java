 package com.lyn.template.database.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.lyn.template.authority.bean.Gender;

import lombok.Data;

@Data
@Entity
@Table(name="system_info")
public class SystemInfo{

	@Id
	private long id;
	@Column(name="version",length=20,nullable=false)
	private String version;
}
