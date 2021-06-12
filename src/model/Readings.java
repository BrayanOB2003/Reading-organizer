package model;

import java.time.LocalDate;

public class Readings {
	
	private Reading readings;
	
	public Readings() {
		
	}
	
	public boolean addReading(byte[] r, Category category, String name, LocalDate date) {
		Reading reading = new Reading(r, category, name, date);
		
		if(readings == null) {
			readings = reading;
			return true;
		} else if(reading.getDate().isBefore(readings.getDate())){
			reading.setNext(readings);
			readings = reading;
			return true;
		}else {
			return addReading(readings, readings, reading);
		}
		
	}
	
	private boolean addReading(Reading current, Reading last, Reading newReading) {
		
		if(current.getNext() != null) {
			if(newReading.getDate().isBefore(current.getDate())) {
				newReading.setNext(current);
				last.setNext(newReading);
				return true;
			} else if(newReading.getDate().isEqual(current.getDate())){
				return false;
			} else {
				return addReading(current.getNext(), current, newReading);
			}
		} else {
			if(newReading.getDate().isBefore(current.getDate())) {
				newReading.setNext(current);
				last.setNext(newReading);
				return true;
			} else if(newReading.getDate().isEqual(current.getDate())) {
				return false;
			} else {
				current.setNext(newReading);
				return true;
			}
		}
	}
}
