package mainApp.storage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import mainApp.appData.IAppObject;

public class LocalDiskStorage<T extends IAppObject> implements IStorage<T> {

	private static final String FILE_PATH = "./data";
	
	private static final boolean DELETE_ON_STARTUP = true;
	
	@Override
	public boolean create(T obj) {
		List<T> objects = readFile();
		if(objects == null) objects = new ArrayList<T>();
		
		objects.add(obj);
		return writeFile(objects);
	}

	@Override
	public List<T> read() {
		return readFile();
	}

	@Override
	public boolean update(T obj) {
		if(obj == null) return false;
		
		List<T> objects = readFile();
		if(objects == null || objects.isEmpty()) return false;
		
		for(int i = 0; i < objects.size(); i++) {
			if(objects.get(i).equals(obj)) {
				objects.remove(i);
				objects.add(obj);
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean delete(T obj) {
		if(obj == null) return false;
		
		List<T> objects = readFile();
		if(objects == null || objects.isEmpty()) return false;
		
		for(int i = 0; i < objects.size(); i++) {
			if(objects.get(i).equals(obj)) {
				objects.remove(i);
				return true;
			}
		}
		
		return false;
	}
	
	private boolean writeFile(List<T> objects) {
		FileOutputStream fos = getFileOutputStream(false);
		if(fos == null) return false;
		
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(fos);
			oos.writeObject(objects);
		} catch (IOException e) {
			return false;
		} finally {
			try {
				if(oos != null) oos.close();
			} catch (IOException e) { }
			try {
				if(fos != null) fos.close();
			} catch (IOException e) { }
		}
		
		return true;
	}
	
	private List<T> readFile() {
		FileInputStream fis = getFileInputStream();
		if(fis == null) return new ArrayList<T>();
		
		ObjectInputStream ois = null;
		List<T> result = null;
		
	    try {
			ois = new ObjectInputStream(fis);
			result = (List<T>) ois.readObject();
		} catch (IOException e) {
			System.err.println("Error reading file: " + e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(ois != null) ois.close();
			} catch (IOException e) { }
			try {
				if(fis != null) fis.close();
			} catch (IOException e) { }
		}
	      
	    return result;
	}
	
	private FileOutputStream getFileOutputStream(boolean append) {
		try {
			return new FileOutputStream(FILE_PATH, append);
		} catch (FileNotFoundException e) {
			System.err.println("Couldn't find file: " + e);
			return null;
		}
	}
	
	private FileInputStream getFileInputStream() {
		try {
			return new FileInputStream(FILE_PATH);
		} catch (FileNotFoundException e) {
			System.err.println("Couldn't find file: " + e);
			return null;
		}
	}

	@Override
	public void onStartup() {
		if(DELETE_ON_STARTUP) {
			System.out.println("DELETE_ON_STARTUP: Deleting old data file");
			writeFile(new ArrayList<T>());
		}
	}
}
