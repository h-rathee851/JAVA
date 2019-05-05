import java.util.Arrays;
import java.util.Random;
import java.util.TreeSet;

public class Sudoku {

	private int rows;
	private int[][] sudoku;

	Sudoku(int n) {
		rows = n;
		sudoku = new int[rows][rows];
		for (int c = 0; c < rows; c++) {
			for (int r = 0; r < rows; r++) {

				sudoku[r][c] = 0;

			}

		}

	}

	public int makeSudoku() {

		int boxesOf = 3;
		// ArrayList<Integer> notavailableNum = new ArrayList<Integer>();
		TreeSet<Integer> notavNum = new TreeSet<Integer>();
		for (int c = 0; c < rows; c++) {
			for (int r = 0; r < rows; r++) {

				for (int rc = 0; rc < rows; rc++) {
					if (rc != r) {

						notavNum.add(sudoku[rc][c]);

					}
				}
				for (int cc = 0; cc < rows; cc++) {
					if (cc != c) {

						notavNum.add(sudoku[r][cc]);

					}
				}
				int innerBoundRow;
				int outerBoundRow;
				int innerBoundColumn;
				int outerBoundColumn;
				if ((r + 1) % boxesOf == 0 && r != 0) {
					innerBoundRow = r - boxesOf + 1;
					outerBoundRow = r + 1;
				} else {
					innerBoundRow = (((r + 1) / boxesOf)) * boxesOf;
					outerBoundRow = ((((r + 1) / boxesOf)) * boxesOf) + boxesOf;
				}
				if ((c + 1) % boxesOf == 0 && c != 0) {
					innerBoundColumn = c - boxesOf + 1;
					outerBoundColumn = c + 1;
				} else {
					innerBoundColumn = (((c + 1) / boxesOf)) * boxesOf;
					outerBoundColumn = ((((c + 1) / boxesOf)) * boxesOf) + boxesOf;
				}

				//System.out.println(r + "   " + c + "\n");
				for (int rc = innerBoundRow; rc < outerBoundRow; rc++) {
					for (int cc = innerBoundColumn; cc < outerBoundColumn; cc++) {

						if (rc != r || cc != c) {

							// System.out.println((((r+1)/boxesOf)-1)*boxesOf);
							//System.out.println(rc + "   " + cc);

							notavNum.add(sudoku[rc][cc]);

						}

					}
				}

				boolean got = false;
				while (got == false) {

					Random rand = new Random();
					int num = 1 + rand.nextInt(rows);
					int i = 0;
					if (notavNum.contains(0) && notavNum.contains(1) && notavNum.contains(2) && notavNum.contains(3)
							&& notavNum.contains(4) && notavNum.contains(5) && notavNum.contains(6)
							&& notavNum.contains(7) && notavNum.contains(8) && notavNum.contains(9)) {
						
						makeSudoku();
						return 0;

					}
					for (int n : notavNum) {
						i++;
						if (num == n) {
							got = false;
							break;
						}
						if (i == notavNum.size() && num != n) {
							got = true;
						}

					}

					if (got == true) {
						//System.out.println(num);
						sudoku[r][c] = num;
					}
				}
				for (int s : notavNum) {
					//System.out.println(s);
				}

				notavNum.clear();

				//System.out.println("next number");

			}

			//System.out.println("next column");

		}

		
		return 0;
	}

	public void printSoln() {

		for (int[] row : sudoku) {
			System.out.println(Arrays.toString(row));
		}
	}

	public static void main(String[] args) {
		Sudoku s1 = new Sudoku(9);
		s1.makeSudoku();
		s1.printSoln();

	}

}
