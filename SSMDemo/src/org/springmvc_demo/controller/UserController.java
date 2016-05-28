package org.springmvc_demo.controller;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springmvc_demo.entity.User;
import org.springmvc_demo.service.BaseService;
import org.springmvc_demo.util.Page;

@Controller("userController")
public class UserController {
	
	private BaseService<User> userService;
	
	@Resource(name="userService")
	public void setUserService(BaseService<User> userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="findAll" , method={RequestMethod.POST , RequestMethod.GET})
	public String findAll(Model model , Page page)throws Exception{
		System.out.println(userService.getClass().getName());
		model.addAttribute("userPage", page = userService.findAll( null ,page));
		return "userlist";
	}

	@RequestMapping(value="addUser" , method={RequestMethod.POST})
	public String addUser(User user)throws Exception{
		
		if( userService.add(user))
			return "add_success";
		else
			return "add_fail";
	}
	
	@RequestMapping(value="updateUser" , method=RequestMethod.POST)
	public String updateUser(User user)throws Exception{
	
		return "";
	}
	
	@RequestMapping(value="delUsers" , method={RequestMethod.POST,RequestMethod.GET})
	public String delUser(String[] ids)throws Exception{
		return "";
	}
	
	@RequestMapping(value="delUserById" , method={RequestMethod.POST,RequestMethod.GET})
	public String delUserById(Serializable id)throws Exception{
		return "";
	}
}
