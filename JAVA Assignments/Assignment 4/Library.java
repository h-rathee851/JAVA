import java.util.*;

public class Library {
	static String openingHours = "9am To 5pm";
	String address;
	ArrayList<Book> libBooks = new ArrayList<Book>();
	int booksNum = 0;

	Library(String libaddress) {
		address = libaddress;
	}

	public void printAddress() {
		System.out.println(address);
	}

	public static void printOpeningHours() {
		System.out.println(openingHours);
	}

	public void addBook(Book b) {

		libBooks.add(b);

	}

	public void printAvailableBooks() {

		for (int i = 0; i < libBooks.size(); i++) {

			if (libBooks.get(i).isBorrowed() == false && libBooks.size() != 0) {
				System.out.println(libBooks.get(i).getTitle());
			}
		}

		if (libBooks.size() == 0) {
			System.out.println("No Book in Catalog");
		}
	}

	public void borrowBook(String name) {
		
		if (libBooks.size() == 0) {

			System.out.println("Sorry, this book is not in our catalog.");

		}

		for (int i = 0; i < libBooks.size(); i++) {

			

			if (libBooks.get(i).getTitle() == name && libBooks.get(i).isBorrowed() == true) {
				System.out.println("Sorry, this book is already borrowed.");
			}

			if (libBooks.get(i).getTitle() == name && libBooks.get(i).isBorrowed() == false) {
				libBooks.get(i).borrowed();
				System.out.println("You successfully borrowed The Lord of the Rings.");
				break;
			}

			if (i == libBooks.size() && libBooks.get(i).getTitle() != name) {

				System.out.println("Sorry, this book is not in our catalog.");
				break;

			}
		}
	}
	
	public void returnBook(String name){
		
		for(int i=0; i<libBooks.size();i++){
			if(libBooks.get(i).getTitle()==name){
				libBooks.get(i).returned();
				break;
			}
		}
	}
}