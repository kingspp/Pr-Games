/*
Created on Aug 28, 2014

@author: Prathyush
*/

import java.util.*;

public class ttt {
	public static void main(String v[]) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Welcome to Tic Tac Toe Game\n");
		System.out.println("Select among:");
		System.out.println("1.Player vs Player");
		System.out.println("2.Player vs Computer");
		System.out.print("Enter your Choice: ");
		int ch=scan.nextInt();
		Board mat = new Board();
		Player1 player1=new Player1();
		Player2 player2=new Player2();	
		Comp player=new Comp();		
		System.out.println("Lets Start the game...\n");
		mat.initilizeBoard();
		
		switch(ch){		
		case 1:		
			player1.getName();
			player2.getName();
			System.out.println(Player.player1 + " vs "+ Player.player2);
			mat.printBoard();			
			for (int chance = 0; chance < (Board.ROW * Board.COL); chance++) {
				if (chance % 2 == 0) {						
						if(player1.getInput()==-1)
							chance--;
				} 
				else {
					if(player2.getInput()==-1)
						chance--;					
				}
				mat.printBoard();
				mat.checkBoard();			
			}	
			break;			
			
		case 2:		
			player1.getName();
			Player.player2="Comp";
			System.out.println(Player.player1 + " vs "+ Player.player2);
			mat.printBoard();
			for (int chance = 0; chance < (Board.ROW * Board.COL); chance++) {
				if (chance % 2 == 0) {						
						if(player1.getInput()==-1)
							chance--;
				} 
				else {
					if(player.getInput()==-1)
						chance--;					
				}
				mat.printBoard();
				mat.checkBoard();			
			}	
			break;		
		}		
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
			{
				k++;
				won(k,i);
			}
			else
				break;		

		// row
		for (int i = 0; i < ROW; i++) {
			k = 0;
			for (int c = 0; c < ROW - 1; c++) {
				if (mat[i][c] == mat[i][c + 1] && mat[i][i] != defchar) {
					k++;
					won(k,i);
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
					won(k,i);
				} else
					break;
			}
		}

		// Second Diagonal
		int j = 2;
		k = 0;
		for (int i = 0; i < ROW-1; i++) {
			if (mat[i][j] == mat[i + 1][j - 1] && mat[i][j] != defchar)
				k++;
			j--;
			won(k,i);			
		}
	}
	
	void won(int x,int i)
	{
		if (x == 2) {
			if (mat[i][i] == 'O' )
				System.out.println(Player.player1 + " won!!! Congrats!!");
			else				
				System.out.println(Player.player2 + " won!!! Congrats!!");
			System.exit(0);
		}		
	}
}

class Player {
	static String player1, player2;
	Scanner scan=new Scanner(System.in);
	
	void printPlayer() {
		System.out.println("Player 1: " + player1);
		System.out.println("Player 2: " + player2);
	}
	
	void getName(){}
	
	int getInput(){	return 0;}
	
	void error()
	{
		System.out.println("Error! Please try again");
	}
	
	static int parseInt(int x)
	{
		x=Integer.parseInt(Board.splits[x]);
		return x;
	}
}

class Player1 extends Player{ 
	
	void getName()
	{		
		System.out.print("Enter the name of Player 1: ");
		player1 = scan.nextLine();	
	}
	
	int getInput()
	{		
		System.out.print(Player.player1 + "'s chance: ");
		Board.option = scan.nextLine();
		Board.splits = Board.option.split(" ");							
		int x=parseInt(0);
		int y=parseInt(1);				
		if (Board.mat[x][y] == Board.defchar)
			Board.mat[x][y] = 'O';
		else {
			error();
			return -1;
		}	
		return 0;
	}
	
}

class Player2 extends Player{
	
	void getName()
	{			
		System.out.print("Enter the name of Player 2: ");
		player2 = scan.nextLine();
		System.out.print(Player.player2 + "'s chance: ");		
	}
	
	int getInput()
	{		
		System.out.print(Player.player2 + "'s chance: ");
		Board.option = scan.nextLine();
		Board.splits = Board.option.split(" ");
		int x=parseInt(0);
		int y=parseInt(1);				
		if (Board.mat[x][y] == Board.defchar)
			Board.mat[x][y] = 'X';
		else {
			error();
			return -1;
		}
		return 0;
	}	
}
	
class Comp extends Player{		
	Random rand=new Random();
	
	int getInput()
	{
		System.out.print(player1 + "'s chance: ");
		int x=rand.nextInt(3)+0;
		int y=rand.nextInt(3)+0;
		System.out.println(x+" "+y);
		if (Board.mat[x][y] == Board.defchar)
			Board.mat[x][y] = 'X';
		else {
			error();
			return -1;
		}	
		return 0;		
	}
}
