package cn.hjk.reggie.controller;

import cn.hjk.reggie.entity.ShoppingCart;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import cn.hjk.reggie.common.BaseContext;
import cn.hjk.reggie.common.R;
import cn.hjk.reggie.service.ShoppingCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName ShoppingCartController
 * @Description
 * @Author 搁浅咖啡
 * @Time 2023/8/1 10:40
 * @Version 1.0
 */

@RestController
@Slf4j
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
    @Resource
    ShoppingCartService shoppingCartService;

    @PostMapping("/add")
    public R<ShoppingCart> shoppingCart(@RequestBody ShoppingCart shoppingCart) {
        log.info("购物车数据：{}", shoppingCart);
        //设置用户id
        Long currentId = BaseContext.getCurrentId();
        shoppingCart.setUserId(currentId);
        //查询当前菜品或套餐是否在购物车中
        Long dishId = shoppingCart.getDishId();
        LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ShoppingCart::getUserId, currentId);
        if (dishId != null) {
            //是菜品
            queryWrapper.eq(ShoppingCart::getDishId, dishId);

        } else {
            //是套餐
            queryWrapper.eq(ShoppingCart::getSetmealId, shoppingCart.getSetmealId());
        }

        ShoppingCart cartServiceOne = shoppingCartService.getOne(queryWrapper);

        if (cartServiceOne != null) {
            Integer number = cartServiceOne.getNumber();

            cartServiceOne.setNumber(number + 1);
            shoppingCartService.updateById(cartServiceOne);
        } else {
            shoppingCart.setNumber(1);
            shoppingCart.setCreateTime(LocalDateTime.now());
            shoppingCartService.save(shoppingCart);
            cartServiceOne = shoppingCart;
        }

        return R.success(cartServiceOne);
    }

    //查看购物车
    @GetMapping("/list")
    public R<List<ShoppingCart>> list() {
        LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ShoppingCart::getUserId, BaseContext.getCurrentId());
        queryWrapper.orderByAsc(ShoppingCart::getCreateTime);

        List<ShoppingCart> list = shoppingCartService.list(queryWrapper);

        return R.success(list);
    }


    //清空购物车
    @DeleteMapping("/clean")
    public R<String> clean(){
        LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper.eq(ShoppingCart::getUserId, BaseContext.getCurrentId());

        shoppingCartService.remove(queryWrapper);
        return R.success("清空购物车成功");
    }


    /**
     * 减少份数
     * Request URL:
     * http://localhost:8080/shoppingCart/sub
     * Request Method:
     * POST
     */

    @PostMapping("/sub")
    public R<ShoppingCart> sub(@RequestBody ShoppingCart shoppingCart){
        LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper<>();

        if (shoppingCart.getDishId()!=null){
            queryWrapper.eq(ShoppingCart::getDishId,shoppingCart.getDishId());
        }else{
            queryWrapper.eq(ShoppingCart::getSetmealId,shoppingCart.getSetmealId());
        }
        queryWrapper.eq(ShoppingCart::getUserId,BaseContext.getCurrentId());
        ShoppingCart cartServiceOne = shoppingCartService.getOne(queryWrapper);

        Integer number = cartServiceOne.getNumber();

        cartServiceOne.setNumber(number - 1);
        if (cartServiceOne.getNumber()==0)
            shoppingCartService.removeById(cartServiceOne);
        else
            shoppingCartService.updateById(cartServiceOne);

        return R.success(cartServiceOne);

    }


}
