package org.easyarch.platform.dao;

import org.easyarch.platform.pojo.PieChart;
import org.easyarch.platform.util.Const;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

import java.math.BigDecimal;

/**
 * @ClassName PieChartDao
 * @Description TODO
 * @Author Liyihe
 * @Date 2019/09/26 下午7:44
 * @Version 1.0
 */
@Repository
public class PieChartDao {

    public PieChart getPieChartAll(Jedis jedis){
        PieChart pieChart=new PieChart();
        BigDecimal _fast=new BigDecimal(jedis.get(Const.FAST));
        BigDecimal _short=new BigDecimal(jedis.get(Const.SHORT));
        BigDecimal _normal=new BigDecimal(jedis.get(Const.NORMAL));
        BigDecimal _all=_fast.add(_short).add(_normal);
        pieChart.set_fast(_fast.divide(_all,Const.THREE,BigDecimal.ROUND_HALF_UP).doubleValue());
        pieChart.set_short(_short.divide(_all,Const.THREE,BigDecimal.ROUND_HALF_UP).doubleValue());
        pieChart.set_normal(_normal.divide(_all,Const.THREE,BigDecimal.ROUND_HALF_UP).doubleValue());
        return pieChart;
    }
}
