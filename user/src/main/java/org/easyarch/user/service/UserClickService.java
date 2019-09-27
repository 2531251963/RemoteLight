package org.easyarch.user.service;

import com.alibaba.fastjson.JSON;
import org.easyarch.user.dao.UserDaoInter;
import org.easyarch.user.pojo.UserClickInfo;
import org.easyarch.user.pojo.UserMessage;
import org.easyarch.user.util.Const;
import org.easyarch.user.util.RedisUtil;
import org.easyarch.user.util.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName UserClickService
 * @Description TODO
 * @Author Liyihe
 * @Date 2019/09/20 上午10:40
 * @Version 1.0
 */
@Service
public class UserClickService {
    private SimpleDateFormat formatter = new SimpleDateFormat("MM-dd,HH:mm:ss");
    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;
    @Autowired
    private UserDaoInter userDaoInter;
    public String click(UserMessage userMessage){
        System.out.println(userMessage);
        if (!userMessage.getType().equals(Const.FAST)&&!userMessage.getType().equals(Const.SHORT)&&!userMessage.getType().equals(Const.NORMAL)){ return Const.BAD_REQUEST;}
        Date date=new Date();
        UserClickInfo clickInfo=new UserClickInfo();
        clickInfo.setUserid(userMessage.getUserid());
        clickInfo.setDate(formatter.format(date.getTime()));
        clickInfo.setInfo(userMessage.getMessage());
        clickInfo.setId(String.valueOf(SnowFlake.nextId()));
        String userClickInfo= JSON.toJSONString(clickInfo);
        kafkaTemplate.send("light",userClickInfo);
        Jedis jedis=RedisUtil.getJedis();
        jedis.zadd("list",date.getTime(),userClickInfo);
        jedis.incr(userMessage.getType());
        jedis.close();
        userDaoInter.insertInfo(clickInfo);
        return Const.CLICKOK;
    }

    public static void main(String[] args) {
        UserClickService service=new UserClickService();

        System.out.println(service.formatter.format(new Date()));
    }
}
