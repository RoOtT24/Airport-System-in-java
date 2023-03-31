package application;

public abstract class Person {
	
	private String name;

	public Person() {
		super();
	}

	public Person(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	//sprotected abstract Person person(String name);

	@Override
	public String toString() {
		return "name=" + name + "";
	}

}