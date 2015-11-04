package com.razorthink.scala.ttt

import java.util.HashSet

import com.razorthink.scala.player.AI
import com.razorthink.scala.player.Comp
import com.razorthink.scala.player.Player
import com.razorthink.scala.player.Player1
import com.razorthink.scala.player.Player2
import com.razorthink.scala.resources.BoardState
import com.razorthink.scala.resources.BoardState
import com.razorthink.scala.resources.BoardState
import com.razorthink.scala.resources.Resources
import com.razorthink.ttt.board.Board

import breeze.linalg.DenseMatrix

object TTT {

	private final var ROW = 3;
	private final var COL = ROW;
	private final var player1Symbol = 0;
	private final var player2Symbol = 1;
	private final var defaultSymbol = 9;
	final var epoch = 5;
	final var isTraining = true;
	final var debug = isTraining;




	val QSet = new HashSet[BoardState]();

	def getROW : Int = return ROW;
	def getCol : Int = return COL;
	def getDefaultSymbol : Int = return defaultSymbol;

	final var player1 = new Comp("Comp1 Playing");
	final var player2 = new Comp("Comp2 Playing");
	
	var boardState = "";

	var board = new Board(ROW, COL);

	def play(playerOne : Player, playerTwo: Player){		
		board.MATRIX = new DenseMatrix[Int](ROW,COL);
		board.initBoard	
		val player1 = playerOne;
		val player2 = playerTwo;
		var chance=0;
		while(chance < ROW*COL){
			boardState = board.MATRIX.toString().replace(" ", "").replace("\n","");
			var action = "";
			if(chance%2 ==0){
				var input = player1.getInput;
				if(board.MATRIX.valueAt(input(0), input(1)) == defaultSymbol)
					board.MATRIX.update(input(0), input(1), player1Symbol);
				else {
					player1.error ;
					chance-=1;	  
				}
				action = String.valueOf(input(0)) + String.valueOf(input(1));
				board.checkBoard
			}
			else{
				var input = player2.getInput;
				if(board.MATRIX.valueAt(input(0), input(1)) == defaultSymbol)
					board.MATRIX.update(input(0), input(1), player2Symbol);
				else {
					player2.error ;
					chance-=1;	  
				}		
				action = String.valueOf(input(0)) + String.valueOf(input(1));
				board.checkBoard

			}
			chance+=1;
			if(debug)
				board.printBoard;
			var state = BoardState(boardState,action,board.getReward);
			QSet.add(state);
			
		}
		board.draw+=1;
		
	}


	def main(args: Array[String]): Unit = {
			println("Welcome to Tic Tac Toe");
			if(debug)
				board.printBoard;			
			
			
			
			
			if(isTraining)
			  play(new Comp("Player 1"), new Comp("Player 2"))
			 else
			   play(new Player1("King"), new Comp("Player 2"))
	
	
	}










}
