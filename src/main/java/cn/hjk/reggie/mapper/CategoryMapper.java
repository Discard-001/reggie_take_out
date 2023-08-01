package cn.hjk.reggie.mapper;

import cn.hjk.reggie.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
