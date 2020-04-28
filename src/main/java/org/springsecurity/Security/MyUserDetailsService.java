package org.springsecurity.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springsecurity.Db.UserRepository;
import org.springsecurity.Model.User;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.findByUsername(username);
		UserPrincipal principal = new UserPrincipal(user);
		if (username == null) {
			throw new UsernameNotFoundException("User not found 404");
		}
		return principal;
	}

}
