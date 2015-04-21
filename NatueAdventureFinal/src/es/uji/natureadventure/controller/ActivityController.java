package es.uji.natureadventure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ActivityController {
	
	@RequestMapping("/activity")
	public String pruebaActivity(Model model){
		String message = "Probando la actividad";
		model.addAttribute("message", message);
		
		return "activity";
	}

}
