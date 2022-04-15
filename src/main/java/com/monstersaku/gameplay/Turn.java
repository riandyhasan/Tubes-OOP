package com.monstersaku.gameplay;

import java.util.*;
import com.monstersaku.view.*;
import com.monstersaku.player.Player;
import com.monstersaku.moves.*;
import com.monstersaku.monster.*;
import com.monstersaku.stats.*;

public class Turn {
    private boolean isGameOver;
    private Player player1, player2;
    private int round;
    private Player winner;
    
    public Turn(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.isGameOver = false;
        this.round = 1;
    }

    public boolean gameOver() {
        return isGameOver;
    }

    public void playerTurn(Player player,Player opponent, Scanner scanner, TurnMove pmove) {
        System.out.printf("\n====== %s turn ======\n", player.getName());
        monsterCondition(player.getCurrentMonster());
        if(player.getCurrentMonster().getStatus() == Status.DEATH){
            player.getMonsters().remove(player.getCurrentMonster());
            if(player.getMonsters().size() < 1){
                System.out.println(player.getName() + " has no monsters left");
                this.isGameOver = true;
                player.setIsTurn(false);
                this.winner = opponent;
            }else{
                changeMonster(player, scanner);
            }
        }
        while(player.getIsTurn()){
            try{
                TurnMenu.INSTANCE.showMessage();
                int choice = scanner.nextInt();
                if(choice == 1){
                    if(player.getCurrentMonster().getCondition().getSleepingTime() > 0){
                        System.out.printf("%s in slept, %s cannot move\n!", player.getCurrentMonster().getName(), player.getCurrentMonster().getName());
                    }else{
                        chooseMoves(player, pmove, scanner);
                    }
                }else if(choice == 2){
                    System.out.println("Current monster: " + player.getCurrentMonster().getName());
                    changeMonster(player, scanner);
                    pmove.setMove(null);
                    player.setIsTurn(false);
                }else if(choice == 3){
                    System.out.println("\n" + player.getName() + "'s monsters: ");
                    Info.INSTANCE.ShowMonsterInfo(player.getMonsters());
                    System.out.println("\n" + opponent.getName() + "'s monsters: ");
                    Info.INSTANCE.ShowMonsterInfo(opponent.getMonsters());
                }else if(choice == 4){
                    System.out.printf("\n======= ROUND %d =======\n", round);
                    Info.INSTANCE.ShowTurnInfo(player);
                    Info.INSTANCE.ShowTurnInfo(opponent);
                }else if(choice == 5){
                    Help.INSTANCE.showMessage();
                }else if(choice == 6){
                    System.out.println("Out from game! Bye-bye.");
                    System.exit(0);
                }
                else{
                    throw new Exception("Invalid input! Input between 1-6"); 
                }
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void resetTurn(){
        this.player1.setIsTurn(true);
        this.player2.setIsTurn(true);
        if(this.player1.getCurrentMonster().getCondition().getCondition().equals("SLEEP")){
            this.player1.getCurrentMonster().getCondition().setSleepingTime(this.player1.getCurrentMonster().getCondition().getSleepingTime()-1);

        }else if(this.player2.getCurrentMonster().getCondition().getCondition().equals("SLEEP")){
            this.player2.getCurrentMonster().getCondition().setSleepingTime(this.player2.getCurrentMonster().getCondition().getSleepingTime()-1);       
        }
    }

    public void nextRound(){
        this.round += 1;
    }

    public Player getWinner(){
        return winner;
    }
    

    public void moveTurn(TurnMove[] pmoves, Scanner scanner){
        Move mv1 = pmoves[0].getMove();
        Move mv2 = pmoves[1].getMove();
        Player p1 = pmoves[0].getPlayer();
        Player p2 = pmoves[1].getPlayer();
        System.out.println("\n======== Move Log =======");
        if(mv1 != null && mv2 != null){
            if(mv1.getPriority() > mv2.getPriority()){
                player1ThenPlayer2(p1, p2, mv1, mv2, scanner);
            }else if(mv1.getPriority() < mv2.getPriority()){
                player2ThenPlayer1(p1, p2, mv1, mv2, scanner);
            }else{
                if(p1.getCurrentMonster().getStats().getSpeed() > p2.getCurrentMonster().getStats().getSpeed()){
                    player1ThenPlayer2(p1, p2, mv1, mv2, scanner);
                }else if(p1.getCurrentMonster().getStats().getSpeed() < p2.getCurrentMonster().getStats().getSpeed()){
                    player2ThenPlayer1(p1, p2, mv1, mv2, scanner);
                }else{
                    int turn = (int)(1.0 * Math.random());
                    if(turn == 1){
                        player1ThenPlayer2(p1, p2, mv1, mv2, scanner);
                    }else{
                        player2ThenPlayer1(p1, p2, mv1, mv2, scanner);
                    }

                }
            } 
        }else if(mv1 != null && mv2 == null){
            if(mv1.getTarget() == Target.ENEMY){
                System.out.printf("%s's %s do %s to %s's %s\n", p1.getName(), p1.getCurrentMonster().getName(), mv1.getName(), p2.getName(), p2.getCurrentMonster().getName());
            }else{
                System.out.printf("%s's %s do %s to itself\n", p1.getName(), p1.getCurrentMonster().getName(), mv1.getName());
            }
            mv1.doMove(p1.getCurrentMonster(),p2.getCurrentMonster());
        }
        else if(mv1 == null && mv2 != null){
            if(mv2.getTarget() == Target.ENEMY){
                System.out.printf("%s's %s do %s to %s's %s\n", p2.getName(), p2.getCurrentMonster().getName(), mv2.getName(), p1.getName(), p1.getCurrentMonster().getName());
            }else{
                System.out.printf("%s's %s do %s to itself\n", p2.getName(), p2.getCurrentMonster().getName(), mv2.getName());
            }
            mv2.doMove(p2.getCurrentMonster(),p1.getCurrentMonster());
        }else {}
    }

    public void monsterCondition(Monster m){
        String condition = m.getCondition().getCondition();
        if(condition.equals("BURN")){
            System.out.printf("%s has BURN condition, %s will take a damage!\n", m.getName(), m.getName());
            double burnDamage = m.getStats().getMaxHP() * 1/8;
            System.out.printf("%s taken %.2f damage\n", m.getName(), burnDamage);
            m.moveDamage(burnDamage);
            if(m.getStatus() == Status.DEATH){
                System.out.printf("%s is dead :(\n", m.getName());
            }
        }else if(condition.equals("POISON")){
            System.out.printf("%s has POISON condition, %s will take a damage!\n", m.getName(), m.getName());
            double poisonDamage = m.getStats().getMaxHP() * 1/16;
            System.out.printf("%s taken %.2f damage\n", m.getName(), poisonDamage);
            m.moveDamage(poisonDamage);
            if(m.getStatus() == Status.DEATH){
                System.out.printf("%s is dead :(\n", m.getName());
            }
        }else if(condition.equals("SLEEP")){
            if(m.getCondition().getSleepingTime() > 0){
                System.out.printf("%s has SLEEP condition, %s cannot move\n!", m.getName(), m.getName());
            }else{
                m.getCondition().setCondition(Condition.NORMAL);
            }
        }else if(condition.equals("PARALYZE")){
            System.out.printf("%s has PARALYZE condition, %s's speed reduced 50%!\n", m.getName(), m.getName());
            Random rand = new Random();
            boolean isSleep = rand.nextInt(100) < 25;
            if(isSleep){
                System.out.printf("%s slept because of PARALYZE, %s cannot move!\n", m.getName(), m.getName());
                m.getCondition().setSleepingTime(1);
            }
        }
    }

    public void player1ThenPlayer2(Player p1, Player p2, Move mv1, Move mv2, Scanner scanner) {
        if(mv1.getTarget() == Target.ENEMY){
            System.out.printf("%s's %s do %s to %s's %s\n", p1.getName(), p1.getCurrentMonster().getName(), mv1.getName(), p2.getName(), p2.getCurrentMonster().getName());
        }else{
            System.out.printf("%s's %s do %s to itself\n", p1.getName(), p1.getCurrentMonster().getName(), mv1.getName());
        }
        mv1.doMove(p1.getCurrentMonster(),p2.getCurrentMonster());
        if(p2.getCurrentMonster().getStatus() == Status.DEATH){
            System.out.printf("%s is dead :(\n", p2.getCurrentMonster().getName());
            player2.getMonsters().remove(player2.getCurrentMonster());
            if(player2.getMonsters().size() < 1){
                System.out.println(player2.getName() + " has no monsters left");
                this.isGameOver = true;
                player2.setIsTurn(false);
                this.winner = player1;
            }else{
                changeMonster(player2, scanner);
            }
        }else{
            if(mv2.getTarget() == Target.ENEMY){
                System.out.printf("%s's %s do %s to %s's %s\n", p2.getName(), p2.getCurrentMonster().getName(), mv2.getName(), p1.getName(), p1.getCurrentMonster().getName());
            }else{
                System.out.printf("%s's %s do %s to itself\n", p2.getName(), p2.getCurrentMonster().getName(), mv2.getName());
            }
            mv2.doMove(p2.getCurrentMonster(),p1.getCurrentMonster());
            if(p1.getCurrentMonster().getStatus() == Status.DEATH){
                System.out.printf("%s is dead :(\n", p1.getCurrentMonster().getName());
                player1.getMonsters().remove(player1.getCurrentMonster());
                if(player1.getMonsters().size() < 1){
                    System.out.println(player1.getName() + " has no monsters left");
                    this.isGameOver = true;
                    player1.setIsTurn(false);
                    this.winner = player1;
                }else{
                    changeMonster(player1, scanner);
                }
            }
        }
    }

    public void player2ThenPlayer1(Player p1, Player p2, Move mv1, Move mv2, Scanner scanner) {
        if(mv2.getTarget() == Target.ENEMY){
            System.out.printf("%s's %s do %s to %s's %s\n", p2.getName(), p2.getCurrentMonster().getName(), mv2.getName(), p1.getName(), p1.getCurrentMonster().getName());
        }else{
            System.out.printf("%s's %s do %s to itself\n", p2.getName(), p2.getCurrentMonster().getName(), mv2.getName());
        }
        mv2.doMove(p2.getCurrentMonster(),p1.getCurrentMonster());
        if(p1.getCurrentMonster().getStatus() == Status.DEATH){
            System.out.printf("%s is dead :(\n", p1.getCurrentMonster().getName());
            player1.getMonsters().remove(player1.getCurrentMonster());
            if(player1.getMonsters().size() < 1){
                System.out.println(player1.getName() + " has no monsters left");
                this.isGameOver = true;
                player1.setIsTurn(false);
                this.winner = player2;
            }else{
                changeMonster(player1, scanner);
            }
        }else{
            if(mv1.getTarget() == Target.ENEMY){
                System.out.printf("%s's %s do %s to %s's %s\n", p1.getName(), p1.getCurrentMonster().getName(), mv1.getName(), p2.getName(), p2.getCurrentMonster().getName());
            }else{
                System.out.printf("%s's %s do %s to itself\n", p1.getName(), p1.getCurrentMonster().getName(), mv1.getName());
            }
            mv1.doMove(p1.getCurrentMonster(),p2.getCurrentMonster());
            if(p2.getCurrentMonster().getStatus() == Status.DEATH){
                System.out.printf("%s is dead :(\n", p2.getCurrentMonster().getName());
                player2.getMonsters().remove(player2.getCurrentMonster());
                if(player2.getMonsters().size() < 1){
                    System.out.println(player2.getName() + " has no monsters left");
                    this.isGameOver = true;
                    player2.setIsTurn(false);
                    this.winner = player1;
                }else{
                    changeMonster(player2, scanner);
                }
            }
        }
    }

    public void changeMonster(Player player, Scanner scanner) {
        boolean valid = false;
        while(!valid){
            try{
                int max_choice = player.getMonsters().size();
                System.out.println("Choose monsters to switch: ");
                Info.INSTANCE.ShowMonster(player.getMonsters());
                System.out.printf("Monster number: ");
                int choosenMonster = scanner.nextInt();
                if(choosenMonster > 0 && choosenMonster <= max_choice){
                    player.setCurrentMonster(player.getMonsters().get(choosenMonster-1));
                    System.out.println(player.getName() + " switched monster to " + player.getCurrentMonster().getName());
                    valid = true;
                }else{
                    throw new Exception("Invalid input! Input between 1-" + max_choice); 
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void chooseMoves(Player player, TurnMove pmove, Scanner scanner){
        boolean valid = false;
        while(!valid){
            try{
                int max_choice = player.getCurrentMonster().getMoves().size();
                System.out.println("\n" + player.getCurrentMonster().getName() + "'s moves: ");
                Info.INSTANCE.ShowMove(player.getCurrentMonster().getMoves());
                int choosenMove = scanner.nextInt();
                if(choosenMove > 0 && choosenMove <= max_choice){
                    pmove.setMove(player.getCurrentMonster().getMoves().get(choosenMove-1));
                    System.out.printf("Use %s from %s\n",player.getCurrentMonster().getMoves().get(choosenMove-1).getName(), player.getCurrentMonster().getName());
                    player.setIsTurn(false);
                    valid = true;
                }else{
                    throw new Exception("Invalid input! Input between 1-" + max_choice); 
                }
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
