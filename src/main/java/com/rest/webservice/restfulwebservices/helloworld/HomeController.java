package com.rest.webservice.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HomeController {
	
	@Autowired
	private MessageSource messageSource;
	
	//Get
	//URI = "/hello"
	//method = hello
	@RequestMapping(method = RequestMethod.GET,path="/hello")
	public String helloworld() {
		return "Hello world";
	}
	
	@GetMapping("hello-bean")
	public helloworldBean helloworldBean() {
		return new helloworldBean("hello world");
	}
	
	@GetMapping("hello-bean-i18n")
	public String helloworldBeani18N(@RequestHeader(name="Accept-Language",required=false) Locale locale) {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}

}
