package com.stone.hrm.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stone.hrm.common.entity.StatusCode;
import com.stone.hrm.common.util.JwtUtils;
import com.stone.hrm.config.RsaKeyProperties;
import com.stone.hrm.pojo.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;
    private RsaKeyProperties prop;

    public JwtLoginFilter(AuthenticationManager authenticationManager, RsaKeyProperties prop) {
        this.authenticationManager = authenticationManager;
        this.prop = prop;
    }

    /**
     * 接收并解析用户凭证，出現错误时，返回json数据前端
     *
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            //将json格式请求体转成JavaBean对象
            User User = new ObjectMapper().readValue(request.getInputStream(), com.stone.hrm.pojo.User.class);
            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(User.getUsername(), User.getPassword());
            return authenticationManager.authenticate(authRequest);
        } catch (Exception e) {
            try {
                //如果认证失败，提供自定义json格式异常
                response.setContentType("application/json;charset=utf-8");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                //注意此处如果使用response.getWriter()，虽然可以返回数据，但是控制台会报错：getWriter() has already been called for this response
                ServletOutputStream out = response.getOutputStream();
                Map resultMap = new HashMap();
                resultMap.put("flag", "false");
                resultMap.put("status", StatusCode.UNAUTHORIZED);
                resultMap.put("message", "用户名或密码错误！");
                out.write(new ObjectMapper().writeValueAsString(resultMap).getBytes());
                out.flush();
                out.close();
            } catch (Exception outEx) {
                outEx.printStackTrace();
            }
            throw new RuntimeException(e);
        }
    }

    /**
     * 用户登录成功后，生成token，并且返回json数据给前端
     *
     * @param request
     * @param response
     * @param chain
     * @param authResult
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        //得到当前认证的用户对象
        User user = (User) authResult.getPrincipal();
        user.setPassword("");
        //user.setUsername(authResult.getName());
        //user.setRoles((List<Role>) authResult.getAuthorities());
        //json web token构建
        String token = "Bearer " + JwtUtils.generateTokenExpireInMinutes(user, prop.getPrivateKey(), 24 * 60);
        //返回token
        //response.addHeader("Authorization", "Bearer "+token);
        try {
            //登录成功，返回json格式进行提示
            response.setContentType("application/json;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
            ServletOutputStream out = response.getOutputStream();
            Map resultMap = new HashMap();
            resultMap.put("flag", "true");
            resultMap.put("status", StatusCode.OK);
            resultMap.put("message", "认证通过！");
            Map resultDataMap = new HashMap();
            resultDataMap.put("user", user);
            resultDataMap.put("token", token);
            resultMap.put("data", resultDataMap);
            out.write(new ObjectMapper().writeValueAsString(resultMap).getBytes());
            out.flush();
            out.close();
        } catch (Exception outEx) {
            outEx.printStackTrace();
        }
    }

}
