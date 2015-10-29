package ml.smart_tictactoe.player;

import java.util.Scanner;
import ml.smart_tictactoe.Board;

public class Player {

	private static String player1;
	private static String player2;
	Scanner scan = new Scanner(System.in);

	void printPlayer()
	{
		System.out.println("Player 1: " + getPlayer1());
		System.out.println("Player 2: " + getPlayer2());
	}

	public void getName()
	{
	}

	int getInput()
	{
		return 0;
	}

	void error()
	{
		System.out.println("Error! Please try again");
	}

	static int parseInt( int x )
	{
		x = Integer.parseInt(Board.splits[x]);
		return x;
	}

	public static String getPlayer1()
	{
		return player1;
	}

	public static void setPlayer1( String player1 )
	{
		Player.player1 = player1;
	}

	public static String getPlayer2()
	{
		return player2;
	}

	public static void setPlayer2( String player2 )
	{
		Player.player2 = player2;
	}
}
