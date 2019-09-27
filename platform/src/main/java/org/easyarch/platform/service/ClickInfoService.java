package org.easyarch.platform.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.easyarch.platform.dao.PieChartDao;
import org.easyarch.platform.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 * @ClassName ClickInfoService
 * @Description TODO
 * @Author Liyihe
 * @Date 2019/09/26 下午7:41
 * @Version 1.0
 */
@Component
public class ClickInfoService {
    @Autowired
    PieChartDao pieChartDao;
    @KafkaListener(topics = "light")
    public String clickInfoListen(ConsumerRecord<?, String> record){
        Jedis jedis= RedisUtil.getJedis();
        pieChartDao.getPieChartAll(jedis);
        String value = record.value();
        System.out.println("vvv "+value);
        jedis.close();
        return "";
    }
}
