package com.bluebird.DreamEducation.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class UnauthorizedResponseStructure extends BasicAuthenticationEntryPoint {


    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.addHeader("WWW-Authenticate", "Basic realm=\"\" + getRealmName() + \"\"");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        PrintWriter write = response.getWriter();
        write.write("Http Status 401-unauthorized --> "+authException.getMessage());


    }

    @Override
    public void afterPropertiesSet(){
        setRealmName("TEST-REAM-NAME");
        super.afterPropertiesSet();
    }
}
