package jp.co.internous.ecsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.ecsite.model.dao.UserRepository;
import jp.co.internous.ecsite.model.entity.User;
import jp.co.internous.ecsite.model.form.UserForm;


@Controller 
@RequestMapping("/ecsite/admin/user")
public class UserController {
	@Autowired 
	private UserRepository userRepos;
	
	@RequestMapping("/") 
	public String userIndex() {
		return "register_user";
	}
	
	@PostMapping("/registerUser")
	public String registerUserApi(UserForm f) {
		User user = new User();
		user.setUserName(f.getUserName());
		user.setPassword(f.getPassword());
		user.setFullName(f.getFullName());
		userRepos.saveAndFlush(user);
		
		return "adminindex";
	}
}