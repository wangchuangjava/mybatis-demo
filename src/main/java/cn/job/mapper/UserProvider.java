package cn.job.mapper;

import cn.job.util.WhereMultiOr;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author: 王创
 * @Date: 2019-12-16 9:20
 * @Description: < 自定义构造sql >
 */
public class UserProvider {
    public String zingy(String name) {

        return new SQL() {{

            SELECT("*");

            FROM("c_user");

            if (name != null) {

                String or;

                or = WhereMultiOr.like("name", name);
                if (or != null) {
                    WHERE(or);
                }


            }

        }}.toString();
    }
}
