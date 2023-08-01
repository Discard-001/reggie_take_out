package com.itheima.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.reggie.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName UserMapper
 * @Description
 * @Author 搁浅咖啡
 * @Time 2023/7/30 15:12
 * @Version 1.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
