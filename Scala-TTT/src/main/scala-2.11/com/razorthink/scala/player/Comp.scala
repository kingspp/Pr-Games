package com.razorthink.scala.player

import com.razorthink.scala.resources.Print
import scala.util.Random
import com.razorthink.scala.ttt.TTT



class Comp (compName : String) extends Player  {

  var main = TTT;
  var board=main.board;
  
  var rand = new Random();
	val print = new Print;
	playerName = compName;
	def getPlayerName : String = return playerName;
	def error : Unit = println("Computer Error");
	def getInput:Array[Int] = {
	  println(playerName + "'s chance : ")
		var x = rand.nextInt(main.getROW) + 0;
		var y = rand.nextInt(main.getROW) + 0;
		if(board.MATRIX.valueAt(x, y) != main.getDefaultSymbol)
		  getInput;
		return print.parseInt(x+ " "+ y)  ;
	}
}