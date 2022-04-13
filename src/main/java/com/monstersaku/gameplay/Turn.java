package com.monstersaku.gameplay;

import java.util.*;
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

    public void playerTurn(Player player, Scanner scanner) {
        System.out.printf("\n====== %s turn ======\n", player.getName());
        while(player.getIsTurn()){
            TurnMenu.INSTANCE.showMessage();
            int choice = scanner.nextInt();
            if(choice == 1){
                System.out.println("\n" + player.getCurrentMonster().getName() + "'s moves: ");
                Info.INSTANCE.ShowMove(player.getCurrentMonster().getMoves());
            }else if(choice == 2){
                System.out.println("Current monster: " + player.getCurrentMonster().getName());
                System.out.println("Choose monsters to switch: ");
                Info.INSTANCE.ShowMonsterInfo(player.getMonsters());
                System.out.printf("Monster number: ");
                int choosenMonster = scanner.nextInt();
                player.setCurrentMonster(player.getMonsters().get(choosenMonster-1));
                System.out.println(player.getName() + " switched monster to " + player.getCurrentMonster().getName());
                player.setIsTurn(false);
            }else if(choice == 3){
                System.out.println("\n" + player.getName() + "'s monsters: ");
                Info.INSTANCE.ShowMonsterInfo(player.getMonsters());
            }
        }
    }

    public void resetTurn(){
        this.player1.setIsTurn(true);
        this.player2.setIsTurn(true);
    }
}
