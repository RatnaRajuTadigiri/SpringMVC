package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.IWishMessageService;

@Controller
public class WishMessagesRenderingController {
	@Autowired
    private  IWishMessageService service;
	@RequestMapping({"/","/welcome"})
	  public String showHome() {
           return "home";		  
	  }
	
	@RequestMapping("/wish")
	public String showWishMessage(Map<String,Object> map) {
		String result=service.generateWishMessage();
		//keep  results in model attributes
		map.put("resultMsg",result);
		//return LVN
		return "show_results";
	}
	
	
	
}
