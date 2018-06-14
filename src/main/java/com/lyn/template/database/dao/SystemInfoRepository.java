package com.lyn.template.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lyn.template.database.entity.SystemInfo;

public interface SystemInfoRepository extends JpaRepository<SystemInfo, Long>{
	
}
