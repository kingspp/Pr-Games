package com.razorthink.scala.player

import com.razorthink.scala.resources.Print
import com.razorthink.scala.ttt.TTT
import scala.util.Random
import java.util.Arrays

class IntelliComp extends Player {

	val main = TTT;
	val rand = Random;
	val board = main.board;
	val print = new Print;
	playerName = "Intelli Comp";
	
			def getPlayerName : String = return playerName;
	def error : Unit = println("Intelli Comp Error");
	def getInput:Array[Int] = {

		if(main.debug){
			println(playerName + "'s chance : ")
		}

		var rowString = board.getRowInString(board.MATRIX);
		var colString = board.getColInString(board.MATRIX);
		var pDiagString = board.getpDiagInString(board.MATRIX);
		var sDiagString = board.getsDiagInString(board.MATRIX);
		
		val intel = intelliMove(rowString);
		if(intel == null){
			var freeCells = board.getFreeCells;
			var r = rand.nextInt(freeCells.size()) + 0;
			var rc = freeCells.get(r);
			return print.parseInt(rc.charAt(0).toString()+ " "+ rc.charAt(1).toString());
		}
		else{
		  println(Arrays.toString(intel));
		  return intel;
		}
		
		

	}

	//To DO
	//currently static for 3x3
	def intelliMove (data:String) : Array[Int] ={
		var result = new Array[Int](2);
		var count = 0;
		var i=0;
		var r=0;
		while(i < data.length() - 1){
			var j=i;
			for(j <- j to j+3){
				if(data.charAt(i) == data.charAt(i+1) && data.charAt(i) != ('0'+main.getDefaultSymbol)){				
					  result(0)= r;
					  result(1)= i+2;
					  return result;					
				}
			}
			i+=3;
			r+=1;
		}

		return null;
	}
}