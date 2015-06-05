package es.uji.natureadventure.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import es.uji.natureadventure.dao.interfaces.IInstructorDao;
import es.uji.natureadventure.domain.Instructor;

@Controller
@RequestMapping("/authenticate")
public class LoginController {
	
	@Autowired
	IInstructorDao instructorDao;
	
	@RequestMapping("/access")
	public String goToHomeAuthenticated(){
		Instructor instructor;
		String username;
		
		username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		if(SecurityContextHolder.getContext().getAuthentication().isAuthenticated()){
			Collection<? extends GrantedAuthority> auths = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		
			if(auths.contains(new SimpleGrantedAuthority("ROLE_ADMIN")))
				return "redirect:/admin/index.html";
			if(auths.contains(new SimpleGrantedAuthority("ROLE_STAFF"))){
				instructor = instructorDao.getInstructorByUsername(username);
				return "redirect:/staff/index/" + instructor.getIdCard() + ".html";
			}
		}
		return "redirect:/index.jsp";
	}

}
