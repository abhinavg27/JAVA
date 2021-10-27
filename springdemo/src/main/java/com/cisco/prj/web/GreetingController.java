package com.cisco.prj.web;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingController {
	
	@RequestMapping("greeting.do")
	public ModelAndView getGreetMessage() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "Good Morning!!"); // model data
		mav.addObject("time", new Date()); // model data
		mav.setViewName("display.jsp");
		return mav;
	}
}
