package cn.hjk.reggie.service.impl;

import cn.hjk.reggie.entity.ShoppingCart;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.hjk.reggie.mapper.ShoppingCartMapper;
import cn.hjk.reggie.service.ShoppingCartService;
import org.springframework.stereotype.Service;

/**
 * @ClassName ShoppingCartServiceImpl
 * @Description
 * @Author 搁浅咖啡
 * @Time 2023/8/1 10:43
 * @Version 1.0
 */
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {
}
