package net.newture.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.newture.domain.User;
import net.newture.framework.util.WebUtil;

/**
 * 登录校验,未登录不允许进入系统
 */
public class LoginValidateFilter implements Filter {
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		User user = WebUtil.getUser(request);
		String requestUri = WebUtil.getRequestURI(request);
		if (user == null && !requestUri.startsWith("/Feedback/login") && !requestUri.equals("/Feedback/pages/util/rand.jsp")
				&& !requestUri.startsWith("/Feedback/resource")) {
			HttpServletResponse response = (HttpServletResponse) res;
			String ctp = request.getSession().getServletContext().getContextPath();
			response.sendRedirect(ctp + "/login");
			return;
		}
		filterChain.doFilter(req, res);
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

	public void destroy() {
	}

}
