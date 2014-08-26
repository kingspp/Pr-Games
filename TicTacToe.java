import java.util.*;

public class ttt {

	public static void main(String v[]) {
		System.out.println("Welcome to Tic Tac Toe Game\n");
		Board mat = new Board();

		
		Scanner scan = new Scanner(System.in);
		System.out.println("");
		
		
		System.out.print("Enter the name of Player 1: ");
		Player.player1 = scan.nextLine();
		System.out.print("Enter the name of Player 2: ");
		Player.player2 = scan.nextLine();

		System.out.println("Lets Start the game...\n");
		mat.initilizeBoard();
		mat.printBoard();

		for (int chance = 0; chance < (Board.ROW * Board.COL); chance++) {
			if (chance % 2 == 0) {
				System.out.print(Player.player1 + "'s chance: ");
				Board.option = scan.nextLine();
				Board.splits = Board.option.split(" ");
				if (Board.mat[Integer.parseInt(Board.splits[0])][Integer
						.parseInt(Board.splits[1])] == Board.defchar)
					Board.mat[Integer.parseInt(Board.splits[0])][Integer
							.parseInt(Board.splits[1])] = 'O';
				else {
					System.out.println("Error!");
					chance--;
				}
			} else {
				System.out.print(Player.player2 + "'s chance: ");
				Board.option = scan.nextLine();
				Board.splits = Board.option.split(" ");
				if (Board.mat[Integer.parseInt(Board.splits[0])][Integer
						.parseInt(Board.splits[1])] == Board.defchar)
					Board.mat[Integer.parseInt(Board.splits[0])][Integer
							.parseInt(Board.splits[1])] = 'X';
				else {
					System.out.println("Error!");
					chance--;
				}
			}
			mat.printBoard();
			mat.checkBoard();			
		}	
		scan.close();
	}
		
	void getName()
	{
		
	}
}

class Board {
	static int ROW = 3, COL = 3;
	static char mat[][] = new char[ROW][COL];
	static String option;
	static String[] splits;
	static char defchar = '.';

	void initilizeBoard() {
		for (int i = 0; i < ROW; i++)
			for (int j = 0; j < COL; j++)
				mat[i][j] = defchar;
	}

	void printBoard() {
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++)
				System.out.print("\t" + mat[i][j]);
			System.out.println("\t\n");
		}
	}

	void checkBoard() {
		int k = 0;
		// Principal Diagonal
		for (int i = 0; i < ROW - 1; i++)
			if (mat[i][i] == mat[i + 1][i + 1] && mat[i][i] != defchar)
				k++;
			else
				break;
		if (k == 2) {
			if (mat[0][0] == 'O')
				System.out.println(Player.player1 + " won!!! Congrats!!");
			else
				System.out.println(Player.player2 + " won!!! Congrats!!");
			System.exit(0);
		}

		// row
		for (int i = 0; i < ROW; i++) {
			k = 0;
			for (int c = 0; c < ROW - 1; c++) {
				if (mat[i][c] == mat[i][c + 1] && mat[i][i] != defchar) {
					k++;
					if (k == 2) {
						if (mat[i][c] == 'O')
							System.out.println(Player.player1 + " won");
						else
							System.out.println(Player.player2 + " won");
						System.exit(0);
					}
				} else
					break;
			}
		}

		// col
		for (int i = 0; i < ROW; i++) {
			k = 0;
			for (int c = 0; c < ROW - 1; c++) {
				if (mat[c][i] == mat[c + 1][i] && mat[i][i] != defchar) {
					k++;
					if (k == 2) {
						if (mat[c][i] == 'O')
							System.out.println(Player.player1 + " won");
						else
							System.out.println(Player.player2 + " won");
						System.exit(0);
					}
				} else
					break;
			}
		}

		// Second Dialog
		int j = 2;
		k = 0;
		for (int i = 0; i < ROW - 1; i++) {
			if (mat[i][j] == mat[i + 1][j - 1] && mat[i][i] != defchar)
				k++;
			j--;
			if (k == 2) {
				if (mat[i][i] == 'O' && mat[i][i] != defchar)
					System.out.println(Player.player1 + " won");
				else
					System.out.println(Player.player2 + " won");
				System.exit(0);
			}
		}
	}
}

class Player {
	static String player1, player2;
	void printPlayer() {
		System.out.println("Player 1: " + player1);
		System.out.println("Player 2: " + player2);
	}
}
	
class Comp{
	static final String player="Comp";

}

