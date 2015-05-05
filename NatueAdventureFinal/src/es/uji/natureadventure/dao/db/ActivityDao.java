package es.uji.natureadventure.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.natureadventure.dao.interfaces.IActivityDao;
import es.uji.natureadventure.domain.Activity;


@Repository
public class ActivityDao implements IActivityDao{

	private Connection con;
	
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public ActivityDao(){
		super();	
	}
	
	@Override
	public void saveActivity(Activity a) {
		
		this.jdbcTemplate.update("INSERT INTO Activity "
								+ "(id, name, description, duration, kind, difficulty, minPersons, "
								+ "enabled, price, maxPersons)"
								+ "values"
								+ "(?,?,?,?,?,?,?,?,?,?);",
								a.getId(),
								a.getName(),
								a.getDescription(),
								a.getDuration(),
								a.getKind(),
								a.getDifficulty(),
								a.getMinPersons(),
								a.isEnabled(),
								a.getPrice(),
								a.getMaxPersons()
		);	
	}

	@Override
	public void updateActivity(Activity a) {

		this.jdbcTemplate.update("UPDATE Activity SET "
								+ "name = ?, "
								+ "description = ?, "
								+ "duration = ?, "
								+ "kind = ?, "
								+ "difficulty = ?, "
								+ "minPersons = ?, "
								+ "enabled = ?, "
								+ "price = ?, "
								+ "maxPersons = ? "
								+ "WHERE id = ?;",
								a.getName(),
								a.getDescription(),
								a.getDuration(),
								a.getKind(),
								a.getDifficulty(),
								a.getMinPersons(),
								a.isEnabled(),
								a.getPrice(),
								a.getMaxPersons(),
								a.getId()
		);
	}

	@Override
	public Activity getActivity(int id) {
		
		return this.jdbcTemplate.queryForObject("SELECT * FROM Activity WHERE id = ?",
												new Object[] {id}, new ActivityMapper());
	}

	@Override
	public List<Activity> getActivities(){
		return this.jdbcTemplate.query("select * from Activity"
				, new ActivityMapper());
	}
	
	private static final class ActivityMapper implements RowMapper<Activity> {
		
		public  Activity mapRow(ResultSet rs, int rowNum) throws SQLException {
			Activity a = new Activity();
			a.setId(rs.getInt("id"));
			a.setName(rs.getString("name"));
			a.setDescription(rs.getString("description"));
			a.setDuration(rs.getDouble("duration"));
			a.setKind(rs.getString("kind"));
			a.setDifficulty(rs.getString("difficulty"));
			a.setMinPersons(rs.getInt("minPersons"));
			a.setEnabled(rs.getBoolean("enabled"));
			a.setPrice(rs.getDouble("price"));
			a.setMaxPersons(rs.getInt("maxPersons"));
			
			return a;
			
		}
	}

}
