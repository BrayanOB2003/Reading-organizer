package model;

import java.time.LocalDate;

public class Reading {
	
	private String name;
	private byte[] reading;
	private Category category; 
	private LocalDate date;
	private Reading next;
	
	public Reading(byte[] r, Category c, String n, LocalDate d) {
		reading = r;
		category = c;
		date = d;
		name = n;
	}

	public byte[] getReading() {
		return reading;
	}

	public void setReading(byte[] reading) {
		this.reading = reading;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Reading getNext() {
		return next;
	}

	public void setNext(Reading next) {
		this.next = next;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
