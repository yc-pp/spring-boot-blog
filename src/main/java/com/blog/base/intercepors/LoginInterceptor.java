package com.blog.base.intercepors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    private Logger logger= LoggerFactory.getLogger(LoginInterceptor.class);
    //此接口在访问接口之前执行，所以在此处验证登录状态
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //由于项目不同，登录验证有所区别，此处简单做session验证
        HttpSession session=request.getSession();
        Long userId=(Long) session.getAttribute("loginId");
        if (userId == null){
            session.setAttribute("errorMsg","登录超时，请重新登录");
            response.sendRedirect(request.getContextPath() + "/admin/login");
            return false;
        }else{
            logger.info("本次登录userId："+userId+"，昵称："+session.getAttribute("loginNickName"));
            session.setAttribute("errorMsg","");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
