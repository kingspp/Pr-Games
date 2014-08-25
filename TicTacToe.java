import java.util.*;

public class ttt {

	public static void main(String v[])
	{
		System.out.println("Welcome to Tic Tac Toe Game\n");	
		Board mat=new Board();
		
		
		Scanner scan= new Scanner(System.in);
		System.out.print("Enter the name of Player 1: ");
		Player.player1=scan.nextLine();
		System.out.print("Enter the name of Player 2: ");
		Player.player2=scan.nextLine();		
		//player.printPlayer();
		System.out.println("Lets Start the game...\n");
		
		mat.initilizeBoard();
		mat.printBoard();
		//(Board.ROW*Board.COL)
		for(int chance=0;chance<1;chance++)
		{
			if(chance%2==0)
			{
				System.out.print(Player.player1+"'s chance: ");
				Board.option=scan.next();
				Board.splits=Board.option.split(" ");
				//System.out.println(Integer.parseInt(Board.splits[0]));
				//System.out.println(Integer.parseInt(Board.splits[1]));
				//Board.mat[Integer.parseInt(Board.splits[0])][Integer.parseInt(Board.splits[1])]='O';
				for(String s:Board.splits){
		            System.out.println(s);
		        }
				
				
			}
		}
		mat.printBoard();
		
		
		
		
	
	}
}

class Board
{
	static int ROW=3,COL=3;
	static char mat[][]=new char[ROW][COL];
	static String option;
	static String[] splits;
	
	void initilizeBoard()
	{
		for(int i=0;i<ROW;i++)
			for(int j=0;j<COL;j++ )
				mat[i][j]='*';
		
	}
	
	void printBoard()
	{
		for(int i=0;i<ROW;i++)
		{
			for(int j=0;j<COL;j++)
				System.out.print("\t"+mat[i][j]);
			System.out.println("\t\n");
		}
	}
	
	
}


class Player{
	static String player1,player2;
	
	void printPlayer()
	{
		System.out.println("Player 1: "+player1);
		System.out.println("Player 2: "+player2);
	}
	
}



