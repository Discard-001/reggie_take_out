package cn.hjk.reggie.controller;

import cn.hjk.reggie.common.R;
import cn.hjk.reggie.entity.Orders;
import cn.hjk.reggie.service.OrderService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.hjk.reggie.common.BaseContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName OrderController
 * @Description
 * @Author 搁浅咖啡
 * @Time 2023/8/1 11:44
 * @Version 1.0
 */
@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    //用户下单
    @PostMapping("/submit")
    public R<String> submit(@RequestBody Orders orders){
        orderService.submit(orders);

        return R.success("下单成功");
    }

//    Request URL:
//    http://localhost:8080/order/userPage?page=1&pageSize=5
//    Request Method:  GET

    @GetMapping("userPage")
    public R<Page> userPage(int page,int pageSize){
        Page pageInfo = new Page(page,pageSize);
        LambdaQueryWrapper<Orders> queryWrapper = new LambdaQueryWrapper<>();
        Long userId = BaseContext.getCurrentId();
        queryWrapper.eq(Orders::getUserId,userId);
        queryWrapper.orderByDesc(Orders::getOrderTime);

        orderService.page(pageInfo,queryWrapper);
        return R.success(pageInfo);
    }
}
