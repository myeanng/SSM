package org.springmvc_demo.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Controller("i18n")
public class I18nController {

	@RequestMapping(value="i18nDemo" )
	public String i18n(HttpServletRequest request , 
			@RequestParam(value="langType", defaultValue="zh") String lang){
		
		Locale locale ;
		if( lang.equals("zh") ){
			locale = new Locale("zh", "CN"); 
		}else{
			locale = new Locale("en", "US"); 
		}
		request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale); 
		
		return "i18n";
	}
}
