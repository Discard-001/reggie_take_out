package cn.hjk.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.hjk.reggie.entity.User;
import cn.hjk.reggie.mapper.UserMapper;
import cn.hjk.reggie.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description
 * @Author 搁浅咖啡
 * @Time 2023/7/30 15:13
 * @Version 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
