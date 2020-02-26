package cn.job.service;

import cn.job.entity.User;
import cn.job.mapper.UserMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl {

    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public PageInfo<User> page() {
        Page<Object> objects = PageHelper.startPage(2, 2);
        List<User> users = userMapper.selectAll();
        PageInfo<User> objectPageInfo = new PageInfo<>(users);
        return objectPageInfo;
    }
}
