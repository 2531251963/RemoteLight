package org.easyarch.user.dao;

import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.easyarch.user.pojo.A;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserSql
 * @Description TODO
 * @Author Liyihe
 * @Date 2019/09/23 下午3:55
 * @Version 1.0
 */
public class UserSql {
    public String insertPi(List<A> aList){
        return new SQL(){
            {
                INSERT_INTO("a");
                VALUES("a1","1").VALUES("a2","2");
            }
        }.toString();
    }

    public static void main(String[] args) {
     Long l =System.currentTimeMillis();
        System.out.println(l.toString().length());
    }
}
