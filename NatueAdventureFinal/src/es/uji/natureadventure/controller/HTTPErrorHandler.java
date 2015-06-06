package es.uji.natureadventure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HTTPErrorHandler{

	String path = "/error";
  
	@RequestMapping(value="/400")
	public String error400(){
		System.out.println("Error 400");
		return path+"/400";
	}
	
	@RequestMapping(value="/403")
	public String error403(){
		System.out.println("Error 403");
		return path+"/403";
	}
	
	@RequestMapping(value="/404")
	public String error404(){
		System.out.println("Error 404");
		return path+"/404";
	}
	  
	@RequestMapping(value="/500")
	public String error500(){
		System.out.println("Error 500");
		return path+"/500";
	}
  
  
}
