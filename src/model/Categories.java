package model;

import java.util.ArrayList;

public class Categories {
	
	private Category categories;
	
	public Categories() {
		
	}
	
	public boolean addCategory(String name) {
		
		Category category = new Category(name);
		
		if(categories == null) {
			categories = category;
			return true;
		} else if(category.compareTo(categories) < 0){
			category.setNext(categories);
			categories = category;
			return true;
		}else {
			return addCategory(categories, categories, category);
		}
	}
	
	private boolean addCategory(Category current, Category last, Category newCategory) {
		
		if(current.getNext() != null) {
			if(newCategory.compareTo(current) < 0) {
				newCategory.setNext(current);
				last.setNext(newCategory);
				return true;
			} else if(newCategory.compareTo(current) == 0){
				return false;
			} else {
				return addCategory(current.getNext(), current, newCategory);
			}
		} else {
			if(newCategory.compareTo(current) < 0) {
				newCategory.setNext(current);
				last.setNext(newCategory);
				return true;
			} else if(newCategory.compareTo(current) == 0) {
				return false;
			} else {
				current.setNext(newCategory);
				return true;
			}
		}
	}
	
	public boolean remove(String name) {
		if(categories.getName().equals(name)) {
			categories = categories.getNext();
			return true;
		} else {
			return remove(categories, categories, name);
		}
	}
	
	private boolean remove(Category current,Category last, String name) {
		if(current.getNext() != null) {
			if(current.getName().equals(name)) {
				last.setNext(current.getNext());
				return true;
			} else {
				return remove(current.getNext(), current, name);
			}
		} else {
			if(current.getName().equals(name)) {
				current = null;
				return true;
			} else {
				return false;
			}
		}
	}
	
	public boolean modify(String oldName, String newName) {
		return categoryModify(categories, oldName, newName);
	}
	
	private boolean categoryModify(Category current, String oldName, String newName) {
		if(current != null) {
			if(current.getName().equals(oldName)) {
				current.setName(newName);
				return true;
			} else {
				return categoryModify(current.getNext(), oldName, newName);
			}
		} else {
			return false;
		}
	}
	/*
	private void sortCategories() {
		sortCategories(categories.getNext(), categories);
	}
	
	private void sortCategories(Category current, Category last) {
		
		if(current.getNext() != null) {
			if(current.getNext().compareTo(current) < 0) {
				Category temp = current;
				temp.setNext(current.getNext().getNext());
				current.getNext().setNext(temp);
				last.setNext(current.getNext());
				sortCategories(current.getNext(), current);
			} else {
				sortCategories(current.getNext(), current);
			}
		}
	}
	*/
	
	public String print() {
		return print(categories, "");
	}
	
	private String print(Category current, String p) {
		if(current.getNext() != null) {
			p += current.getName() + " : ";
			return print(current.getNext(), p);
		} else {
			p += current.getName() + " : ";
			return p;
		}
	}
	
	public Category getCategories() {
		return categories;
	}

	public void setCategories(Category categories) {
		this.categories = categories;
	}
	
	public ArrayList<Category> getList(){
		ArrayList<Category> c = new ArrayList<Category>();
		return getList(categories, c);
	}
	
	private ArrayList<Category> getList(Category current, ArrayList<Category> c) {
		if(current != null) {
			c.add(current);
			return getList(current.getNext(), c);
		} else {
			return c;
		}
	}
}
