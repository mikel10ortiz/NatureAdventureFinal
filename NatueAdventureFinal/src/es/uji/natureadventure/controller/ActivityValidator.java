package es.uji.natureadventure.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.uji.natureadventure.domain.Activity;

public class ActivityValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Activity.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Activity activity = (Activity) obj;
		if(activity.getId() == 0)
			errors.rejectValue("id", "Campo obligatorio",
								"Es necesario añadir un identificador");
		if(activity.getName().trim().equals(""))
			errors.rejectValue("name", "Campo obligatorio",
								"Es obligatorio añadir un nombre a la actividad");
		if(activity.getDescription().trim().equals(""))
			errors.rejectValue("description", "Campo obligatorio",
							"Es obligatorio añadir una descripcion a la actividad");
		if(activity.getKind().trim().equals(""))
			errors.rejectValue("kind", "Campo obligatorio",
							"Es obligatorio especifiar un tipo de actividad");
		if(activity.getDifficulty().trim().equals(""))
			errors.rejectValue("difficulty", "Campo obligatorio",
							"Es obligatorio especifiar un nivel de dificultad a la actividad");
	}

}
