package es.uji.natureadventure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneralController {

	@RequestMapping("/login/login.html")
	public String login(){
		return "login/login";
	}
}
