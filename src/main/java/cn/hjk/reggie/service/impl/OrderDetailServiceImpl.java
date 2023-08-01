package cn.hjk.reggie.service.impl;

import cn.hjk.reggie.entity.OrderDetail;
import cn.hjk.reggie.mapper.OrderDetailMapper;
import cn.hjk.reggie.service.OrderDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @ClassName OrderDetailServiceImpl
 * @Description
 * @Author 搁浅咖啡
 * @Time 2023/8/1 11:43
 * @Version 1.0
 */

@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {
}
