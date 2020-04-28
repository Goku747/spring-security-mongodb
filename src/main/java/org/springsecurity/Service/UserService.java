package org.springsecurity.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springsecurity.Db.UserRepository;
import org.springsecurity.Model.User;

@Service
public class UserService {

	@Autowired
	UserRepository repo;

	public String SaveUser(User user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		repo.save(user);
		return " User with the username " + user.getUsername() + " saved successfully ";
	}

	public List<User> ViewAllUser() {
		List<User> user = repo.findAll();
		return user;
	}

	public String EditUser(User user) {
		
		repo.save(user);
		return "User edited and saved Successfully";
	}

	public String DeleteUser(String username) {
		User user = new User();
		if (username != null) {
			user = repo.findByUsername(username);
		}
		repo.delete(user);
		return "User with the username " + user.getUsername() + " deleted Successfully";
	}
}
