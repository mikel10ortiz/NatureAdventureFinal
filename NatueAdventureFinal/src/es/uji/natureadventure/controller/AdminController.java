package es.uji.natureadventure.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;
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
import es.uji.natureadventure.dao.interfaces.IInstructorDao;
import es.uji.natureadventure.dao.interfaces.ISpecializationDao;
import es.uji.natureadventure.dao.interfaces.IUserDetailDao;
import es.uji.natureadventure.domain.Activity;
import es.uji.natureadventure.domain.Instructor;
import es.uji.natureadventure.enums.Difficulties;
import es.uji.natureadventure.security.UserApp;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	IActivityDao activityDao;
	
	@Autowired
	IInstructorDao instructorDao;
	
	@Autowired
	IBookingDao bookingDao;
	
	@Autowired
	ISpecializationDao specializationDao;
	
	@Autowired
	UserDetailsService MiUserServiceJDBC;
	
	@Autowired
	ShaPasswordEncoder passwordEncoder;
	
	@Autowired
	IUserDetailDao userDetailDao;
	
	@InitBinder
	protected void initBinderDateOfBirth(WebDataBinder binder){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, "dateOfBirth", new CustomDateEditor(dateFormat, false));
		binder.registerCustomEditor(Date.class, "entryDate", new CustomDateEditor(dateFormat, false));
		binder.registerCustomEditor(Date.class, "activityDate", new CustomDateEditor(dateFormat, false));
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
		binder.registerCustomEditor(Date.class, "inittialHour", new CustomDateEditor(timeFormat, false));
		binder.registerCustomEditor(Date.class, "finalHour", new CustomDateEditor(timeFormat, false));
	
	}
	
	@RequestMapping("/index")
	public String homeAdmin(Model model){
		//añadir reservas pendientes de validar
		
		//añadir reservas para el dia actual
		model.addAttribute("category", "summary");
		return "admin/index";
	}
	
	@RequestMapping("/activity")
	public String listAdminActivities(Model model){
		model.addAttribute("activities", activityDao.getActivities());
		model.addAttribute("category", "activity");
		return "admin/activitylist";
	}
		
	@RequestMapping("/activity/{id}")
	public String seeActivity(Model model, @PathVariable int id){
		//mostrar detalle de la actividad
		
		return "admin/activitydetail";
	}
	
	
	@RequestMapping(value="/activity/add") 
    public String addActivity(Model model) {
        model.addAttribute("activity", new Activity());
        model.addAttribute("category", "activity");
        model.addAttribute("difficulties", Difficulties.values());
        return "admin/activityadd";
    }
	
	@RequestMapping(value="/activity/add", method = RequestMethod.POST)
	public String processAndSubmit(@ModelAttribute("activity") Activity activity,
									BindingResult bindingResult, Model model){
		
		model.addAttribute("category", "activity");
		ActivityValidator activityValidator = new ActivityValidator();
		activityValidator.validate(activity, bindingResult);
		if(bindingResult.hasErrors())
			return "admin/activityadd";
		activityDao.saveActivity(activity);
		return "redirect:../activity.html";
	}
	
	@RequestMapping(value="/activity/update/{id}", method = RequestMethod.GET)
    public String editActivity(Model model, @PathVariable int id) {
        model.addAttribute("activity", activityDao.getActivity(id));
        model.addAttribute("category", "activity");
        model.addAttribute("difficulties", Difficulties.values());
        return "admin/activityupdate"; 
    }
	
	@RequestMapping(value="/activity/update/{id}", method = RequestMethod.POST)
	public String processUpdsateSubmit(@PathVariable int id,
										@ModelAttribute("activity") Activity activity,
										BindingResult bindingResult, Model model){
		model.addAttribute("category", "activity");
		if(bindingResult.hasErrors())
			return "admin/activityupdate";
		activityDao.updateActivity(activity);
		return "redirect:../../activity.html";
	}
	
	
	@RequestMapping("/instructor")
	public String listAdminInstructors(Model model){
		model.addAttribute("instructors", instructorDao.getInstructors());
		model.addAttribute("category", "instructor");
		return "admin/instructorlist";
	}
	
	@RequestMapping("/instructor/{idCard}")
	public String seeInstructor(Model model, @PathVariable String idCard){
		//mostrar detalle del instructor
		
		return "admin/instructordetail";
	}
	
	@RequestMapping("/instructor/add")
	public String addInstructor(Model model, HttpSession session){
		model.addAttribute("category", "instructor");
		model.addAttribute("instructor",new Instructor());
		return "admin/instructoradd";
	}
	
	
	// FALTA PONER EL CONTROL DE SESION
	@RequestMapping(value = "/instructor/add", method = RequestMethod.POST)
	public String processAndSubmit(@ModelAttribute("instructor") Instructor instructor,
									BindingResult bindingResult, Model model){
		
		InstructorValidator instructorValidator = new InstructorValidator();
		instructorValidator.validate(instructor, bindingResult);
		if(bindingResult.hasErrors()){
			model.addAttribute("category", "instructor");
			return "admin/instructoradd";
		}
		instructorDao.saveInstructor(instructor);
		return "redirect:../instructor.html";
	}
	
	@RequestMapping(value = "/instructor/update/{idCard}", method = RequestMethod.GET)
	public String editInstructor(Model model, @PathVariable String idCard){
		model.addAttribute("category", "instructor");
		Instructor instructor = instructorDao.getInstructor(idCard);
		String username =  instructor.getUsername();
		
		model.addAttribute("instructor", instructor);		
		model.addAttribute("specializations", 
				specializationDao.getSpecializationsForInstructor(instructor.getIdCard()));
		model.addAttribute("activitiesForSpecialization", 
				specializationDao.getActivitiesNotSpecializated(instructor.getIdCard()));
		model.addAttribute("userApp", new UserApp());
		
		return "admin/instructorupdate";
	}
	
	@RequestMapping(value = "/instructor/update/{idCard}", method = RequestMethod.POST)
	public String processUpdateSubmit(@PathVariable String idCard,
										@ModelAttribute("instructor") Instructor instructor,
										BindingResult bindingResult, Model model){
		
		if(bindingResult.hasErrors()){
			model.addAttribute("instructor", instructor);
			model.addAttribute("category", "instructor");
			model.addAttribute("specializations", 
					specializationDao.getSpecializationsForInstructor(instructor.getIdCard()));
			model.addAttribute("activitiesForSpecialization", 
					specializationDao.getActivitiesNotSpecializated(instructor.getIdCard()));
			model.addAttribute("userApp", new UserApp());
			return "admin/instructorupdate";
		}
		
		instructorDao.updateInstructor(instructor);		
		return "redirect:../update/" + idCard + ".html";		
	}
	
	@RequestMapping("/instructor/addspecialization/{idCard}/{idActivity}")
	public String addSpecializationToInstructor(@PathVariable String idCard, 
												Model model, @PathVariable int idActivity){
		model.addAttribute("category", "instructor");
		specializationDao.saveSpecialization(idCard, idActivity);
		return "redirect:../../update/" + idCard + ".html";
	}
	
	@RequestMapping(value = "/instructor/updatepassword/{idCard}", method = RequestMethod.POST)
	public String updatePassword(@ModelAttribute("userApp") UserApp user, @PathVariable String idCard,
								Model model){
		
		model.addAttribute("category", "instructor");
		String passwordCifrado = this.passwordEncoder.encodePassword(user.getPassword(),"");
		user.setPassword(passwordCifrado);
		
		if(userDetailDao.getUserByUsername(user.getUsername()) == null){
			userDetailDao.saveUser(user);
			userDetailDao.addRoleByUsername(user.getUsername(), "ROLE_STAFF");
		}
		else
			userDetailDao.updateUser(user);
			
		return "redirect:../update/" + idCard + ".html";
	}
	
	@RequestMapping("/booking")
	public String listBooking(Model model){

		model.addAttribute("category", "booking");
		model.addAttribute("bookings", bookingDao.getBookingsActivityName());
		return "/admin/bookinglist";
	}
	
	
	@RequestMapping("/booking/{id}")
	public String seeBooking(Model model, @PathVariable int id){
		//mostrar detale de reserva
		
		return "/admin/bookingdetail";
	}
	
}
