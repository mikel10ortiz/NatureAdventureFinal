package es.uji.natureadventure.dao.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.natureadventure.dao.interfaces.IInstructorDao;
import es.uji.natureadventure.domain.Instructor;

@Repository
public class InstructorDao implements IInstructorDao{
	
//	private ISpecializationDao specializationDao = new SpecializationDao();
	
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public InstructorDao(){
		super();
	}

	@Override
	public void saveInstructor(Instructor i) {
		this.jdbcTemplate.update("INSERT INTO Instructor"
				+ "(name, lastName, address, telephone, email, idCard, dateOfBirth, inittialHour, finalHour, entryDate, username, password)"
				+ " VALUES"
				+ "("
				+ "?,?,?,?,?,?,?,?,?,?,?,?"
				+ ")",
				i.getName(),
				i.getLastName(),
				i.getAddress(),
				i.getTelephone(),
				i.getEmail(),
				i.getIdCard(),
				i.getDateOfBirth(),
				i.getInittialHour(),
				i.getFinalHour(),
				i.getEntryDate(),
				i.getUsername(),
				i.getPassword());
		
		// falta guardar las especializaciones en la base de datos
	}

	@Override
	public void updateInstructor(Instructor i) {
		this.jdbcTemplate.update("UPDATE Instructor SET"
				+ "name = ?,"
				+ "lastName = ?,"
				+ "address = ?,"
				+ "telephone = ?,"
				+ "email = ?,"
				+ "dateOfBirth = ?,"
				+ "initialHour = ?,"
				+ "finalHour = ?,"
				+ "entryDate = ?,"
				+ "username = ?,"
				+ "password = ?"
				+ "WHERE idCard = ?",
				i.getName(),
				i.getLastName(),
				i.getAddress(),
				i.getTelephone(),
				i.getEmail(),
				i.getDateOfBirth(),
				i.getInittialHour(),
				i.getFinalHour(),
				i.getEntryDate(),
				i.getUsername(),
				i.getPassword(),
				i.getIdCard());
			// falta especializaciones
	}

	@Override
	public Instructor getInstructor(String idCard) {
		return this.jdbcTemplate.queryForObject("SELECT * from Instructor "
					+ "WHERE idCard = ?", new Object[] {idCard}, new InstructorMapper());
		
	}

	@Override
	public List<Instructor> getInstructors() {

		return this.jdbcTemplate.query("SELECT * FROM Instructor", new InstructorMapper());
	}
	
	private static final class InstructorMapper implements RowMapper<Instructor> {
		
		public  Instructor mapRow(ResultSet rs, int rowNum) throws SQLException {
			Instructor i = new Instructor();
			i.setName(rs.getString("name"));
			i.setLastName(rs.getString("lastName"));
			i.setAddress(rs.getString("address"));
			i.setTelephone(rs.getString("telephone"));
			i.setEmail(rs.getString("email"));
			i.setIdCard(rs.getString("idCard"));
			i.setDateOfBirth(rs.getDate("dateOfBirth"));
			i.setInittialHour(rs.getTime("inittialHour"));
			i.setFinalHour(rs.getTime("finalHour"));
			i.setEntryDate(rs.getDate("entryDate"));
			i.setUsername(rs.getString("username"));
			i.setPassword(rs.getString("password"));
			//i.setQualifiedFor(specializationDao.getSpecializationsForInstructor(i.getIdCard()));			
			
			return i;
			
		}
	}

}
