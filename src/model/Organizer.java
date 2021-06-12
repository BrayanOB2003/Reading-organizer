package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Organizer {
	
	private Categories categories;
	private Readings readings;
	
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
	
	public boolean addReading(byte[] r, Category category, String name, LocalDate date) {
		return readings.addReading(r, category, name, date);
	}
	
	public ArrayList<Category> getCategoriesList(){
		return categories.getList();
	}
}