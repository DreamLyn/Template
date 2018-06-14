package com.lyn.template.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@PropertySource("classpath:config/system.properties")
@ConfigurationProperties(prefix = "system")
public class SystemConfig {
	private String name;
	private String version;
	
}
