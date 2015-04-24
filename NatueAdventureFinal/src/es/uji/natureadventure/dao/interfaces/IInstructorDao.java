package es.uji.natureadventure.dao.interfaces;

import java.util.List;

import es.uji.natureadventure.domain.Instructor;

public interface IInstructorDao {

	public boolean saveInstructor(Instructor i);
	public Instructor updateInstructor(Instructor i);
	public Instructor getInstructor(String idCard);
	public List<Instructor> getInstructors();
}
