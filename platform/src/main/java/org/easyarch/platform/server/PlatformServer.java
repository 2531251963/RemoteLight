package org.easyarch.platform.server;

import com.alibaba.fastjson.JSON;
import org.easyarch.platform.pojo.RequestApi;
import org.easyarch.platform.service.InitListService;
import org.easyarch.platform.util.BeanUtil;
import org.easyarch.platform.util.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @ClassName WebSocketServer
 * @Description TODO
 * @Author Liyihe
 * @Date 2019/09/20 上午8:33
 * @Version 1.0
 */
//@ServerEndpoint("/platform/{userid}")
@ServerEndpoint("/platform/main")
@Component
public class PlatformServer {

    @Autowired
    InitListService service;
    @OnOpen
    public void onOpen(Session session) {
        try {
            SessionManager.sessions.put(session,null);
            session.getBasicRemote().sendText(service.initData());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnMessage
    public void onMessage(Session session,String data) throws Exception {
        RequestApi requestApi= JSON.parseObject(data,RequestApi.class);
        System.out.println(requestApi);
        String resurl[]=requestApi.getUrl().split("/");
        Object clazz= BeanUtil.getBean(resurl[1]);
        Method method=clazz.getClass().getMethod(resurl[2]);
        String res=(String) method.invoke(clazz);
        System.out.println("返回： "+res);
        session.getBasicRemote().sendText(res);
    }

    @OnClose
    public void onClose() {
        System.out.println("连接关闭");
    }

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }
}
