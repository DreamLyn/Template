package com.lyn.template.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {
	/**
	 * 
	 * @return
	 */
	@GetMapping("index.html")
	public String index() {
		return "index";
	}
	
	
	
	@GetMapping("websocket.html")
	public String websocket() {
		return "it/websocket";
	}
	
	
	@GetMapping("calc.html")
	public String calc() {
		return "calc";
	}
	
	
}
