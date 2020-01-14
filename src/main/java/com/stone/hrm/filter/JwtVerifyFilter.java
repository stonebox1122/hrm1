package com.stone.hrm.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stone.hrm.common.entity.Payload;
import com.stone.hrm.common.entity.StatusCode;
import com.stone.hrm.common.util.JwtUtils;
import com.stone.hrm.config.RsaKeyProperties;
import com.stone.hrm.pojo.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JwtVerifyFilter extends BasicAuthenticationFilter {

    private RsaKeyProperties prop;

    public JwtVerifyFilter(AuthenticationManager authenticationManager, RsaKeyProperties prop) {
        super(authenticationManager);
        this.prop = prop;
    }

//    @Override
//    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
//        try {
//            String header = request.getHeader("Authorization");
//            if (header == null || !header.startsWith("Bearer ")) {
//                chain.doFilter(request, response);
//                //如果携带错误的token，则给用户提示请登录！
//                responseJson(response);
//                return;
//            }
//            UsernamePasswordAuthenticationToken authResult = getAuthentication(request);
//            SecurityContextHolder.getContext().setAuthentication(authResult);
//            chain.doFilter(request, response);
//        } catch (Exception e) {
//            responseJson(response);
//            e.printStackTrace();
//        }
//    }
//
    private void responseJson(HttpServletResponse response) {
        try {
            response.setContentType("application/json;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            ServletOutputStream out = response.getOutputStream();
            Map resultMap = new HashMap();
            resultMap.put("flag", "false");
            resultMap.put("code", StatusCode.FORBIDDEN);
            resultMap.put("message", "请登录！");
            out.write(new ObjectMapper().writeValueAsString(resultMap).getBytes());
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null) {
            //验证tken是否正确
            Payload<User> payload = JwtUtils.getInfoFromToken(token.replace("Bearer ", ""), prop.getPublicKey(), User.class);
            User user = payload.getUserInfo();
            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, user.getRoles());
            }
            return null;
        }
        return null;
    }

    /**
     * 过滤请求
     *
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            try {
                UsernamePasswordAuthenticationToken authResult = getAuthentication(request);
                SecurityContextHolder.getContext().setAuthentication(authResult);
            } catch (AuthenticationException e) {
                responseJson(response);
                e.printStackTrace();
                return;
            }
            chain.doFilter(request, response);
        } else {
            responseJson(response);
            chain.doFilter(request, response);
        }
    }
}
