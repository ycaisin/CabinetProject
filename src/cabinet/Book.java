package cabinet;

public class Book extends Thing{

	@Override
	public void setName(String name) {
		this.name = name;
		
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + "]";
	}

}
