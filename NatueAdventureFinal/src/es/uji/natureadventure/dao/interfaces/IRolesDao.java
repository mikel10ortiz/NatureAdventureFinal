package es.uji.natureadventure.dao.interfaces;

import java.util.List;

public interface IRolesDao {

	public List<String> getRolesByUsername(String username);
}
