package es.uji.natureadventure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import es.uji.natureadventure.dao.interfaces.IBookingDao;
import es.uji.natureadventure.dao.interfaces.IInstructorDao;
import es.uji.natureadventure.domain.Instructor;

@Controller
@RequestMapping("/staff")
public class StaffController {

	@Autowired
	IBookingDao bookingDao;
	
	@Autowired
	IInstructorDao instructorDao;
	
	@RequestMapping("/index/{idCard}")
	public String homeStaff(@PathVariable String idCard, Model model){
		Instructor instructor;
		instructor = instructorDao.getInstructor(idCard);
		if(SecurityContextHolder.getContext().getAuthentication().getName().equals(instructor.getUsername())){
			model.addAttribute("bookings", bookingDao.getBookingsByInstructor(idCard));
			return "staff/index";
		}else
			return "redirect:../../login/login.html";
	}
}
