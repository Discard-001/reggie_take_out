package cn.hjk.reggie.common;

/**
 * @ClassName BaseContext
 * @Description
 * @Author 搁浅咖啡
 * @Time 2023/7/27 10:28
 * @Version 1.0
 */

/**
 * 基于ThreadLocal封装的工具类，用户保存和获取当前登录用户的id
 */
public class BaseContext {
    public static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void setCurrentId(Long id){
        threadLocal.set(id);

    }

    public static Long getCurrentId(){
        return threadLocal.get();
    }
}
