package cn.hjk.reggie.service;

import cn.hjk.reggie.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;

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
