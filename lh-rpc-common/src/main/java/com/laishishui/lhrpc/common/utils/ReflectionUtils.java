package com.laishishui.lhrpc.common.utils;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * 反射工具类
 * Create by tachai on 2020-02-11 20:20
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class ReflectionUtils {
    /**
     * 根据class创建对象
     * @param clazz  待创建对象的类
     * @param <T>    对象类型
     * @return   创建好的对象
     */
    public static <T> T newInstance(Class<T> clazz){
        try {
            return clazz.newInstance();
        }catch (Exception e){
            throw new IllegalStateException(e);
        }
    }

    /**
     * 获取某个class的共有方法
     * @param clazz
     * @return   当前类声明的共有方法
     */
    public static Method[] getPublicMethods(Class clazz){
        Method[] methods = clazz.getDeclaredMethods();
        List<Method> pmethods = new ArrayList<>();
        for(Method m:methods){
         if(Modifier.isPublic(m.getModifiers())){
             pmethods.add(m);
         }
        }
        return pmethods.toArray(new Method[0]);
    }


    // 如果是静态方法，则对象写null
    public static Object invoke(Object obj,Method method,Object... args){
        try{
            return method.invoke(obj,args);
        }catch (Exception e){
            throw new IllegalStateException(e);
        }
    }
}
