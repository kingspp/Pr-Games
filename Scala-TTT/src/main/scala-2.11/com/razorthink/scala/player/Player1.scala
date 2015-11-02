package com.razorthink.scala.player

import com.razorthink.scala.resources.Print


class Player1 (player1Name : String) extends Player{

  val print = new Print;
	playerName = player1Name;
	def getPlayerName : String = return playerName;
	def error : Unit = println("Player 1 Error");
	def getInput:Array[Int] = {
	  var choice = readLine(getPlayerName + "'s chance : ");	  
	  return print.parseInt(choice);
	  
	}
}


