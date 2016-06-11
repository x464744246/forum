package cn.test.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by chen on 16/5/18.
 */
public class BaseDaoUtil {

    public static Class getClassGenricType(final Class clazz) {
        Type genType = clazz.getGenericSuperclass();
        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }
        Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
        return (Class) params[0];
    }
}
