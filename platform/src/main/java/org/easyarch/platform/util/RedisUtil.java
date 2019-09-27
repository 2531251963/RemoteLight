package org.easyarch.platform.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @ClassName RedisUtil
 * @Description TODO
 * @Author Liyihe
 * @Date 2019/09/20 上午10:12
 * @Version 1.0
 */
public class RedisUtil {

    private static volatile JedisPool pool = null;

    /**
     * 获取连接池 单列线程安全
     */
    private static JedisPool getPool() {
        if (pool == null) {
            synchronized (JedisPool.class) {
                if (pool == null) {
                    JedisPoolConfig config = new JedisPoolConfig();
                    config.setMaxTotal(1000);
                    pool = new JedisPool(config, "localhost", 6379);//config set protected-mode "no"
                }
            }
        }
        return pool;
    }

    /**
     * 从连接池获取Jedis
     */
    public static Jedis getJedis() {
        JedisPool pool = getPool();
        return pool.getResource();
    }
}
