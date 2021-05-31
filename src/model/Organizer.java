package model;

public class Organizer {
	
	private Categories categories;
	
	public Organizer() {
		categories = new Categories();
	}
	
	public boolean addCategory(String name){
		return categories.addCategory(name);
	}
	
	public boolean removeCategory(String name) {
		return categories.remove(name);
	}
	
	public boolean modifyCategory(String oldName, String newName) {
		return categories.modify(oldName, newName);
	}
}