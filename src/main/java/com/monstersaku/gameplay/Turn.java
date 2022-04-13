package com.monstersaku.gameplay;

import com.monstersaku.view.*;
import com.monstersaku.player.Player;

public class Turn {
    private boolean isGameOver;
    private Player player1, player2;
    
    public Turn(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.isGameOver = false;
    }

    public boolean gameOver() {
        return isGameOver;
    }

    public void playerTurn(Player player) {
        while(player.getIsTurn()){
            System.out.println("Player turn");
            player.setIsTurn(false);
        }
    }

    public void resetTurn(){
        this.player1.setIsTurn(true);
        this.player2.setIsTurn(true);
    }
}
