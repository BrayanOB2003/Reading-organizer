package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CategoryTest {

	@Test
	public void addCategory() {
		
	}
	
	@Test
	public void testCategory() {
		addCategory();
		
		String n = "Algebra";
		
		Category c = new Category(n);
		
		assertEquals(n, c.getName());
	}
	
	@Test
	public void modifyCategory() {
		
	}
	
	@Test
	public void testModifyCatgory() {
		modifyCategory();
		
		String c = "Algebra";
		String n = "Algebra lineal";
		
		Category numOne = new Category(n);
		Categories categories = new Categories();
		
		categories.addCategory(c);
		
		categories.modify(c, n);
		
		assertEquals(n, numOne.getName());
	}
}
