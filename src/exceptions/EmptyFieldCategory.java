package exceptions;

public class EmptyFieldCategory extends Exception{

	private static final long serialVersionUID = 1L;

	String name;
	
	public EmptyFieldCategory(String name){
		super("Cannot create category with empty fields");
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
