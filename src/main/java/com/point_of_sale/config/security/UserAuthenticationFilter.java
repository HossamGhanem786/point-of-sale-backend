package com.point_of_sale.config.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.point_of_sale.domain.model.User;
import com.point_of_sale.repository.UserRepository;

public class UserAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	@Autowired
	UserRepository userDao;

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		return this.getAuthenticationManager().authenticate(
				new UsernamePasswordAuthenticationToken(obtainUsername(request), obtainPassword(request)));
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		chain.doFilter(request, response);
		User user = userDao.findByUsername(authResult.getName());
		user.setLastLoginDate(new Date());
		userDao.save(user);

	}
}
