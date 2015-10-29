package ml.smart_tictactoe.player;

import java.util.Scanner;
import ml.smart_tictactoe.Board;

public class Player1 extends Player {

	Scanner scan = new Scanner(System.in);

	@Override
	public void getName()
	{
		System.out.print("Enter the name of Player 1: ");
		setPlayer1(scan.nextLine());
	}

	@Override
	public int getInput()
	{
		System.out.print(Player.getPlayer1() + "'s chance: ");
		Board.setOption(scan.nextLine());
		Board.splits = Board.getOption().split(" ");
		int x = parseInt(0);
		int y = parseInt(1);
		if( Board.getMat()[x][y] == Board.getDefchar() )
			Board.getMat()[x][y] = 'O';
		else
		{
			error();
			return -1;
		}
		return 0;
	}

}
