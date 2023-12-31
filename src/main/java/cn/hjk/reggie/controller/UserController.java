package cn.hjk.reggie.controller;

import cn.hjk.reggie.common.R;
import cn.hjk.reggie.service.UserService;
import cn.hjk.reggie.utils.ValidateCodeUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import cn.hjk.reggie.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName UserController
 * @Description
 * @Author 搁浅咖啡
 * @Time 2023/7/30 15:14
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate redisTemplate;

    //发送手机验证码
    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody User user, HttpSession httpSession){

        String phone = user.getPhone();
        if (StringUtils.isNotEmpty(phone)){
            String code = ValidateCodeUtils.generateValidateCode(4).toString();
            log.info("code={}",code);

//            调用阿里云服务发送短信
//            SMSUtils.sendMessage("瑞吉外卖","",phone,code);

//            httpSession.setAttribute(phone,code);

            //将生成的验证码缓存到Redis中，并且设置有效期为5分钟
            redisTemplate.opsForValue().set(phone,code,5,TimeUnit.MINUTES);

            return R.success("手机验证码发送成功");
        }
        return R.success("手机验证码发送失败");

    }

    //移动端用户登录
    @PostMapping("/login")
    public R<User> login(@RequestBody Map map,HttpSession session){
        String phone =map.get("phone").toString();

        String code = map.get("code").toString();
//        Object codeInSession = session.getAttribute(phone);

        //从Redis中获取缓存的验证码
        Object codeInSession = redisTemplate.opsForValue().get(phone);
        if (codeInSession!=null&&codeInSession.equals(code)){
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getPhone,phone);
            User user = userService.getOne(queryWrapper);
            if(user==null){
                user = new User();
                user.setPhone(phone);
                user.setStatus(1);

                userService.save(user);
            }
//            session.setAttribute("user",user.getId());
            //删除Redis中缓存的验证码
            redisTemplate.delete(phone);
            return R.success(user);
        }
        return R.error("登录失败");
    }


    /**
     * 退出登录
     * Request URL:
     * http://localhost:8080/user/loginout
     * Request Method:
     * POST
     */

    @PostMapping("/loginout")
    public R<String> logout(HttpSession session){
        session.removeAttribute("user");
        return R.success("退出成功");
    }
}
