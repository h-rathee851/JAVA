
public class Baby {

	String name;
	static int numBabiesMade = 0;
	Baby(String myName) {
	numBabiesMade += 1;
	name=myName;
	}
	static void cry(Baby b6) { 
		System.out.println(b6.name + "cries");
		}
}
