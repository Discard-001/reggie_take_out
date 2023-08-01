package com.itheima.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.reggie.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName OrderDetailMapper
 * @Description
 * @Author 搁浅咖啡
 * @Time 2023/8/1 11:40
 * @Version 1.0
 */
@Mapper
public interface OrderDetailMapper extends BaseMapper<OrderDetail> {
}
