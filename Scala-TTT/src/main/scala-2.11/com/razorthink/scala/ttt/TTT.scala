package com.razorthink.scala.ttt

import java.util.HashSet
import com.razorthink.scala.player.Player
import com.razorthink.scala.player.Player1
import com.razorthink.scala.player.Player2
import com.razorthink.scala.resources.BoardState
import com.razorthink.scala.resources.BoardState
import com.razorthink.ttt.board.Board
import com.razorthink.scala.player.Comp
import com.sun.org.apache.xalan.internal.xsltc.compiler.ValueOf
import com.razorthink.scala.resources.BoardState

object TTT {

	private final var ROW = 3;
	private final var COL = ROW;
	private final var player1Symbol = 0;
	private final var player2Symbol = 1;
	private final var defaultSymbol = 9;
	private final var isTraining = false;

	
	val QSet = new HashSet[BoardState]();

	def getROW : Int = return ROW;
	def getCol : Int = return COL;
	def getDefaultSymbol : Int = return defaultSymbol;

	val board = new Board(ROW, COL);


	def main(args: Array[String]): Unit = {
			println("Welcome to Tic Tac Toe");
			
			board.printBoard();
			val player1 = new Player1(readLine("What's player 1 name? "));
			//val player2 = new Player2(readLine("What's player 2 name? "));
			val player2 = new Comp(readLine("Whats computer name?"));

			var chance=0
					while(chance < ROW*COL){
					  var boardState = board.MATRIX.toString().replace(" ", "").replace("\n","");
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
							
						}
						chance+=1;					
						board.printBoard()
						
						QSet.add(new BoardState(boardState,action,board.getReward));
					}









	}
}