package mainApp.storage;

import java.util.ArrayList;
import java.util.List;

import mainApp.appData.IAppObject;

public class MemoryStorage<T extends IAppObject> implements IStorage<T> {

	private ArrayList<T> list = new ArrayList<T>();
	
	@Override
	public boolean create(T obj) {
		int index = this.getIndexOf(obj.getId());
		if(index == -1){
			list.add(obj);
			return true;
		}
		return false;
	}

	@Override
	public List<T> read() {
		return list;
	}

	@Override
	public boolean update(T obj) {
		int index = this.getIndexOf(obj.getId());
		if(index != -1){
			list.set(index, obj);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean delete(T obj) {
		int index = this.getIndexOf(obj.getId());
		if(index != -1){
			list.remove(index);
			return true;
		}
		return false;
	}

	private int getIndexOf(long id){
		for(T t : list){
			if(t.getId() == id)
			{
				return list.indexOf(t);
			}
		}
		
		return -1;
	}

	@Override
	public void onStartup() { }

	
}
