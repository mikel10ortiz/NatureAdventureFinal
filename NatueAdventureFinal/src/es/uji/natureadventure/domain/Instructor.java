package es.uji.natureadventure.domain;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class Instructor {

	private String name;
	private String lastName;
	private String address;
	private String telephone;
	private String email;
	private String idCard;
	private Date dateOfBirth;
	private Time inittialHour;
	private Time finalHour;
	private Date entryDate;
	private String username;
	private String password;
	private List<Activity> qualifiedFor;
	
	public Instructor(){
		
	}

	public Instructor(String name, String lastName, String address,
			String telephone, String email, String idCard, Date age,
			Time initialHour, Time finalHour, Date entryDate, String username,
			String password, List<Activity> qualifiedFor) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
		this.idCard = idCard;
		this.dateOfBirth = age;
		this.inittialHour = initialHour;
		this.finalHour = finalHour;
		this.entryDate = entryDate;
		this.username = username;
		this.password = password;
		this.qualifiedFor = qualifiedFor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date age) {
		this.dateOfBirth = age;
	}

	public Time getInittialHour() {
		return inittialHour;
	}

	public void setInittialHour(Time inittialHour) {
		this.inittialHour = inittialHour;
	}

	public Time getFinalHour() {
		return finalHour;
	}

	public void setFinalHour(Time finalHour) {
		this.finalHour = finalHour;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Activity> getQualifiedFor() {
		return qualifiedFor;
	}

	public void setQualifiedFor(List<Activity> qualifiedFor) {
		this.qualifiedFor = qualifiedFor;
	}
	
	
}
