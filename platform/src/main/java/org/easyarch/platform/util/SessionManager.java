package org.easyarch.platform.util;

import javax.websocket.Session;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @ClassName SessionManager
 * @Description TODO
 * @Author Liyihe
 * @Date 2019/09/20 上午8:39
 * @Version 1.0
 */
public class SessionManager {

    public static Map<Session,String> sessions=new ConcurrentHashMap<>();
}
