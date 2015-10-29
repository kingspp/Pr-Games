package ml.smart_tictactoe.player;

import java.util.Random;
import ml.smart_tictactoe.Board;

public class Computer extends Player {

	Random rand = new Random();

	@Override
	public int getInput()
	{
		System.out.print(getPlayer1() + "'s chance: ");
		int x = rand.nextInt(Board.getROW()) + 0;
		int y = rand.nextInt(Board.getROW()) + 0;
		System.out.println(x + " " + y);
		if( Board.getMat()[x][y] == Board.getDefchar() )
			Board.getMat()[x][y] = 'X';
		else
		{
			error();
			return -1;
		}
		return 0;
	}
}
