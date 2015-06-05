package es.uji.natureadventure.security;

public class UserApp {

	private String username;
	private String password;

	public UserApp() {
		super();
	}
	
	public UserApp(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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
	
	
}
