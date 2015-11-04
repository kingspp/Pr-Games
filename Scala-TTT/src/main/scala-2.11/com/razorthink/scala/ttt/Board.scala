package com.razorthink.ttt.board

import com.razorthink.scala.resources.BoardState
import com.razorthink.scala.resources.Print
import com.razorthink.scala.ttt.TTT
import breeze.linalg.DenseMatrix
import com.razorthink.scala.resources.BoardState
import com.razorthink.scala.resources.BoardState
import com.razorthink.scala.player.Comp
import com.razorthink.scala.resources.Resources
import com.razorthink.scala.resources.BoardState
import java.util.ArrayList


class Board (ROW: Int, COL: Int) {

	var main = TTT;


	private var reward =0 ;

	var player1WinCount = 0;
	var player2WinCount = 0;
	var draw=0;
	var MATRIX = DenseMatrix.fill(main.getROW, main.getCol)(main.getDefaultSymbol);
	private var gameStatus = "";
	var epochCount=0;
	val print = new Print();


	def getFreeCells: ArrayList[String] = {
		var id=0;
		var r=0; var c=0;
		var result = new ArrayList[String];
		for(r <- 0 to main.getROW -1)
			for(c <- 0 to main.getCol -1)
				if(MATRIX.valueAt(r, c) == main.getDefaultSymbol){
					result.add(r.toString+c.toString)
				}
		return result;	  
	}

	def initBoard{
		var r=0; var c=0;
		for(r <- 0 to main.getROW -1)
			for(c <- 0 to main.getCol -1)
				MATRIX.update(r, c, main.getDefaultSymbol);
	}
	def printBoard{
		print.printDenseMatrix(MATRIX)
	}

	def checkBoard{
		ifWon(getRowInString(MATRIX));
		ifWon(getColInString(MATRIX));
		ifWon(getpDiagInString(MATRIX));
		ifWon(getsDiagInString(MATRIX));
	}

	def ifWon(data: String) {
		var count =0;
		var i=0;
		while(i < data.length() - 1){
			if(data.charAt(i) == data.charAt(i+1) && data.charAt(i) != ('0'+main.getDefaultSymbol)){
				count+=1;
				if(count==2){
					if(data.charAt(i) == '0'){
						if(main.debug)
							println("Player 1  won");
						player1WinCount+=1;
						reward = 100;

					}
					else if(data.charAt(i) == '1'){
						if(main.debug)
							println("Player 2 won");
						player2WinCount+=1;
						reward = -100;
					}
					else{
						if(main.debug)
							println("It is a Draw");
					}

					if(!main.isTraining)
						System.exit(0);
				}
			}
			i+=1;
		}
	}

	def getRowInString (data: DenseMatrix[Int] ) : String = {
			var rowString = "";
			var c=0;
			var r=0;		
			for( r <- 0 to ROW-1)
				for(c <- 0 to COL-1)
					rowString += MATRIX.valueAt(r,c);          
						return rowString;
	}

	def getColInString (data: DenseMatrix[Int]) : String = {
			var colString = "";	  
			var r=0;
			var c=0;
			for(c <- 0 to ROW-1)
				for(r <- 0 to COL-1)
					colString+= MATRIX.valueAt(r,c);
						return colString;
	}

	def getpDiagInString(data : DenseMatrix[Int]) : String = {
			var pDiagString = "";
			var r=0;
			var c=0;
			for(r <- 0 to ROW-1)
				pDiagString+= MATRIX.valueAt(r,r);	  
					return pDiagString;
	}

	def getsDiagInString(data: DenseMatrix[Int]) : String = {
			var sDiagString = "";
			var j = ROW-1;
			var r=0;
			for(r <- 0 to ROW-1){
				sDiagString+= MATRIX.valueAt(r,j)
						j-=1;
			}
			return sDiagString;	  
	}

	def getReward: Int = {
			/*
			if(gameStatus.equals("win"))
				return 100;
			else if(gameStatus.equals("draw"))
				return 0;
			else if(gameStatus.equals("loose"))
				return -100;
			else
				return 10;
			 * */

			return reward
	}





}