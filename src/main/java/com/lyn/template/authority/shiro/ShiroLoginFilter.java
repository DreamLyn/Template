package com.lyn.template.authority.shiro;

import java.util.HashMap;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.servlet.AdviceFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lyn.template.authority.entity.User;


public class ShiroLoginFilter extends AdviceFilter {

	/**
	 * 在访问controller前判断是否登录，返回json，不进行重定向。
	 * 
	 * @param request
	 * @param response
	 * @return true-继续往下执行，false-该filter过滤器已经处理，不继续执行其他过滤器
	 * @throws Exception
	 */
	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		User sysUser = (User) httpServletRequest.getSession().getAttribute("user");
		if (null == sysUser && !httpServletRequest.getRequestURI().contains("/login")) {
			String requestedWith = httpServletRequest.getHeader("X-Requested-With");
			if ((requestedWith!= null) && ("XMLHttpRequest".equals(requestedWith))) {
				HashMap<String, Object> hashMap = new HashMap<String, Object>();
				hashMap.put("status", "success");
				hashMap.put("content", "error");
				httpServletResponse.setCharacterEncoding("UTF-8");
				httpServletResponse.setContentType("application/json");
				ObjectMapper objectMapper = new ObjectMapper();
				httpServletResponse.getWriter().write(objectMapper.writeValueAsString(hashMap));
				return false;
			} else {// 不是ajax进行重定向处理
				httpServletResponse.sendRedirect("/login/local");
				return false;
			}
		}
		return true;
	}

}