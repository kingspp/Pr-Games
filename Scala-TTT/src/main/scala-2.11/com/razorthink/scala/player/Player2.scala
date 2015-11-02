package com.razorthink.scala.player

import com.razorthink.scala.resources.Print

class Player2(player2Name : String) extends Player {

	val print = new Print;
	playerName = player2Name;
	def getPlayerName : String = return playerName;
	def error : Unit = println("Player 2 Error");
	def getInput:Array[Int] = {
		var choice = readLine(getPlayerName + "'s chance: ");
		return print.parseInt(choice)  ;
	}
}