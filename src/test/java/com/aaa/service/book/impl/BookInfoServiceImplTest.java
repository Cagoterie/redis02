package com.aaa.service.book.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author qy105小仙女
 * @version 1.0
 * @Date 2019/11/19
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookInfoServiceImplTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void stringTest(){
        ValueOperations operations = redisTemplate.opsForValue();
        operations.set("name","cagoterie");
        System.out.println(operations.get("name"));
    }

    @Test
    public void mapTest(){
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.put("myHash","age","18");

        BoundHashOperations myHash = redisTemplate.boundHashOps("myHash");
        myHash.put("name","cagoterie");

        String age = ((String) myHash.get("age"));
        System.out.println("age:" + age);

        String name = (String) myHash.get("name");
        System.out.println("name:" + name);
    }

    @Test
    public void listTest(){
        ListOperations listOperations = redisTemplate.opsForList();
        listOperations.leftPush("myList",1);
        listOperations.leftPush("myList",2);
        listOperations.leftPush("myList",3);

        BoundListOperations myList = redisTemplate.boundListOps("myList");
        myList.leftPush("4");
        myList.rightPush("5");

        Integer index = ((Integer) myList.index(3));
        System.out.println("index:" + index);
    }
}