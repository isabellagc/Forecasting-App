package mainApp.storage;

import java.util.List;

import mainApp.appData.IAppObject;

public interface IStorage<T extends IAppObject> {

	public void onStartup();
	public boolean create(T obj);
	public List<T> read();
	public boolean update(T obj);
	public boolean delete(T obj);
}
