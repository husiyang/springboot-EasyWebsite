package com.threegorges.demo.config;

import com.threegorges.demo.domain.CurrentEmployee;
import com.threegorges.demo.domain.Menu;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
public class AdminInterceptor implements HandlerInterceptor {
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
        boolean v = false;
        String url = request.getRequestURI();
        HttpSession httpSession = request.getSession();
        CurrentEmployee currentEmployee = (CurrentEmployee)httpSession.getAttribute("loginEmployee");
        if (currentEmployee.getRole().getRoleName().equals("admin")){
            for (Menu m:currentEmployee.getMenus()){
                if (url.equals(m.getUrl())){
                    v = true;
                }
            }
        } else if (currentEmployee.getRole().getRoleName().equals("VIP")){
            for (Menu m:currentEmployee.getMenus()){
                if (url.equals(m.getUrl())){
                    v = true;
                }
            }
        } else if (currentEmployee.getRole().getRoleName().equals("normal")){
            for (Menu m:currentEmployee.getMenus()){
                if (url.equals(m.getUrl())){
                    v = true;
                }
            }
        } else {
            request.setAttribute("msg", "you have no authority");
            request.getRequestDispatcher("/login").forward(request, response);
            v = false;
        }
        return v;
    }
}
