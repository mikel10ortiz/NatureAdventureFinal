package es.uji.natureadventure.dao.interfaces;

import es.uji.natureadventure.security.UserApp;

public interface IUserDetailDao {

	public void saveUser(UserApp ser);
	public void updateUser(UserApp user);
	public UserApp getUserByUsername(String username);
	public void addRoleByUsername(String username, String role);
}
