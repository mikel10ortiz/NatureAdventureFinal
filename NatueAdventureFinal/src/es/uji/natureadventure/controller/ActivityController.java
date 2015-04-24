package es.uji.natureadventure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.natureadventure.dao.interfaces.IActivityDao;
import es.uji.natureadventure.domain.Activity;

@Controller
@RequestMapping("/activity")
public class ActivityController {
	
	private IActivityDao activityDao;
	
	@Autowired
	public void setActivityDao(IActivityDao activityDao){
		this.activityDao = activityDao;
	}
	

	
	@RequestMapping("/list") 
    public String listActivities(Model model) {
        model.addAttribute("activities", activityDao.getActivities());
        return "activity/list";
    }
	
	@RequestMapping(value="/add") 
    public String addActivity(Model model) {
        model.addAttribute("activity", new Activity());
        return "activity/add";
    }
	
	@RequestMapping(value="/update/{id}", method = RequestMethod.GET)
    public String editActivity(Model model, @PathVariable int id) {
        model.addAttribute("activity", activityDao.getActivity(id));
        return "activity/update"; 
    }


}
