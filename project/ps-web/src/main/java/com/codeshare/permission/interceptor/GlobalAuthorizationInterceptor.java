package com.codeshare.permission.interceptor;


import com.codeshare.permission.common.Constants;
import com.codeshare.permission.common.ResponseConstant;
import com.codeshare.permission.common.authz.JwtHelper;
import com.codeshare.permission.common.exception.BusinessException;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 安全拦截器
 *
 * @author cjbi
 */
@Component
public class GlobalAuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //检查token
        checkToken(request);
        return super.preHandle(request, response, handler);
    }

    private boolean checkToken(HttpServletRequest request) throws Exception {
        String token = request.getHeader(Constants.TOKEN_HEADER);
        if (StringUtils.isEmpty(token)) {
            throw new BusinessException(ResponseConstant.TOKEN_LOST_ERROR, ResponseConstant.TOKEN_LOST_ERROR_MSG);
        }
        Claims claims = JwtHelper.parseJWT(token);
        JwtHelper.setCurrentClaims(claims);
        return true;
    }

}
