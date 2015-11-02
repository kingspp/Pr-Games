package com.razorthink.scala.player

/*
 * Player 1 -> Human Player 1, AI Player
 * Player 2 -> Human Player 2, Comp Player
 */

trait Player {
	
  var playerName : String =  _;  
  def getPlayerName : String;  
	def error:Unit;
	def getInput: Array[Int];
}

