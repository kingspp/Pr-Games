package com.example.games.ttt.board;

import com.example.games.ttt.Play;
import com.example.games.ttt.players.Player;

/**
 * Created by Prathyush SP on 1/13/16.
 */
public class Board {
    public static int ROW = 3, COL = 3;
    public static char mat[][] = new char[ROW][COL];
    public static String option;
    public static String[] splits;
    public static char defchar = '.';


    public void initilizeBoard() {
        for (int i = 0; i < ROW; i++)
            for (int j = 0; j < COL; j++)
                mat[i][j] = defchar;
    }

    public void printBoard() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++)
                System.out.print("\t" + mat[i][j]);
            System.out.println("\t\n");
        }
    }

    public void checkBoard() {
        int k = 0;
        // Principal Diagonal
        for (int i = 0; i < ROW - 1; i++)
            if (mat[i][i] == mat[i + 1][i + 1] && mat[i][i] != defchar) {
                k++;
                won(k, i);
            } else
                break;

        // row
        for (int i = 0; i < ROW; i++) {
            k = 0;
            for (int c = 0; c < ROW - 1; c++) {
                if (mat[i][c] == mat[i][c + 1] && mat[i][i] != defchar) {
                    k++;
                    won(k, i);
                } else
                    break;
            }
        }

        // col
        for (int i = 0; i < ROW; i++) {
            k = 0;
            for (int c = 0; c < ROW - 1; c++) {
                if (mat[c][i] == mat[c + 1][i] && mat[i][i] != defchar) {
                    k++;
                    won(k, i);
                } else
                    break;
            }
        }

        // Second Diagonal
        int j = 2;
        k = 0;
        for (int i = 0; i < ROW - 1; i++) {
            if (mat[i][j] == mat[i + 1][j - 1] && mat[i][j] != defchar)
                k++;
            j--;
            won(k, i);
        }
    }

    public void won(int x, int i) {
        if (x == 2) {
            if (mat[i][i] == 'O')
                System.out.println(Player.player1 + " won!!! Congrats!!");
            else
                System.out.println(Player.player2 + " won!!! Congrats!!");
            Play.scan.close();
            System.exit(0);
        }
    }
}
