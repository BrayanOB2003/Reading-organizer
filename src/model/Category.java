package model;

public class Category implements Comparable<Category>{
	
	private String name;
	private boolean active;
	private Category next;
	
	public Category(String n) {
		name = n;
		active = false;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		name = n;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Category getNext() {
		return next;
	}

	public void setNext(Category next) {
		this.next = next;
	}
	
	public void replace(Category c) {
		name = c.getName();
		active = c.isActive();
		next = c.getNext();
	}
	
	@Override
	public int compareTo(Category o) {
		return name.compareTo(o.getName());
	}
	
	@Override
	public String toString() {
		return name;
	}
}
