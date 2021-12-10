package com.zhy.wisdom.config.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * 拦截器，登录检查
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HttpSession session;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String token = request.getHeader("token");

        if (token.equals("6597")){
            return true;
        }else {
            Map<String,Object> notLogin = new HashMap<>();
            notLogin.put("msg","not login");
            notLogin.put("code",403);
            notLogin.put("data",null);
            try(PrintWriter printWriter = response.getWriter()){
                printWriter.print(objectMapper.writeValueAsString(notLogin));
            }catch (Exception e){
                e.printStackTrace();
            }
            return false;
        }
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
