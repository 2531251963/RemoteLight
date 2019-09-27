package org.easyarch.user.server;

import org.easyarch.user.dao.UserDaoInter;
import org.easyarch.user.pojo.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ATest
 * @Description TODO
 * @Author Liyihe
 * @Date 2019/09/21 上午12:26
 * @Version 1.0
 */
@RestController
public class ATest {
    @Autowired
    UserDaoInter userDaoInter;
    @RequestMapping(value = "/t")
    public void test(@RequestBody String a1){
   /*     Random random=new Random();
        System.out.println("1");
        List<A> as=new LinkedList<>();
        for (int i = 0; i < 1000000; i++) {
            A a=new A();
            a.setA1(random.nextInt(999999)+"a"+System.currentTimeMillis()+random.nextInt(999999)+"");
            a.setA2("a2");
            as.add(a);
        }
       userDaoInter.insertlist(as);*/
    }

}
