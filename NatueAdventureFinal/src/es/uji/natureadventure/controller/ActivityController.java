package es.uji.natureadventure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.uji.natureadventure.activity.IActivity;

@Controller
public class ActivityController {
	
	private IActivity activity;
	
	@Autowired
	public void setActivity(IActivity activity){
		this.activity = activity;
	}
	
	@RequestMapping("/prueba_getName")
    public String provaID(Model model) {
             model.addAttribute("message", 
                                "El nombre de la actividad " + activity.getName());
          return "activity";
    }

	
	@RequestMapping("/activity")
	public String pruebaActivity(Model model){
		String message = "Probando la actividad";
		model.addAttribute("message", message);
		
		return "activity";
	}

}
