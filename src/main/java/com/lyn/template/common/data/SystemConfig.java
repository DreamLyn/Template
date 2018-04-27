package com.lyn.template.common.data;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@PropertySource("classpath:config/system.properties")
@ConfigurationProperties(prefix="status")
@Component
public class SystemConfig {
    //成功返回码
    private int success;
    //权限不足返回码
    private int permission;
}
