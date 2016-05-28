package org.springmvc_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springmvc_demo.entity.User;

@Controller
@RequestMapping(value="ajax")
public class JackSonController {

	/*
	 * @ResponseBody这个注解绝对不能漏掉，需要jackson的jar包支持
	 */
	
	@RequestMapping(value={"/getUserJson"})
	@ResponseBody
	public User getUserJson(){
		return new User("包拯 ","laobao@kaifengfu.com" , "qq123");
	}
}
