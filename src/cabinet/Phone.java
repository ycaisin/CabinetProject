package cabinet;

public class Phone extends Thing{
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
		return "Phone [name=" + name + "]";
	}
	
}
