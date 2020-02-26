package cn.job.mapper;

import cn.job.MybatisApplication;
import cn.job.entity.User;
import cn.job.service.UserServiceImpl;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author: mapper层单元测试
 * @Date: 2019-11-28 11:10
 * @Description: < 描述 >
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisApplication.class)
public class MapperTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private UserServiceImpl userService;

    /**
     * 调用封装好的接口
     */
    @Test
    public void test1() {
        try {
            PageInfo<User> page = userService.page();
            System.out.println("用户表的信息：" + page);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 手写sql语句
     */
    @Test
    public void test2() {
        int counts = userMapper.counts();
        System.out.println("用户表的总条数" + counts);
    }

    /**
     * xml配置文件的形式
     */
    @Test
    public void test3() {
        List<User> users = userMapper.queryDoubleXml("");
        User user = users.get(0);
        String groupName = user.getGroup().getGroupName();
        System.out.println("第一小组的名称：" + groupName);
        System.out.println("xml形式根据姓名动态查询：" + users);
    }

    /**
     * 注解的形式两表查询
     */
    @Test
    public void test4() {
        List<User> users = userMapper.queryDouble(2);
        System.out.println("@select注解的形式查询所有：" + users);

    }

    /**
     * 更新信息
     */
    @Test
    public void test5() {
        User user = new User();
        user.setId(1);
        user.setAddress("xixix");
        int i = userMapper.updateByPrimaryKeySelective(user);
        System.out.println(i);

    }

    /**
     * 添加信息
     */
    @Test
    public void test6() {
        User user = new User();
        user.setId(2);
        user.setAddress("连云港");
        user.setGroupId(101);
        user.setName("严月荣");
        int i = userMapper.insert(user);
        System.out.println(i);

    }

    /**
     * 自定义构造sql语句
     */
    @Test
    public void test7() {
        List<User> a = userMapper.page("a");
        System.out.println(a + "//////");
    }
}
