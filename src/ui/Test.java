package ui;

import model.Categories;

public class Test {
	
	public static void main(String[] args) {
		Categories c = new Categories();
		
		System.out.println(c.addCategory("d"));
		System.out.println(c.addCategory("b"));
		System.out.println(c.addCategory("c"));
		System.out.println(c.addCategory("a"));
		System.out.println(c.print());
		System.out.println(c.modify("b", "f"));
		System.out.println(c.print());
	}

}
