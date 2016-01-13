package com.example.games.ttt;

import com.example.games.ttt.board.Board;
import com.example.games.ttt.players.Comp;
import com.example.games.ttt.players.Player;
import com.example.games.ttt.players.Player1;
import com.example.games.ttt.players.Player2;

import java.util.Scanner;

/**
 * Created by Prathyush SP on 1/13/16.
 */
public class Play {

    public static Scanner scan=new Scanner(System.in);

    public static void main(String v[]) {
        System.out.println("Welcome to Tic Tac Toe Game\n");
        System.out.println("Select among:");
        System.out.println("1.Player vs Player");
        System.out.println("2.Player vs Computer");
        System.out.print("Enter your Choice: ");
        int ch=scan.nextInt();
        Board mat = new Board();
        Player1 player1=new Player1();
        Player2 player2=new Player2();
        Comp player=new Comp();
        System.out.println("Lets Start the game...\n");
        mat.initilizeBoard();

        switch(ch){
            case 1:
                player1.getName();
                player2.getName();
                System.out.println(Player.player1 + " vs "+ Player.player2);
                mat.printBoard();
                for (int chance = 0; chance < (Board.ROW * Board.COL); chance++) {
                    if (chance % 2 == 0) {
                        if(player1.getInput()==-1)
                            chance--;
                    }
                    else {
                        if(player2.getInput()==-1)
                            chance--;
                    }
                    mat.printBoard();
                    mat.checkBoard();
                }
                break;

            case 2:
                player1.getName();
                Player.player2="Comp";
                System.out.println(Player.player1 + " vs "+ Player.player2);
                mat.printBoard();
                for (int chance = 0; chance < (Board.ROW * Board.COL); chance++) {
                    if (chance % 2 == 0) {
                        if(player1.getInput()==-1)
                            chance--;
                    }
                    else {
                        if(player.getInput()==-1)
                            chance--;
                    }
                    mat.printBoard();
                    mat.checkBoard();
                }
                break;
        }
        scan.close();
    }
}
