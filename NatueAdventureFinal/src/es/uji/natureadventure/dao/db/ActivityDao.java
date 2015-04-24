package es.uji.natureadventure.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.uji.natureadventure.dao.interfaces.IActivityDao;
import es.uji.natureadventure.domain.Activity;


@Repository
public class ActivityDao implements IActivityDao{

	private Connection con;
	
	DataSource dataSource;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
	}

	public ActivityDao(){
		super();
		try{
			con = dataSource.getConnection();
			System.out.println("connection");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public boolean saveActivity(Activity a) {
		
		int ok = 0;
		String sql = "INSERT INTO Activity "
				+ "(id, name, description, duration, kind, difficulty, minPersons, enabled, price, maxPersons)"
				+ "values"
				+ "("
				+ "?,?,?,?,?,?,?,?,?,?"
				+ ");";
		
		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, a.getId());
			stmt.setString(2, a.getName());
			stmt.setString(3,a.getDescription());
			stmt.setDouble(4, a.getDuration());
			stmt.setString(5, a.getKind());
			stmt.setString(6, a.getDifficulty());
			stmt.setInt(7, a.getMinPersons());
			stmt.setBoolean(8, a.isEnabled());
			stmt.setDouble(9, a.getPrice());
			stmt.setInt(10, a.getMaxPersons());
			
			ok = stmt.executeUpdate();
		} catch( SQLException e) {
			e.printStackTrace();
		}
		return (ok >= 1) ? true : false;
	}

	@Override
	public Activity updateActivity(Activity a) {

		String sql = "UPDATE Activity SET"
				+ "name = ?,"
				+ "description = ?,"
				+ "duration = ?,"
				+ "kind = ?"
				+ "difficulty = ?,"
				+ "minPersons = ?,"
				+ "enabled = ?,"
				+ "price = ?,"
				+ "maxPersons = ?"
				+ "WHERE id = ?;";
		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, a.getName());
			stmt.setString(2,a.getDescription());
			stmt.setDouble(3, a.getDuration());
			stmt.setString(4, a.getKind());
			stmt.setString(5, a.getDifficulty());
			stmt.setInt(6, a.getMinPersons());
			stmt.setBoolean(7, a.isEnabled());
			stmt.setDouble(8, a.getPrice());
			stmt.setInt(9, a.getMaxPersons());
			stmt.setInt(10, a.getId());
			
			stmt.executeUpdate();
		} catch( SQLException e){
			e.printStackTrace();
		}
		
		return a;
	}

	@Override
	public Activity getActivity(int id) {
		Activity a = new Activity();
		ResultSet rs = null;
		String sql = "SELECT * FROM Activity WHERE id = ?";
		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if(rs != null){
				rs.next();
				a.setName(rs.getString("name"));
				a.setDescription(rs.getString("description"));
				a.setDuration(rs.getDouble("duration"));
				a.setKind(rs.getString("kind"));
				a.setDifficulty(rs.getString("difficulty"));
				a.setMinPersons(rs.getInt("minPersons"));
				a.setEnabled(rs.getBoolean("enabled"));
				a.setPrice(rs.getDouble("price"));
				a.setMaxPersons(rs.getInt("maxPersons"));
			}
		} catch( SQLException e){
			e.printStackTrace();
		}
		
		return a;
	}

	@Override
	public List<Activity> getActivities() {
		Activity a = null;
		List<Activity> l = new ArrayList<Activity>();
		ResultSet rs = null;
		String sql = "SELECT * FROM Activity";
		PreparedStatement stmt;
		try{
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			if(rs != null){
				while(rs.next()){
					a = new Activity();
					a.setName(rs.getString("name"));
					a.setDescription(rs.getString("description"));
					a.setDuration(rs.getDouble("duration"));
					a.setKind(rs.getString("kind"));
					a.setDifficulty(rs.getString("difficulty"));
					a.setMinPersons(rs.getInt("minPersons"));
					a.setEnabled(rs.getBoolean("enabled"));
					a.setPrice(rs.getDouble("price"));
					a.setMaxPersons(rs.getInt("maxPersons"));
					
					l.add(a);
				}
			}
		} catch( SQLException e){
			e.printStackTrace();
		}

		return l;
	}

}
