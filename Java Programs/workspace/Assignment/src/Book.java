
public class Book { 
	String title;
	boolean borrowed;
	public Book(String bookTitle){
		title=bookTitle;
	}
	public void borrowed(){
		borrowed=true;
	}
	public void returned(){
		borrowed=false;
	}
	public boolean isBorrowed(){
		
		  return borrowed;
	}
	public String getTitle(){
		return title;
	}
}
	