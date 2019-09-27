package org.easyarch.user.util;

import redis.clients.jedis.Jedis;

/**
 * @ClassName UserManager
 * @Description TODO
 * @Author Liyihe
 * @Date 2019/09/20 上午10:10
 * @Version 1.0
 */
public class UserManager {
    public static Long userCountAdd(){
        Jedis jedis=RedisUtil.getJedis();
        Long count=jedis.incr(Const.USERCOUNT);
        jedis.incr(Const.NORMAL);
        jedis.close();
        return count;
    }
    public static Long userCountDecr(){
        Jedis jedis=RedisUtil.getJedis();
        Long count=jedis.decr(Const.USERCOUNT);
        jedis.decr(Const.NORMAL);
        jedis.close();
        return count;
    }
}
