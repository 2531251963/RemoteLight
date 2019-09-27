package org.easyarch.user.service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.easyarch.user.dao.UserDaoInter;
import org.easyarch.user.pojo.UserClickInfo;
import org.easyarch.user.pojo.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserSearchInfoService
 * @Description TODO
 * @Author Liyihe
 * @Date 2019/09/24 下午10:48
 * @Version 1.0
 */
@Service
public class UserSearchInfoService {
    @Autowired
    private UserDaoInter userDaoInter;

    public String search(UserMessage userMessage){
        int page=0;
        try{
            page=Integer.parseInt(userMessage.getMessage());
        }catch (Exception e){
            e.printStackTrace();
        }
        PageHelper.startPage(page,5);
        List<UserClickInfo> list=userDaoInter.searchInfo(userMessage.getUserid());
        PageInfo<UserClickInfo> pageInfo=new PageInfo<>(list);
        return JSON.toJSONString(pageInfo.getList(),true);
    }

}
