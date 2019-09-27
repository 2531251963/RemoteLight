package org.easyarch.platform.service;

import com.alibaba.fastjson.JSON;
import org.easyarch.platform.pojo.RealTimeData;
import org.easyarch.platform.util.Const;
import org.easyarch.platform.util.RedisUtil;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 * @ClassName RealTimeService
 * @Description TODO
 * @Author Liyihe
 * @Date 2019/09/26 下午6:29
 * @Version 1.0
 */
@Service
public class RealTimeService {
    public String readTime(){
        Jedis jedis= RedisUtil.getJedis();
        RealTimeData timeData=new RealTimeData();
        timeData.set_fast(jedis.get(Const.FAST));
        timeData.set_short(jedis.get(Const.SHORT));
        timeData.setColor(0);
        return JSON.toJSONString(timeData);
    }
}
