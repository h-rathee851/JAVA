
public class FooCorporation {
	public static int first(int[] time, String[] runner) {
		int maxTime = time[0];
		String winner = "";
		for (int i = 0; i < time.length; i++) {
			if (time[i] <= maxTime) {
				maxTime = time[i];
				winner = runner[i];
			}
		}

		System.out.println("The winner is " + winner + " with time " + maxTime + "minutes.");
		return maxTime;
	}

	public static void second(int[] time, String[] runner) {
		int maxTime = first(time, runner);
		int runnerTime=0;
		if (maxTime!= time[0]){
		 runnerTime = time[0];
		}
		else{
			runnerTime=time[1];
		}
		String runnerUp = "";
		for (int i = 0; i < time.length; i++) {
			if (time[i] > maxTime && time[i] <= runnerTime) {
				runnerTime = time[i];
				runnerUp = runner[i];
			}

		}
		System.out.println("The runner up is " + runnerUp + " with time " + runnerTime + "minutes.");
	}

	public static void main(String[] arguments) {

		int[] time = { 341, 273, 278, 329, 445, 402, 338, 275, 243, 334, 412, 393, 299, 343, 317, 265 };
		String[] runner = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James",
				"Jane", "Emily", "Daniel", "Neda", "Aron", "Kate" };
		
		second(time, runner);
	}
}
