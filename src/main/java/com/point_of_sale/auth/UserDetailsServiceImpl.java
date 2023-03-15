package com.point_of_sale.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.point_of_sale.domain.model.Role;
import com.point_of_sale.domain.model.User;
import com.point_of_sale.repository.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService  {
	@Autowired
	private UserRepository userDAO;
	
	private static final org.jboss.logging.Logger LOG= LoggerFactory.logger(UserDetailsService.class);

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
		User user = null;
		try {
			user = userDAO.findByUsernameAndActivated(userName,true);
		} catch (Exception  e) {
			LOG.warnf("Username {} Not Found", userName);
			throw new UsernameNotFoundException("User "+userName+" not found");
		}
		return new org.springframework.security.core.userdetails.User(
				user.getUsername(), user.getPassword(), true, true, 
				true, true, getAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> getAuthorities(
			Collection<Role> roles) {

		return getGrantedAuthorities(getPrivileges(roles));
	}
	
	
	private List<String> getPrivileges(Collection<Role> roles) {
        List<String> privileges = new ArrayList<>();
        for (Role role : roles) {
        	 privileges.add(role.getName());
        }
        
        return privileges;
    }
	
	
	private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }
}
