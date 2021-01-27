package com.threegorges.demo.config;

import com.threegorges.demo.domain.CurrentEmployee;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class VIPInterceptor implements HandlerInterceptor {
    /**
     * 目标方法执行前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession httpSession = request.getSession();
        CurrentEmployee currentEmployee = (CurrentEmployee)httpSession.getAttribute("loginEmployee");
        if (currentEmployee.getRole().getRoleName().equals("VIP")){
            return true;
        }
        request.setAttribute("msg","you have no authority");
        request.getRequestDispatcher("/login").forward(request,response);
        return false;
    }
}
