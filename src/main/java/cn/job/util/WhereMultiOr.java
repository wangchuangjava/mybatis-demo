package cn.job.util;

import com.sun.istack.internal.NotNull;
import org.apache.commons.lang.StringUtils;
import org.springframework.lang.Nullable;
/**
 * @author 王创
 */
public class WhereMultiOr {

    private WhereMultiOr() {
    }

    /**
     * 条件语句中OR多值精确查询并列生成
     *
     * @param field  字段名
     * @param values 多值参数，以空格分开
     * @return 多值OR语句
     */
    public static String equal(@NotNull String field, @Nullable String values) {

        return whereMultiOrBuilder(field, "=", values, null, null);
    }

    /**
     * 条件语句中OR多值文本值精确查询并列生成
     *
     * @param field  字段名
     * @param values 多值参数，以空格分开
     * @return 多值OR语句
     */
    public static String equalText(@NotNull String field, @Nullable String values) {

        return whereMultiOrBuilder(field, "=", values, "'", "'");
    }

    /**
     * 条件语句中OR多值模糊查询并列生成
     *
     * @param field  字段名
     * @param values 多值参数，以空格分开
     * @return 多值OR语句
     */
    public static String like(@NotNull String field, @Nullable String values) {

        return whereMultiOrBuilder(field + "::VARCHAR", " Like ", values, "'%", "%'");
    }

    /**
     * 条件语句中OR多值开头模糊查询并列生成
     *
     * @param field  字段名
     * @param values 多值参数，以空格分开
     * @return 多值OR语句
     */
    public static String likeBegin(@NotNull String field, @Nullable String values) {

        return whereMultiOrBuilder(field + "::VARCHAR", " Like ", values, "'%", "'");
    }

    /**
     * 条件语句中OR多值结尾模糊查询并列生成
     *
     * @param field  字段名
     * @param values 多值参数，以空格分开
     * @return 多值OR语句
     */
    public static String likeEnd(@NotNull String field, @Nullable String values) {

        return whereMultiOrBuilder(field + "::VARCHAR", " Like ", values, "'", "%'");
    }

    /**
     * 条件语句中OR多值并列生成
     * eg. " aa bb   cc " => "field=aa OR field=bb OR field=cc"
     *
     * @param field       字段名
     * @param operator    操作符 =或like
     * @param values      多值参数，以空格分开
     * @param fieldPrefix 字段条件前缀
     * @param filedSuffix 字段条件后缀
     * @return 多值OR语句
     */
    private static String whereMultiOrBuilder(@NotNull String field, @NotNull String operator, @Nullable String values, @Nullable String fieldPrefix, @Nullable String filedSuffix) {

        if (fieldPrefix == null) fieldPrefix = "";
        if (filedSuffix == null) filedSuffix = "";

        String[] arr = StringUtils.split(values);

        if (StringUtils.isBlank(field) || arr == null || arr.length <= 0) return null;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            sb.append(field);
            sb.append(operator);
            sb.append(fieldPrefix);
            sb.append(arr[i]);
            sb.append(filedSuffix);
            if (i + 1 < arr.length) sb.append(" OR ");
        }

        return sb.toString();
    }
}
