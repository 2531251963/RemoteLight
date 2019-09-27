package org.easyarch.user.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.easyarch.user.pojo.A;
import org.easyarch.user.pojo.UserClickInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName UserDaoInter
 * @Description TODO
 * @Author Liyihe
 * @Date 2019/09/23 下午2:50
 * @Version 1.0
 */
@Repository
@Mapper
public interface UserDaoInter {

    @Insert("insert into clickinfo values (#{id},#{userid},#{date},#{info})")
    int insertInfo(UserClickInfo clickInfo);

 /*   @Insert("<script>insert into a values " +
            "<foreach collection='list' item='a' separator=','>(#{a.a1},#{a.a2})</foreach></script>")
    void insertlist(@Param("list")List<A> list);*/
    @Select("select * from clickinfo where userid= #{userid}")
    List<UserClickInfo> searchInfo(@Param("userid") String userid);
}
