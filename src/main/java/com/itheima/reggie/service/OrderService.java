package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.entity.Orders;

/**
 * @ClassName OrderService
 * @Description
 * @Author 搁浅咖啡
 * @Time 2023/8/1 11:41
 * @Version 1.0
 */
public interface OrderService extends IService<Orders> {
    //用户下单
    public void submit(Orders orders);
}
