package org.springsecurity.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springsecurity.Model.User;
import org.springsecurity.Service.UserService;

@RestController
@RequestMapping("profile")
public class UserController {
	@Autowired
	UserService service;
	
	@PostMapping("/saveuser")
	public String saveUser(@RequestBody User user) {
		return service.SaveUser(user);
	}

	@GetMapping("/all")
	public List<User> ViewAllUser() {
		return service.ViewAllUser();
	}

	@PutMapping("/edituser")
	public String EditUser(@RequestBody User user) {
		return service.EditUser(user);
	}

	@DeleteMapping("/deleteuser")
	public String DeleteUser(@RequestParam String username) {
		return service.DeleteUser(username);
	}

}
