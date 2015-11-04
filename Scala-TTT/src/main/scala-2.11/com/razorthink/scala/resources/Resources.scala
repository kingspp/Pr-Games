package com.razorthink.scala.resources


import com.razorthink.scala.ttt.TTT
import java.io.File
import java.io.PrintStream
import java.io.FileOutputStream
import java.io.PrintWriter
import java.io.OutputStreamWriter
import scala.collection.mutable.HashSet
import scala.io.Source

class Resources {


	val main = TTT;
	val board=main.board;

	def printToFile(f: java.io.File)(op: java.io.PrintWriter => Unit) {
		val p = new java.io.PrintWriter(f)
		try { op(p) } finally { p.close() }
	}

	def exitGame{	
		println("Player 1 won "+ board.player1WinCount);
		println("Player 2 won "+ board.player2WinCount);
		println("Draw "+ board.draw);
		if(main.isTraining){
			var hashSetIterator = main.QSet.iterator();
			val writer= new PrintWriter( new OutputStreamWriter( new FileOutputStream( "HashSet.txt"), "UTF-8" )); 
			while(hashSetIterator.hasNext()) {
				var o = hashSetIterator.next();
				writer.println(o);
			}
		}
		System.exit(0);
	}

	def readToHashSet(fileName: String) : HashSet[BoardState] = {
			var QSet = new HashSet[BoardState]();


			for (line <- Source.fromFile(fileName).getLines()) {
				var stringData = line.replace("BoardState(", "").replace(")", "");
				var data = stringData.split(",");
				QSet.add(new BoardState(data(0),data(1),Integer.parseInt(data(2))));
			}

			return QSet;

	}
}