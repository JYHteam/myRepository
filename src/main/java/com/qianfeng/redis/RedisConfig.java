package com.qianfeng.redis;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@EnableCaching//开启缓存支持
public class RedisConfig extends CachingConfigurerSupport{
    @Bean //将方法返回的对象交由spring管理
    public JedisConnectionFactory createFactory(){
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName("127.0.0.1");
        factory.setPort(6379);
        return factory;
    }
    @Bean
    public RedisTemplate<String,String> createTemplate(JedisConnectionFactory factory){
       RedisTemplate<String,String> template=new RedisTemplate<String, String>();
       template.setConnectionFactory(factory);
       return template;
    }
    @Bean
    public RedisCacheManager createCache(RedisTemplate<String,String> template){
        return new RedisCacheManager(template);
    }
}
