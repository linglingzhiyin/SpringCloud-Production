package com.mzj.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class UserFilter extends ZuulFilter {

	@Value("${server.port}")
	private String serverPort;

	@Override
	public boolean shouldFilter() {
		return true;
	}

	// 过滤登录请求
	@Override
	public Object run() throws ZuulException {
		RequestContext currentContext = RequestContext.getCurrentContext();
		HttpServletRequest request = currentContext.getRequest();
		String userToken = request.getParameter("userToken");

		if (StringUtils.isEmpty(userToken)) {
			currentContext.setSendZuulResponse(false);
			currentContext.setResponseBody("userToken is null");
			currentContext.setResponseStatusCode(401);
			System.out.println(serverPort + "abc");
			return null;
		}

		// 1、token 从 redis 中获取
		// 2、判断token，如果token为空，跳转登录页
		System.out.println(serverPort + "abc");
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
