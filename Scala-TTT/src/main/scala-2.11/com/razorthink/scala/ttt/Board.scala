package com.razorthink.ttt.board

import com.razorthink.scala.resources.BoardState
import com.razorthink.scala.resources.Print
import com.razorthink.scala.ttt.TTT
import breeze.linalg.DenseMatrix
import com.razorthink.scala.resources.BoardState
import com.razorthink.scala.resources.BoardState

class Board (ROW: Integer, COL: Integer) {

	var main = TTT;
	private final var player1 = 0;
	private final var player2 = 1;
	private final var default = 9;
	private var reward =0 ;
	val MATRIX = DenseMatrix.fill(ROW, COL)(default); 
	private var gameStatus = "";

	val print = new Print();
	def printBoard(){
		print.printDenseMatrix(MATRIX)
	}
	
	def checkBoard{
	  
	}
	
	def getReward: Int = {
	  if(gameStatus.equals("win"))
	    return 100;
	  else if(gameStatus.equals("draw"))
	    return 0;
	  else if(gameStatus.equals("loose"))
	    return -100;
	  else
	    return 10;
	}
	
	



}