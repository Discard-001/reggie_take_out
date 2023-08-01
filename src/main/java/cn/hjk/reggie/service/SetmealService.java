package cn.hjk.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.hjk.reggie.dto.SetmealDto;
import cn.hjk.reggie.entity.Setmeal;

import java.util.List;

/**
 * @ClassName SetmealService
 * @Description
 * @Author 搁浅咖啡
 * @Time 2023/7/28 10:11
 * @Version 1.0
 */
public interface SetmealService extends IService<Setmeal> {

    //新增套餐，同时保存套餐和菜品的关联关系
    public void saveWithDish(SetmealDto setmealDto);

    //删除套餐，同时删除套餐和菜品的关联关系
    public void removeWithDish(List<Long> ids);
}
