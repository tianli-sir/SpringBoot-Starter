package com.tianlisir.interceptor;

import com.tianlisir.exception.BizException;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @className: TokenInterceptor
 * @description: token拦截器
 * @author: Another
 * @date: 2022-01-13 09:41
 */
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 核心业务逻辑，判断是否登录等
        String token = request.getHeader("token");
        // 正常token是的登录后签发的，前端携带过来
        if(!StringUtils.hasLength(token)){
            throw new BizException(9001, "token不能为空");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        //
        System.out.println("controller 执行完了");
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("我获取到了一个返回的结果："+response);
        System.out.println("请求结束了");
    }
}
