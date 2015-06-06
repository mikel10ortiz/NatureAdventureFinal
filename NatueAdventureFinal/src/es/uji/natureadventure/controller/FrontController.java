package es.uji.natureadventure.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.natureadventure.dao.interfaces.IActivityDao;
import es.uji.natureadventure.dao.interfaces.IBookingDao;
import es.uji.natureadventure.domain.Activity;
import es.uji.natureadventure.domain.Booking;

@Controller
@RequestMapping("/public")
public class FrontController {

	@Autowired
	IActivityDao activityDao;
	
	@Autowired
	IBookingDao bookingDao;
	
	@InitBinder
	protected void initBinderDateOfBirth(WebDataBinder binder){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, "activityDate", new CustomDateEditor(dateFormat, false));
		binder.registerCustomEditor(Date.class, "bookingDate", new CustomDateEditor(dateFormat, false));
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
		binder.registerCustomEditor(Date.class, "hour", new CustomDateEditor(timeFormat, false));
	
	}
	
	@RequestMapping("/{kind}")
	public String pubicHome(Model model, @PathVariable String kind){
		model.addAttribute("activities", activityDao.getActivitiesByKind(kind));
		return "public/activitylist";
	}
	
	@RequestMapping("/activity/{activityId}.html")
	public String activityDetail(@PathVariable int activityId, Model model){
		model.addAttribute("activity", activityDao.getActivity(activityId));
		return "public/activity";
	}
	
	@RequestMapping(value = "/booking/{activityId}", method = RequestMethod.GET)
	public String bookingActivity(@PathVariable int activityId, Model model){
		model.addAttribute("activity", activityDao.getActivity(activityId));
		model.addAttribute("booking", new Booking());
		return "public/bookingactivity";
	}
	
	@RequestMapping(value = "/booking/{activityId}", method = RequestMethod.POST)
	public String saveBookingActivity(@PathVariable int activityId, Model model,
			@ModelAttribute("activity") Activity activity,
			@ModelAttribute("booking") Booking booking, BindingResult bindingResult){
		
		int bookingSavedId;
		if(bindingResult.hasErrors()){
			return "public/bookingactivity";
		}
		bookingSavedId = bookingDao.saveBooking(booking);
		return "redirect:" + activityId + "/" + bookingSavedId + "/bookingconfirm.html";
	}
	
	@RequestMapping("/booking/{activityId}/{bookingId}/bookingconfirm")
	public String bookingConfirm(@PathVariable int activityId, @PathVariable int bookingId,
			Model model){
		
		Activity activity = activityDao.getActivity(activityId);
		Booking booking = bookingDao.getBooking(bookingId);
		
		model.addAttribute("activity", activity);
		model.addAttribute("booking", booking);
		return "public/bookingconfirm";
	}
}
