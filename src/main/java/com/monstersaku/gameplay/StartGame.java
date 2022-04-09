package com.monstersaku.gameplay;

import java.util.Scanner;
import com.monstersaku.player.Player;

public class StartGame {
    private Turn turn;

    public StartGame(){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.print("Masukkan nama pemain pertama: ");
            String name1 = scanner.nextLine();
            Player player1 = new Player(name1, null);
            System.out.print("Masukkan nama pemain kedua: ");
            String name2 = scanner.nextLine();
            Player player2 = new Player(name2, null);
            this.turn = new Turn(player1, player2);
            while(!this.turn.gameOver()){
                this.turn.playerTurn(player1);
                this.turn.playerTurn(player2);
                this.turn.resetTurn();
            }
        }catch(Exception e){

        }
    }
}
