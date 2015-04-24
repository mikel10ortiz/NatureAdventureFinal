package es.uji.natureadventure.dao.interfaces;

import java.util.List;

import es.uji.natureadventure.domain.Activity;

public interface IActivityDao {

	public boolean saveActivity(Activity a);
	public Activity updateActivity(Activity a);
	public Activity getActivity(int id);
	public List<Activity> getActivities();
}
