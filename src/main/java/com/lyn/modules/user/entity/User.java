 package com.lyn.modules.user.entity;

import java.util.Date;

import javax.persistence.*;

import com.lyn.modules.user.bean.Gender;

import lombok.Data;

@Data
@Entity
@Table(name="user")
public class User{

	@Id
	@GeneratedValue
	private long id;
	@Column(name="username",length=20,nullable=false)
	private String username;
	@Column(name="password",length=30,nullable=false)
	private String password;
	@Temporal(TemporalType.DATE)
	private Date birthday;
	@Enumerated(EnumType.STRING)
	@Column(length=10,nullable=false)
	private Gender gender=Gender.UNKNOWN;
	
//	@Lob //处理大文本
//	@Basic(fetch=FetchType.LAZY) //如果文件特别大,使用懒加载,使得内存占用小一些
//	@Transient   //不进行持久化
}
