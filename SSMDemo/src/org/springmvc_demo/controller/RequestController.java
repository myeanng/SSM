package org.springmvc_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RequestController {

	/*
	 *	 @RequestMapping
	 *		value 指定访问名字，还可以增加参数
	 *		method 指定访问的方法类型，不指定这个参数就默认所有的访问方式都可以通过
	 */
	@RequestMapping(value={"index"})
	public ModelAndView index(){
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
}
