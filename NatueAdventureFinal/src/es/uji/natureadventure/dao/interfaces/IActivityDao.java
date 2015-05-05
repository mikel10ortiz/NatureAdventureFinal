package es.uji.natureadventure.dao.interfaces;

import java.util.List;

import es.uji.natureadventure.domain.Activity;

public interface IActivityDao {

	public void saveActivity(Activity a);
	public void updateActivity(Activity a);
	public Activity getActivity(int id);
	public List<Activity> getActivities();
}
