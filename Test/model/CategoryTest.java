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
		
		Category c = new Category("Algebra");
		String n = "Algebra lineal";
		
		Categories categories = new Categories();
		categories.modify(c.getName(), n);
		
		assertEquals(n, c.getName());
	}

}
