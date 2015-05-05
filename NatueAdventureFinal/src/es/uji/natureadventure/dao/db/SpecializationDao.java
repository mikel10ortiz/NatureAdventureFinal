package es.uji.natureadventure.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.uji.natureadventure.dao.interfaces.ISpecializationDao;

public class SpecializationDao implements ISpecializationDao {

	private Connection con;
	
	public SpecializationDao(){
		try{
			con = dataSource.getConnection();
		} catch( ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void saveSpecialization(String instructor, int activity) {
		String sql = "INSERT INTO Specializtion (instructor, activity) VALUES(?,?);";
		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, instructor);
			stmt.setInt(2, activity);
			
			stmt.executeUpdate();
		} catch( SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateSpecialization(String instructor, int activity) {
		String sql = "UPDATE Specialization SET activity = ? WHERE instructor = ?;";
		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, activity);
			stmt.setString(2, instructor);
			
			stmt.executeUpdate();
		} catch( SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Activity> getSpecializationsForInstructor(String instructor) {
		List<Activity> l = new ArrayList<Activity>();
		Activity a = null;
		IActivityDao aDao = new ActivityDao();
		ResultSet rs = null;
		String sql = "SELECT * FROM Specialization WHERE instructor = ?;";
		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, instructor);
			
			rs = stmt.executeQuery();
			if(rs != null){
				while(rs.next()){
					a = aDao.getActivity(rs.getInt("activity"));
					l.add(a);
				}
			}
		} catch( SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Instructor> getInstructorsForActivity(int activity) {
		List<Instructor> l = new ArrayList<Instructor>();
		Instructor i = null;
		IInstructorDao iDao = new InstructorDao();
		ResultSet rs = null;
		String sql = "SELECT * FROM Specialization WHERE activity = ?;";
		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, activity);
			
			rs = stmt.executeQuery();
			if(rs != null){
				while(rs.next()){
					i = iDao.getInstructor(rs.getString("idCard"));
					l.add(i);
				}
			}
		} catch( SQLException e) {
			e.printStackTrace();
		}
		return l;
	}

}
