package com.itheima.reggie.common;

/**
 * @ClassName CustomException
 * @Description
 * @Author 搁浅咖啡
 * @Time 2023/7/28 10:30
 * @Version 1.0
 */
public class CustomException extends RuntimeException{
    public CustomException(String message){
        super(message);
    }
}
