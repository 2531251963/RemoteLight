package org.easyarch.platform.service;

import com.alibaba.fastjson.JSON;
import org.easyarch.platform.dao.PieChartDao;
import org.easyarch.platform.pojo.InitData;
import org.easyarch.platform.pojo.PieChart;
import org.easyarch.platform.pojo.UserClickInfo;
import org.easyarch.platform.util.Const;
import org.easyarch.platform.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.math.BigDecimal;
import java.util.Set;

/**
 * @ClassName InitListService
 * @Description TODO
 * @Author Liyihe
 * @Date 2019/09/20 上午9:31
 * @Version 1.0
 */
@Service
public class InitListService {
    @Autowired
    PieChartDao pieChartDao;
    public String initData(){
        //ZREVRANGE
        Jedis jedis= RedisUtil.getJedis();
        Set<String> set=jedis.zrevrange("list",0,19);
        InitData initData=new InitData();
        initData.setListjson(set);
        initData.setPieChart(pieChartDao.getPieChartAll(jedis));
        jedis.close();
        return JSON.toJSONString(initData);
    }

    public static void main(String[] args) {
        BigDecimal b1=new BigDecimal("36");
        BigDecimal b2=new BigDecimal("1");
        BigDecimal b3=new BigDecimal("2");
        BigDecimal _all=b1.add(b2).add(b3);
        double b11=b1.divide(_all,3, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(b11);
    }
}
