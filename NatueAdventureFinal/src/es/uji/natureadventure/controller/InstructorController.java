package es.uji.natureadventure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.natureadventure.dao.interfaces.IInstructorDao;
import es.uji.natureadventure.domain.Instructor;

@Controller
@RequestMapping("/instructor")
public class InstructorController {

	private IInstructorDao instructorDao;
	
	@Autowired
	public void setInstructorDao(IInstructorDao instructorDao){
		this.instructorDao = instructorDao;
	}
	
	@RequestMapping("/list")
	public String listInstructors(Model model){
		model.addAttribute("instructors", instructorDao.getInstructors());
		return "instructor/list";
	}
	
	@RequestMapping("/add")
	public String addInstructor(Model model){
		model.addAttribute("instructor", new Instructor());
		return "instructor/add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAndSubmit(@ModelAttribute("instructor") Instructor instructor,
									BindingResult bindingResult){
		if(bindingResult.hasErrors())
			return "instrucot/add";
		instructorDao.saveInstructor(instructor);
		return "redirect:list.html";
	}
	
	@RequestMapping(value = "/update/{idCard}", method = RequestMethod.GET)
	public String editInstructor(Model model, @PathVariable String idCard){
		model.addAttribute("instructor", instructorDao.getInstructor(idCard));
		return "instructor/update";
	}
	
	@RequestMapping(value = "/update/{idCard}", method = RequestMethod.POST)
	public String processUpdateSubmit(@PathVariable String idCard,
										@ModelAttribute("instructor") Instructor instructor,
										BindingResult bindingResult){
		if(bindingResult.hasErrors())
			return "instuctor/update";
		instructorDao.updateInstructor(instructor);
		return "redirect:../list.html";
	}
}
