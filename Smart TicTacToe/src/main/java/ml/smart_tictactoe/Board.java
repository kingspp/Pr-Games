package ml.smart_tictactoe;

import ml.smart_tictactoe.player.Player;

public class Board {

	private static int ROW = 3;
	static int COL = ROW;
	private static char mat[][] = new char[getROW()][COL];
	private static String option;
	public static String[] splits;
	private static char defchar = '.';

	void initilizeBoard()
	{
		for( int i = 0; i < getROW(); i++ )
			for( int j = 0; j < COL; j++ )
				getMat()[i][j] = getDefchar();
	}

	void printBoard()
	{
		for( int i = 0; i < getROW(); i++ )
		{
			for( int j = 0; j < COL; j++ )
				System.out.print("\t" + getMat()[i][j]);
			System.out.println("\t\n");
		}
	}

	void checkBoard()
	{
		int k = 0;
		// Principal Diagonal
		for( int i = 0; i < getROW() - 1; i++ )
			if( getMat()[i][i] == getMat()[i + 1][i + 1] && getMat()[i][i] != getDefchar() )
			{
				k++;
				won(k, i);
			}
			else
				break;

		// row
		for( int i = 0; i < getROW(); i++ )
		{
			k = 0;
			for( int c = 0; c < getROW() - 1; c++ )
			{
				if( getMat()[i][c] == getMat()[i][c + 1] && getMat()[i][i] != getDefchar() )
				{
					k++;
					won(k, i);
				}
				else
					break;
			}
		}

		// col
		for( int i = 0; i < getROW(); i++ )
		{
			k = 0;
			for( int c = 0; c < getROW() - 1; c++ )
			{
				if( getMat()[c][i] == getMat()[c + 1][i] && getMat()[i][i] != getDefchar() )
				{
					k++;
					won(k, i);
				}
				else
					break;
			}
		}

		// Second Diagonal
		int j = getROW() - 1;
		k = 0;
		for( int i = 0; i < getROW() - 1; i++ )
		{
			if( getMat()[i][j] == getMat()[i + 1][j - 1] && getMat()[i][j] != getDefchar() )
				k++;
			j--;
			won(k, i);
		}
	}

	void won( int x, int i )
	{
		if( x == getROW() - 1 )
		{
			if( getMat()[i][i] == 'O' )
				System.out.println(Player.getPlayer1() + " won!!! Congrats!!");
			else
				System.out.println(Player.getPlayer2() + " won!!! Congrats!!");
			System.exit(0);
		}
	}

	public static String getOption()
	{
		return option;
	}

	public static void setOption( String option )
	{
		Board.option = option;
	}

	public static char[][] getMat()
	{
		return mat;
	}

	public static void setMat( char mat[][] )
	{
		Board.mat = mat;
	}

	public static char getDefchar()
	{
		return defchar;
	}

	public static void setDefchar( char defchar )
	{
		Board.defchar = defchar;
	}

	public static int getROW()
	{
		return ROW;
	}

	public static void setROW( int rOW )
	{
		ROW = rOW;
	}

}
