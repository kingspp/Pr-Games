package ml.smart_tictactoe;

import java.util.Scanner;
import ml.smart_tictactoe.player.Computer;
import ml.smart_tictactoe.player.Player;
import ml.smart_tictactoe.player.Player1;
import ml.smart_tictactoe.player.Player2;

public class Tictactoe {

	public static void main( String v[] )
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to Tic Tac Toe Game\n");
		System.out.println("Select among:");
		System.out.println("1.Player vs Player");
		System.out.println("2.Player vs Computer");
		System.out.print("Enter your Choice: ");
		int ch = scan.nextInt();
		Board mat = new Board();
		Player1 player1 = new Player1();
		Player2 player2 = new Player2();
		Computer player = new Computer();
		System.out.println("Lets Start the game...\n");
		mat.initilizeBoard();

		switch ( ch )
		{
			case 1 :
				player1.getName();
				player2.getName();
				System.out.println(Player.getPlayer1() + " vs " + Player.getPlayer2());
				mat.printBoard();
				for( int chance = 0; chance < (Board.getROW() * Board.COL); chance++ )
				{
					if( chance % 2 == 0 )
					{
						if( player1.getInput() == -1 )
							chance--;
					}
					else
					{
						if( player2.getInput() == -1 )
							chance--;
					}
					mat.printBoard();
					mat.checkBoard();
				}
				break;

			case 2 :
				player1.getName();
				Player.setPlayer2("Comp");
				System.out.println(Player.getPlayer1() + " vs " + Player.getPlayer2());
				mat.printBoard();
				for( int chance = 0; chance < (Board.getROW() * Board.COL); chance++ )
				{
					if( chance % 2 == 0 )
					{
						if( player1.getInput() == -1 )
							chance--;
					}
					else
					{
						if( player.getInput() == -1 )
							chance--;
					}
					mat.printBoard();
					mat.checkBoard();
				}
				break;
		}
	}

}
