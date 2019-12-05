package com.aaa.redis;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Set;

/**
 * @author qy105小仙女
 * @version 1.0
 * @Date 2019/11/19
 */
public class RedisCache implements Cache {

    /**
     * id 为mapper 的命名空间 com.aaa.mapper.BookMapper
     */
    private final String id;
    private RedisTemplate<String, Object> redisTemplate;
    private static Logger logger = LoggerFactory.getLogger(RedisCache.class);
    private static final long EXPIRE_TIME = 30;

    public RedisCache(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Cache instance requires an id");
        }
        this.id = id;
    }

    /**
     * MyBatis 缓存操作对象的标识符，一个mapper对象对应一个MyBatis缓存操作对象
     * @return
     */
    @Override
    public String getId() {
        return id;
    }

    /**
     * 将查出结果存入缓存
     * @param key
     * @param value
     */
    @Override
    public void putObject(Object key, Object value) {
        redisTemplate = getRedisTemplate();
        if (null!=value) {
            try {
                redisTemplate.opsForValue().set(key.toString(), value);
            }catch (Exception e){
                e.printStackTrace();
                logger.warn(e.getMessage());
            }
        }else {
            logger.info("the value is null at putObject ");
        }

    }

    @Override
    public Object getObject(Object obj) {

        redisTemplate= getRedisTemplate();
        if (obj!=null) {
            try {
                return  redisTemplate.opsForValue().get(obj.toString());
            }catch (Exception e){
                e.printStackTrace();
                logger.warn(e.getMessage());
            }
        }else {
            logger.info("the obj is null at getObject");
        }
        return null;
    }

    @Override
    public Object removeObject(Object obj) {
        redisTemplate = getRedisTemplate();
        try {
            redisTemplate.delete(obj.toString());
        }catch (Exception e){
            e.printStackTrace();
            logger.warn(e.getMessage());
        }
        return null;
    }

    @Override
    public void clear() {
        redisTemplate = getRedisTemplate();
        try {
            Set<String> keys = redisTemplate.keys("*" + id + "*");
            redisTemplate.delete(keys);
        }catch (Exception e){
            e.printStackTrace();
            logger.warn(e.getMessage());
        }
    }

    @Override
    public int getSize() {
        redisTemplate = getRedisTemplate();
        int size = redisTemplate.keys("*").size();
        return size;
    }

    public RedisTemplate getRedisTemplate(){
        if (null==redisTemplate) {
            this.redisTemplate = SpringContextConfig.getBean("redisTemplate");
        }
        return redisTemplate;
    };
}
