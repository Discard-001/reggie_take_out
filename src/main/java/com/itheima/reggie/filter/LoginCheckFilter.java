package com.itheima.reggie.filter;

import com.alibaba.fastjson.JSON;
import com.itheima.reggie.common.BaseContext;
import com.itheima.reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName LoginCheckFilter
 * @Description
 * @Author 搁浅咖啡
 * @Time 2023/7/25 17:32
 * @Version 1.0
 */

@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {

    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String requestURI = request.getRequestURI();

        String[] urls = new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**",
                "/common/**",
                "/User/sendMsg",
                "User/login"
        };
        //判断是否需要处理
        boolean check = check(urls, requestURI);
        if(check){
            log.info("本次请求：{}不需要处理",request.getRequestURI());

            filterChain.doFilter(request,response);
            return;
        }

        if(request.getSession().getAttribute("employee") != null){
            Long empId = (Long)request.getSession().getAttribute("employee");
            log.info("用户已登录，用户id为：{}",empId);
            BaseContext.setCurrentId(empId);
            filterChain.doFilter(request,response);
            return;
        }

        if(request.getSession().getAttribute("user") != null){
            Long userId = (Long)request.getSession().getAttribute("user");
            log.info("用户已登录，用户id为：{}",userId);
            BaseContext.setCurrentId(userId);
            filterChain.doFilter(request,response);
            return;
        }
        log.info("用户未登录");
        //未登录
//        response.getWriter().write(JSON.toJSONString(R.error("NO")));

        filterChain.doFilter(request,response);
    }

    public boolean check( String[] urls,String requestURI){
        for (String url : urls) {
            boolean match = PATH_MATCHER.match(url, requestURI);
            if (match) {
                return true;
            }
        }

        return false;
    }
}
