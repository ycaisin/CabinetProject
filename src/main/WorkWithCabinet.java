package main;

import cabinet.Book;
import cabinet.Cabinet;
import cabinet.Phone;
import cabinet.Tablet;
import cabinet.Thing;
import cabinet.WrongShelfNameException;

public class WorkWithCabinet {

	public static void main(String[] args) throws WrongShelfNameException {
			Thing book = new Book();
			Thing tablet = new Tablet();
			Thing phone = new Phone();
			
			book.setName("topShelf");
			tablet.setName("middleShelf");
			phone.setName("bottomShelf");
			
			Cabinet cabinet1 = new Cabinet();
			cabinet1.setThings(book, tablet, phone);
			cabinet1.print();
			
			System.out.println("FIND");			
			try{
				cabinet1.findShelf("test");
			}catch(WrongShelfNameException e){
				System.out.println(e.getMessage());
			}
			
			System.out.println("Put phone to middle shelf:");
			cabinet1.put("middleShelf", new Phone());
			cabinet1.print();
			
			try{
				Thing result = cabinet1.whatIsOn("bottomShelf");
				System.out.println("The " + result.toString() + " is placed on bottom shelf");
				
				result = cabinet1.take("bottomShelf");
				System.out.println("The " + result.toString() + " was taken from the bottom shelf");
				
			}catch(WrongShelfNameException e){
				System.out.println(e.getMessage());
			}
			
			cabinet1.print();
			
	}

}
