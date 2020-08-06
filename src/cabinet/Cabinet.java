package cabinet;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Cabinet {
	//private Thing[] Things= new Thing[3];
    List<Thing> things = new ArrayList<>();
	
	public List<Thing> getThings() {
		return things;
	}

	public void setThings(Thing thing1, Thing thing2, Thing thing3) {
		this.things.add(thing1);
		this.things.add(thing2);
		this.things.add(thing3);
	}

	public Cabinet() {
	}
	
	public void findShelf(String shelfName) throws WrongShelfNameException{
		if(!things.stream().anyMatch(element -> element.getName().equals(shelfName))){
			throw new WrongShelfNameException("Incorect shelf name!");
		}else return;		
	}
	
	public Thing whatIsOn( String shelfName ) throws WrongShelfNameException{
		this.findShelf(shelfName);
		Thing th = things.stream()	
									.filter(thing -> thing.getName().equals(shelfName) ).collect(Collectors.toList()).get(0);
									//.collect(Collectors.toList());//.get(things.indexOf(shelfName)));
		return th;
		
		/*
		for(int i=0;i<this.things.size();i++)
			if(this.things.get(i).getName().equals(shelfName)) return this.things.get(i);
		
		return null;
		*/
	
	}
	
	public void put( String shelfName, Thing newThing ){
		this.things = things.stream()
								.map((thing) -> {
										if (thing.getName().equals(shelfName)){
											thing = newThing;
											thing.setName(shelfName);
										}
									return thing;
								})
								.collect(Collectors.toList());
	}
	
	public Thing take( String shelfName ) throws WrongShelfNameException{
		Thing T = this.whatIsOn(shelfName);
		if (T!=null){
			this.things = things.stream()
							.map(thing -> {
									if(shelfName.equals(thing.getName())){
									thing = null;
								}
								return thing;
								}
								).collect(Collectors.toList());
			
		}
		return T;
	}

	public void print(){
		System.out.println("Cabinet: ");
		things.forEach(thing -> {if(thing!=null)
									System.out.println(thing.toString());
					});
	}

}
