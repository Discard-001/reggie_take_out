package cn.hjk.reggie.service.impl;

import cn.hjk.reggie.common.CustomException;
import cn.hjk.reggie.entity.Dish;
import cn.hjk.reggie.entity.Setmeal;
import cn.hjk.reggie.service.DishService;
import cn.hjk.reggie.service.SetmealService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.hjk.reggie.entity.Category;
import cn.hjk.reggie.mapper.CategoryMapper;
import cn.hjk.reggie.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Resource
    private DishService dishService;
    @Resource
    private SetmealService setmealService;

    //根据id删除分类，删除之前进行判断
    @Override
    public void remove(Long id) {
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.eq(Dish::getCategoryId, id);
        int count1 = dishService.count(dishLambdaQueryWrapper);
        //查询当前分类是否关联了菜品，如果已经关联，抛出一个业务异常
        if (count1 > 0) {
            //已经关联了菜品，抛出一个业务异常
            throw new CustomException("当下分类下关联了菜品，不能删除");

        }
        //查询当前分类是否关联了套餐，如果已经关联，抛出一个业务异常
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId, id);
        int count2 = setmealService.count(setmealLambdaQueryWrapper);
        if (count2 > 0) {
            //已经关联了套餐，抛出一个业务异常
            throw new CustomException("当下分类下关联了套餐，不能删除");

        }
        //正常删除分类
        super.removeById(id);
    }
}
