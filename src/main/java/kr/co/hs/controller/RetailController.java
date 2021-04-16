package kr.co.hs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RetailController {

	
	@GetMapping("/retail/register")
	public String register() {
		
		return "/view/retail/register";
	}
	
}
