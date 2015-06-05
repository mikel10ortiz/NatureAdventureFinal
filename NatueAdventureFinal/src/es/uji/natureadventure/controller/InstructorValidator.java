package es.uji.natureadventure.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.uji.natureadventure.domain.Instructor;

public class InstructorValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return Instructor.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Instructor instructor = (Instructor) obj;
		
		if(instructor.getName().trim().equals(""))
			errors.rejectValue("name", "Campo oblgatorio", "Debes introducir un nombre para el monitor");
		
	}

}
