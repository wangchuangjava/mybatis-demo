package cn.job.mapper;

import cn.job.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author: 封润
 * @Date: 2019-11-28 11:09
 * @Description: < 描述 >
 */
@Repository
public interface UserMapper extends Mapper<User> , IdsMapper<User> {
    @Select("select count(1) from c_user")
    int counts();

    /**
     * xml映射文件的形式
     * @param name
     * @return
     */

    List<User> queryDoubleXml(@Param("name") String name);

    /**
     * 基于注解的形式
     * @return
     */
    @Select("select * from c_user where id=#{id}")
    @Results(id = "userMap",value = {
            //id表示主键
            @Result(id = true,column = "id",property = "id"),
            @Result(property = "groupId",column = "group_id"),
            @Result(property = "name",column = "name"),
            @Result(property = "address",column = "address"),
            @Result(property = "group",column = "group_id",one = @One(select = "cn.job.mapper.GroupMapper.selectByUserId",fetchType = FetchType.EAGER))
    })
    List<User> queryDouble(Integer id);

    @SelectProvider(type = UserProvider.class, method = "zingy")
    List<User> page(String name);
}
