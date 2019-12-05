package com.aaa;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import redis.clients.jedis.Jedis;


import java.util.HashMap;

/**
 * @author qy105小仙女
 * @version 1.0
 * @Date 2019/11/19
 */
public class Redis {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.6.111", 6379);
        System.out.println(jedis.ping());

        /*保存字符串*/
        /*jedis.set("myList", "xiaoxiao");
        System.out.println(jedis.get("myList"));*/

        /*保存哈希表*/
        /*HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("name", "aa");
        hashMap.put("class", "105");
        jedis.hmset("myHash", hashMap);
        System.out.println(jedis.hmget("myHash", "name"));*/

        /*保存list*/
        /*jedis.rpush("mys", "aa", "bb", "ss");
        System.out.println(jedis.lrange("mys", 0, -2));
        System.out.println(jedis.lindex("mys", 1));*/

        /*保存set*/
        jedis.sadd("mySet","11","84","1");
        System.out.println(jedis.smembers("mySet"));


    }
}
