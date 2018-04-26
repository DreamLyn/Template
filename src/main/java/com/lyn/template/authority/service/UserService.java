package com.lyn.template.authority.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lyn.template.authority.dao.UserRepository;
import com.lyn.template.authority.entity.Role;
import com.lyn.template.authority.entity.User;
import com.mysql.fabric.xmlrpc.base.Array;


@Service
public class UserService implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleService roleService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> optional=userRepository.findByUsername(username);
		if(optional.isPresent()) {
			//此用户存在
			User user=optional.get();
			List<Role> roles=roleService.getRoleByUserId(user.getId());
			List<SimpleGrantedAuthority> grantedAuthorities=new ArrayList<>();
			for(Role role:roles) {
				grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
			}
			
	        return user;  
		}else {
			//用户不存在
			throw new UsernameNotFoundException(username+"用户不存在");
		}
	}
}
