package exceptions;

public class EmptyFieldReading extends Exception{

	
	private static final long serialVersionUID = 1L;
	private String name;
	private String Category;
	
	public EmptyFieldReading(String name, String Category) {
		super("Cannot create reading with empty fields ");
		this.name = name;
		this.Category = Category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}
}
