package es.uji.natureadventure.dao.interfaces;

import java.util.List;

import es.uji.natureadventure.domain.Instructor;

public interface IInstructorDao {

	public void saveInstructor(Instructor i);
	public void updateInstructor(Instructor i);
	public Instructor getInstructor(String idCard);
	public List<Instructor> getInstructors();
}
