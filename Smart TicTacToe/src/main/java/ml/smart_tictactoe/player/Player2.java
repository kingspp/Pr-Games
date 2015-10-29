package ml.smart_tictactoe.player;

import ml.smart_tictactoe.Board;

public class Player2 extends Player {

	@Override
	public void getName()
	{
		System.out.print("Enter the name of Player 2: ");
		setPlayer2(scan.nextLine());
		System.out.print(Player.getPlayer2() + "'s chance: ");
	}

	@Override
	public int getInput()
	{
		System.out.print(Player.getPlayer2() + "'s chance: ");
		Board.setOption(scan.nextLine());
		Board.splits = Board.getOption().split(" ");
		int x = parseInt(0);
		int y = parseInt(1);
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
