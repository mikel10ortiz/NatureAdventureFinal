package es.uji.natureadventure.dao.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import es.uji.natureadventure.auxiliars.BookingActivityName;
import es.uji.natureadventure.dao.interfaces.IBookingDao;
import es.uji.natureadventure.domain.Booking;

@Repository
public class BookingDao implements IBookingDao {
		
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public BookingDao(){
		super();
	}

	@Override
	public int saveBooking(Booking b) {
		
		String sql = "INSERT INTO Booking"
				+ "(activityId, bookingDate, activityDate, hour, clientIdCard, clientName,"
				+ "clientPhone, clientEmail, status, peopleNumber)"
				+ " VALUES (?,current_date,?,?,?,?,?,?,?,?)";
		
		KeyHolder holder = new GeneratedKeyHolder();
		
		
		this.jdbcTemplate.update(
				new PreparedStatementCreator(){

					@Override
					public PreparedStatement createPreparedStatement(
							Connection connection) throws SQLException {
						PreparedStatement st = connection.prepareStatement(sql,new String[]{"id"});
						st.setInt(1, b.getActivityId());
						
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
						String date = sdf.format(b.getActivityDate());
						st.setDate(2, Date.valueOf(date));

						Long hour = b.getHour().getTime();
						Date hourD = new Date(hour);
						
						st.setTime(3, new Time(b.getHour().getTime()));
						
						st.setString(4, b.getClientIdCard());
						st.setString(5, b.getClientName());
						st.setString(6, b.getClientPhone());
						st.setString(7, b.getClientEmail());
						st.setBoolean(8, false);
						st.setInt(9, b.getPeopleNumber());
						return st;
					}
					
				}, holder);
		
		int id = holder.getKey().intValue();
		return id;
		/*
		this.jdbcTemplate.update("INSERT INTO Booking"
				+ "(activityId, bookingDate, activityDate, hour, clientIdCard, clientName,"
				+ "clientPhone, clientEmail, status, peopleNumber)"
				+ " VALUES (?,current_date,?,?,?,?,?,?,?,?)",
				b.getActivityId(),
				b.getActivityDate(),
				b.getHour(),
				b.getClientIdCard(),
				b.getClientName(),
				b.getClientPhone(),
				b.getClientEmail(),
				false,
				b.getPeopleNumber());
				^*/
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
	
	@Override
	public List<Booking> getBookingsByInstructor(String idCard) {
		return this.jdbcTemplate.query("SELECT * FROM Booking WHERE instructor = ? "
										+ "ORDER BY activitydate DESC",
										new Object[] {idCard}, new BookingMapper());
	}

	@Override
	public List<BookingActivityName> getBookingsActivityName(){
		return this.jdbcTemplate.query("SELECT b.bookingId, b.activityDate, a.Name AS activityName, b.clientName"
				+ " FROM booking b, activity a WHERE b.activityId = a.id", new BookingActivityNameMapper());
	}
	
	private static final class BookingMapper implements RowMapper<Booking> {
		
		public  Booking mapRow(ResultSet rs, int rowNum) throws SQLException {
			Booking b = new Booking();
			b.setBookingId(rs.getInt("id"));
			b.setActivityId(rs.getInt("activityId"));
			b.setBookingDate(rs.getDate("bookingDate"));
			b.setActivityDate(rs.getDate("activityDate"));
			b.setHour(rs.getTime("hour"));
			b.setClientIdCard(rs.getString("clientIdCard"));
			b.setClientName(rs.getString("clientName"));
			b.setClientPhone(rs.getString("clientPhone"));
			b.setStatus(rs.getBoolean("status"));
			b.setPeopleNumber(rs.getInt("peopleNumber"));
			System.out.println(rs.getInt("peopleNumber"));
			b.setInstructor(rs.getString("instructor"));
			
			return b;
			
		}
	}
	
	private static final class BookingActivityNameMapper implements RowMapper<BookingActivityName>{

		@Override
		public BookingActivityName mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			BookingActivityName b = new BookingActivityName();
			b.setBookingId(rs.getInt("Id"));
			b.setActivityName(rs.getString("activityName"));
			b.setClientName(rs.getString("clientName"));
			b.setActivityDate(rs.getDate("activityDate"));
			return b;
		}
		
	}

}
