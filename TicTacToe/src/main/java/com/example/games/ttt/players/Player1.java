package com.example.games.ttt.players;

import com.example.games.ttt.Play;
import com.example.games.ttt.board.Board;

import java.util.Scanner;

/**
 * Created by Prathyush SP on 1/13/16.
 **/
public class Player1 extends Player{

    private static final Scanner scan = new Scanner(System.in);

	public void getName()
	{
		System.out.print("Enter the name of Player 1: ");
		player1 = Play.scan.next();
	}

	public int getInput()
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