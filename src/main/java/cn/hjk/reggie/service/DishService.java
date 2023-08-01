package cn.hjk.reggie.service;

import cn.hjk.reggie.dto.DishDto;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.hjk.reggie.entity.Dish;

/**
 * @ClassName DishService
 * @Description
 * @Author 搁浅咖啡
 * @Time 2023/7/28 10:09
 * @Version 1.0
 */
public interface DishService extends IService<Dish> {
    //新增菜品，同时插入菜品对应的口味数据，需要操作两张表
    public void saveWithFlavor(DishDto dishDto);

    //根据id查询菜品以及口味
    public DishDto getByIdWithFlavor(Long id);

    public void updateWithFlavor(DishDto dishDto);
}
