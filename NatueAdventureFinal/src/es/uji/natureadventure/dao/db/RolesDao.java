package es.uji.natureadventure.dao.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.natureadventure.dao.interfaces.IRolesDao;

@Repository
public class RolesDao implements IRolesDao{

	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<String> getRolesByUsername(String username) {
		return this.jdbcTemplate.query("SELECT rol FROM Rol WHERE username = ?",
										new Object[] {username},new RolMapper());
	}

	private class RolMapper implements RowMapper<String>{

		@Override
		public String mapRow(ResultSet rs, int numRows) throws SQLException {
			String rol = "";
			rol = rs.getString("rol");
			return rol;
		}
		
	}
}
