package com.atlucky.springsecuritytest.config;

import com.atlucky.springsecuritytest.constant.FastJsonJsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Date 2023/8/11 17:14
 * @Author XiaoHu
 * @Description
 **/
@Configuration
public class RedisConfig {
    /**
     * 复述,模板
     *
     * @param connectionFactory 连接工厂
     * @return {@link RedisTemplate}<{@link Object},{@link Object}>
     */
    @Bean
    @SuppressWarnings(value = {"unchecked","rawtypes"})
    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory connectionFactory){
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        FastJsonJsonRedisSerializer<Object> serializer = new FastJsonJsonRedisSerializer<>(Object.class);
        //使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(serializer);
        //使用StringRedisSerializer来序列化和反序列化redis的hash的key值
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(serializer);
        template.afterPropertiesSet();
        return template;
    }
}
