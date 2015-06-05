package es.uji.natureadventure.dao.interfaces;

import java.util.List;

import es.uji.natureadventure.domain.Activity;
import es.uji.natureadventure.domain.Instructor;

public interface ISpecializationDao {

	public void saveSpecialization(String instructor, int activity);
	public void updateSpecialization(String instructor, int activity);
	public List<Activity> getSpecializationsForInstructor(String instructor);
	public List<Instructor> getInstructorsForActivity(int activity);
	public List<Activity> getActivitiesNotSpecializated(String instructor);
	
}
