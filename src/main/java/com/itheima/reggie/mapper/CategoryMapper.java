package com.itheima.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.reggie.entity.Category;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName CategoryMapper
 * @Description
 * @Author 搁浅咖啡
 * @Time 2023/7/27 16:16
 * @Version 1.0
 */

@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
