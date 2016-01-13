package com.example.games.ttt.players;

import com.example.games.ttt.board.Board;

/**
 * Created by Prathyush SP on 1/13/16.
 **/
public class Player {
	public static String player1, player2;

	public void printPlayer() {
		System.out.println("Player 1: " + player1);
		System.out.println("Player 2: " + player2);
	}

	public void getName(){}

	public int getInput(){	return 0;}

	public void error()
	{
		System.out.println("Error! Please try again");
	}

	public static int parseInt(int x)
	{
		x=Integer.parseInt(Board.splits[x]);
		return x;
	}
}