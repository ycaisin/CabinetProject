package cabinet;

public class Tablet extends Thing{

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
		return "Tablet [name=" + name + "]";
	}

}
