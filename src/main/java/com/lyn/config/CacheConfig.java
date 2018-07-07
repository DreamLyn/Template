package com.lyn.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

/**
 * 配置cache
 */
//@Configuration
//@EnableCaching
public class CacheConfig extends CachingConfigurerSupport{
    @Nullable
    @Override
    public CacheManager cacheManager() {
        return super.cacheManager();
    }

    @Nullable
    @Override
    public KeyGenerator keyGenerator() {
        return  new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(target.getClass().getName());
                stringBuilder.append(method.getName());
                for (Object object : params){
                    stringBuilder.append(object.toString());
                }
                return  stringBuilder.toString();
            }
        };
    }

    @Nullable
    @Override
    public CacheResolver cacheResolver() {
        return super.cacheResolver();
    }


    @Nullable
    @Override
    public CacheErrorHandler errorHandler() {
        return super.errorHandler();
    }
}
