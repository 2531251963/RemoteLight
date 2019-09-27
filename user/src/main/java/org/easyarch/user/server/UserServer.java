package org.easyarch.user.server;

import com.alibaba.fastjson.JSON;
import org.easyarch.user.pojo.RequestApi;
import org.easyarch.user.pojo.UserMessage;
import org.easyarch.user.util.BeanUtil;
import org.easyarch.user.util.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;

/**
 * @ClassName UserServer
 * @Description TODO
 * @Author Liyihe
 * @Date 2019/09/20 上午10:08
 * @Version 1.0
 */
@ServerEndpoint("/user/main")
@Component
public class UserServer {
    @OnOpen
    public void onOpen(Session session) {
        UserManager.userCountAdd();

    }

    @OnMessage
    public void onMessage(Session session,String data) throws Exception {
        RequestApi requestApi= JSON.parseObject(data,RequestApi.class);
        System.out.println(requestApi);
        String resurl[]=requestApi.getUrl().split("/");
        Object clazz= BeanUtil.getBean(resurl[1]);
        Method method=clazz.getClass().getMethod(resurl[2], UserMessage.class);
        String res=(String) method.invoke(clazz,requestApi.getData());
        System.out.println("返回： "+res);
    }

    @OnClose
    public void onClose() {
        UserManager.userCountDecr();
        System.out.println("关闭");
    }

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }
}
