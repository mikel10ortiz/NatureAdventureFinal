package es.uji.natureadventure.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import es.uji.natureadventure.dao.interfaces.IBookingDao;
import es.uji.natureadventure.dao.interfaces.ISpecializationDao;
import es.uji.natureadventure.domain.Booking;


public class BookingDao implements IBookingDao {
	
	private Connection con;
	
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public BookingDao(){
		super();
	}

	@Override
	public void saveBooking(Booking b) {
		this.jdbcTemplate.update("INSERT INTO Booking"
				+ "(bookingId, activityId, bookingDate, activityDate, hour, clientIdCard, clientName,"
				+ "clientPhone, clientEmail, status, peopleNumber, instructor)"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)",
				b.getBookingId(),
				b.getActivityId(),
				b.getBookingDate(),
				b.getActivityDate(),
				b.getHour(),
				b.getClientIdCard(),
				b.getClientName(),
				b.getClientPhone(),
				b.getClientEmail(),
				b.getStatus(),
				b.getPeopleNumber(),
				b.getInstructor());
	}

	@Override
	public void updateBooking(Booking b) {
		this.jdbcTemplate.update("UPDATE Booking SET"
				+ "activityId = ?,"
				+ "bookingDate = ?,"
				+ "activityDate = ?,"
				+ "hour = ?,"
				+ "clientIdCard = ?,"
				+ "clientName = ?,"
				+ "clientPhone = ?,"
				+ "clientEmail = ?,"
				+ "status = ?,"
				+ "peopleNumber = ?,"
				+ "instructor = ?"
				+ "WHERE bookingId = ?",
				b.getBookingId(),
				b.getActivityId(),
				b.getBookingDate(),
				b.getActivityDate(),
				b.getHour(),
				b.getClientIdCard(),
				b.getClientName(),
				b.getClientPhone(),
				b.getClientEmail(),
				b.getStatus(),
				b.getPeopleNumber(),
				b.getInstructor());
	}

	@Override
	public Booking getBooking(int id) {
		
		return this.jdbcTemplate.queryForObject("SELECT * FROM Booking WHERE id = ?",
												new Object[] {id}, new BookingMapper());
	}

	@Override
	public List<Booking> getBookings() {
		
		return this.jdbcTemplate.query("SELECT * FROM Booking", new BookingMapper());
	}
	
private static final class BookingMapper implements RowMapper<Booking> {
		
		public  Booking mapRow(ResultSet rs, int rowNum) throws SQLException {
			Booking b = new Booking();
			b.setBookingId(rs.getInt("bookingId"));
			b.setActivityId(rs.getInt("activityId"));
			b.setBookingDate(rs.getDate("bookingDate"));
			b.setActivityDate(rs.getDate("activityDate"));
			b.setHour(rs.getTime("hour"));
			b.setClientIdCard(rs.getString("clientIdCard"));
			b.setClientName(rs.getString("clientName"));
			b.setClientPhone(rs.getString("clientPhone"));
			b.setStatus(rs.getBoolean("status"));
			b.setPeopleNumber(rs.getInt("peopleNumber"));
			b.setInstructor(rs.getString("instructor"));
			
			return b;
			
		}
	}

}
