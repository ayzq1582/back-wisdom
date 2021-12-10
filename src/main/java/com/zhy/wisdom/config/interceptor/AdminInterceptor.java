package com.zhy.wisdom.config.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
/**
 * 拦截器，管理员验证
 */
@Component
public class AdminInterceptor implements HandlerInterceptor {

    @Autowired
    private HttpSession session;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        return true;
        // Boolean isAdmin = (Boolean)session.getAttribute("sessionAdmin");
        // if (isAdmin!=null && isAdmin){
        //     return true;
        // }else {
        //     Map<String,Object> notLogin = new HashMap<>();
        //     notLogin.put("msg","no power");
        //     notLogin.put("code",403);
        //     notLogin.put("data",null);
        //     try(PrintWriter printWriter = response.getWriter()){
        //         printWriter.print(objectMapper.writeValueAsString(notLogin));
        //     }catch (Exception e){
        //         e.printStackTrace();
        //     }
        //     return false;
        // }
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }

}
