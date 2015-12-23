package com.shuratech.gis.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SpringController {

	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String hello(){
		return "hello";
	}
	
}
