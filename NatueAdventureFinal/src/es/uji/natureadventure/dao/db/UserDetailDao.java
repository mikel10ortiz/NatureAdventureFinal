package es.uji.natureadventure.dao.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.natureadventure.dao.interfaces.IUserDetailDao;
import es.uji.natureadventure.security.UserApp;

@Repository
public class UserDetailDao implements IUserDetailDao{
	
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void saveUser(UserApp user){
		this.jdbcTemplate.update("INSERT INTO Usuarios values(?,?)", 
				user.getUsername(), user.getPassword());
	}
	
	public void updateUser(UserApp user){
		this.jdbcTemplate.update("UPDATE Usuarios SET password = ? WHERE login = ?", 
				user.getPassword(),	user.getUsername());
	}

	@Override
	public UserApp getUserByUsername(String username) {
		UserApp user;
		try{
			user = this.jdbcTemplate.queryForObject("SELECT * FROM Usuarios WHERE "
				+ "login = ?", new Object[] {username}, new UserMapper());
		} catch(IncorrectResultSizeDataAccessException ex){
			return null;
		}
		
		return user;
	}
	
	@Override
	public void addRoleByUsername(String username, String role){
		this.jdbcTemplate.update("INSERT INTO ROLES VALUES(?,?)", username, role);
	}
	private class UserMapper implements RowMapper<UserApp>{

		@Override
		public UserApp mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserApp user = new UserApp();
			user.setUsername(rs.getString("login"));
			user.setPassword(rs.getString("password"));
			return user;
		}
		
	}
}
