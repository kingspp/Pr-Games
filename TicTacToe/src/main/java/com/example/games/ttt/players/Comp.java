package com.example.games.ttt.players;

import com.example.games.ttt.board.Board;

import java.util.Random;

/**
* Created by Prathyush SP on 1/13/16.
**/

public class Comp extends Player{
	Random rand=new Random();

	public int getInput()
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