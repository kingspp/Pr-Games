package com.razorthink.scala.player

import com.razorthink.scala.resources.Resources
import com.razorthink.scala.resources.Print
import com.razorthink.scala.ttt.TTT

class AI extends Player{
  var main = TTT;
	var resources = new Resources;
	var QSet = resources.readToHashSet("HashSet.txt");
	val print = new Print;
	playerName = "AI";
	def getPlayerName : String = return playerName;
	def error : Unit = println("AI Error");
	
	def getInput:Array[Int] = {
	  if(main.debug) println("AI Chance");
	  var choice = new Array[Int](2);
	  var iterator = QSet.iterator;
	  var foundState = false;
	  while(iterator.hasNext) {
	    var bState = iterator.next;
	    if(bState.state.equals(main.boardState)){
	      foundState = true;
	      choice(0) = Character.getNumericValue(bState.action.charAt(0));
	      choice(1) = Character.getNumericValue(bState.action.charAt(1)); 
	       return choice;
	    }		
		}	
	  if(!foundState){
	    println("Could not find the specified state :"+ main.boardState);
	    //resources.exitGame
	  }
		return null;
	}
}