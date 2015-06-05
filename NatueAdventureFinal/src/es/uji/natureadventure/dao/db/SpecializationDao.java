package es.uji.natureadventure.dao.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.natureadventure.dao.interfaces.IActivityDao;
import es.uji.natureadventure.dao.interfaces.IInstructorDao;
import es.uji.natureadventure.dao.interfaces.ISpecializationDao;
import es.uji.natureadventure.domain.Activity;
import es.uji.natureadventure.domain.Instructor;

@Repository
public class SpecializationDao implements ISpecializationDao {

	JdbcTemplate jdbcTemplate;
	
	@Autowired
	IActivityDao activityDao;
	
	@Autowired
	IInstructorDao instructorDao;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		
	}

	


	@Override
	public void saveSpecialization(String instructor, int activity) {
		this.jdbcTemplate.update("INSERT INTO Specialization values(?,?)", instructor, activity);
	}


	@Override
	public void updateSpecialization(String instructor, int activity) {
		this.jdbcTemplate.update("UPDATE Specialization SET activity = ? "
				+ "WHERE instructor = ?", activity, instructor);
	}


	@Override
	public List<Activity> getSpecializationsForInstructor(String instructor) {
		return this.jdbcTemplate.query("SELECT activity as idActivity, instructor FROM specialization WHERE instructor = ?",
				new Object[] {instructor}, new SpecializationActivityMapper());
	}


	@Override
	public List<Instructor> getInstructorsForActivity(int activity) {
		return this.jdbcTemplate.query("SELECT * FROM specialization WHERE activity = ?",
				new Object[] {activity}, new SpecializationInstructorMapper());
	}
	
	@Override
	public List<Activity> getActivitiesNotSpecializated(String instructor){
		return this.jdbcTemplate.query("select id as idActivity from activity where id not in( "
										+ "select activity from specialization where instructor = ?)", 
				new Object[] {instructor}, new SpecializationActivityMapper());
	}
	
	
	
	private class SpecializationActivityMapper implements RowMapper<Activity>{

		@Override
		public Activity mapRow(ResultSet rs, int rowNum) throws SQLException {
			Activity activity;
			
			activity = activityDao.getActivity(rs.getInt("idActivity"));
			return activity;
		}
		
	}
	
	private class SpecializationInstructorMapper implements RowMapper<Instructor>{

		@Override
		public Instructor mapRow(ResultSet rs, int rowNum) throws SQLException {
			Instructor instructor;
			instructor = instructorDao.getInstructor(rs.getString("instructor"));
			return instructor;
		}
		
	}

}
