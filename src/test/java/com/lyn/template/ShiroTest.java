package com.lyn.template;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class ShiroTest {
	Subject currentUser=SecurityUtils.getSubject();
	
}
