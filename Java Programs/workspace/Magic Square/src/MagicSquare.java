import java.io.*;
import java.util.*;


 class FileEmptyException extends Exception{

	  FileEmptyException(){
		 System.out.println("File name cannot be Empty");
		 printStackTrace();
	 }
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}

public class MagicSquare {

	// int[] [] square= new int[5] [5];

	private ArrayList<int[]> square = new ArrayList<int[]>();
	private int finalSum;

	 MagicSquare(String fileName) throws IOException {
		BufferedReader myFile = null;
		String line = null;

		myFile = new BufferedReader(new FileReader(fileName));
		ArrayList<Integer> rows = new ArrayList<Integer>();
		while ((line = myFile.readLine()) != null) {

			if (line != null && !line.isEmpty()) {

				for (String number : line.split("\t")) {

					rows.add(Integer.valueOf((number)));
				}

				int[] row = new int[rows.size()];
				int i = 0;
				for (int x : rows) {

					row[i] = x;
					i++;

				}

				square.add(row);

				rows.clear();

			} else {
				continue;
			}
		}

		for (int x : square.get(0)) {

			finalSum += x;

		}
		
		myFile.close();
	}
	 
	 public void checkSquare(){
		 
		 if(checkRow()==true && checkColumn()==true && checkDiag()== true){
			 System.out.println("It is a Magic Square as the rows, columns and both diagonals all sum up to "+finalSum);
		 }
		 
	 }

	public boolean checkRow() {

		boolean rowCheck = false;


		for (int[] row : square) {
			int sum = 0;

			for (int x : row) {
				sum += x;
			}

			if (sum == finalSum) {
				rowCheck = true;
				continue;
			} else {
				rowCheck = false;
				break;
			}

		}

		return rowCheck;
	}

	public boolean checkColumn() {

		boolean columnCheck = false;

		for (int c = 0; c < square.size(); c++) {
			int sum = 0;
			for (int r = 0; r < square.size(); r++) {
				sum += square.get(r)[c];
			}
			if (sum == finalSum) {
				columnCheck = true;
				continue;
			} else {
				columnCheck = false;
				break;
			}

		}

		return columnCheck;
	}

	public boolean checkDiag() {

		boolean diagCheck = false;
		int sum = 0;

		for (int c = 0; c < square.size(); c++) {

			for (int r = 0; r < square.size(); r++) {

				if (r == c) {
					sum += square.get(r)[c];
				}
			}

		}
		
		if (sum == finalSum) {

		} else {
			diagCheck = false;

		}
		sum = 0;
		for (int c = 0; c < square.size(); c++) {

			for (int r = 0; r < square.size(); r++) {

				if (r == (square.size() - c-1)) {
					sum += square.get(r)[c];
				}
			}

		}

		
		if (sum == finalSum) {
			diagCheck = true;

		} else {
			diagCheck = false;

		}

		return diagCheck;
	}

	public static void main(String[] args) throws FileEmptyException {
		// TODO Auto-generated method stub

		System.out.println("Enter File Name with extention. Eg. Luna.txt:-");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String fileName = "";
		try {
			fileName = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(fileName==null || fileName.isEmpty()){
			throw new FileEmptyException();
			
			
		}
		
		MagicSquare ms1 = null;
		try {
			ms1=new MagicSquare(fileName);
		} catch (FileNotFoundException f) {
			System.out.println("Cannot locate file. Please check file name or use absolute path if necessary.");

			System.exit(2);
		} catch (IOException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ms1.checkSquare();

	}

}
