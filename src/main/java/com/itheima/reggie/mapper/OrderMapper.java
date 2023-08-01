package com.itheima.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.reggie.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName OrderMapper
 * @Description
 * @Author 搁浅咖啡
 * @Time 2023/8/1 11:39
 * @Version 1.0
 */
@Mapper
public interface OrderMapper extends BaseMapper<Orders> {
}
