package com.razorthink.scala.player

import com.razorthink.scala.resources.Print
import scala.util.Random
import com.razorthink.scala.ttt.TTT
import com.razorthink.scala.resources.Resources



class Comp (compName : String) extends Player  {

	var main = TTT;
	var board =  main.board;
	var rand = new Random();
	val print = new Print;
	playerName = compName;
	def getPlayerName : String = return playerName;
	def error : Unit = if(main.debug)println("Computer Error");
	def getInput:Array[Int] = {
			if(main.debug){
				println(playerName + "'s chance : ")
			}
			var freeCells = board.getFreeCells;
			var r = rand.nextInt(freeCells.size()) + 0;
			var rc = freeCells.get(r);
			return print.parseInt(rc.charAt(0).toString()+ " "+ rc.charAt(1).toString());
	}
}