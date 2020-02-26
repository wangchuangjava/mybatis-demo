package cn.job.mapper;

import cn.job.entity.Group;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author: 封润
 * @Date: 2019-11-28 14:30
 * @Description: < 描述 >
 */
@Repository
public interface GroupMapper extends Mapper<Group> {
    @Select(value = "select * from c_user_group where id=#{id}")
    Group selectByUserId(@Param("id") Integer id);
}
