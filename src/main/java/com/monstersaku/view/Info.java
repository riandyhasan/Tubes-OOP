package com.monstersaku.view;

import java.util.List;
import com.monstersaku.moves.*;
import com.monstersaku.monster.Monster;
import com.monstersaku.stats.*;
import com.monstersaku.player.Player;

public class Info {
    public static Info INSTANCE = new Info();

    private Info() {};

    public void ShowMove(List<Move> moves){
        int i = 0;
        for(Move m : moves){
            System.out.printf("%d. %s\n", i+1, m.getName());
            System.out.println("Ammunition: " + (m.getName().equals("Default Move") ? "\u221e" : m.getAmmunitions()));
            i += 1;
        }
        System.out.printf("Choose move: ");
    }

    public void ShowMonster(List<Monster> monsters){
        int i = 0;
        for(Monster m : monsters){
            System.out.printf("%d. %s\n", i+1, m.getName());
            System.out.printf("Current HP: %.2f\n", m.getStats().getHP());
            i += 1;
        }
        System.out.println("");
    }

    public void ShowMonsterInfo(List<Monster> monsters){
        int i = 0;
        for(Monster m : monsters){
            System.out.printf("%d. %s\n", i+1, m.getName());
            System.out.printf("Max HP: %.2f\n", m.getStats().getMaxHP());
            System.out.printf("Current HP: %.2f\n", m.getStats().getHP());
            System.out.printf("Attack: %.2f\n", m.getStats().getAttack());
            System.out.printf("Defense: %.2f\n", m.getStats().getDefense());
            System.out.printf("Special attack: %.2f\n", m.getStats().getSpecialAttack());
            System.out.printf("Special defense: %.2f\n", m.getStats().getSpecialDefense());
            System.out.printf("Speed: %.2f\n", m.getStats().getSpeed());
            i += 1;
        }
        System.out.println("");
    }

    public void ShowTurnInfo(Player player, int round){
        System.out.printf("\n======= ROUND %d =======\n", round);
        System.out.printf("%s current monster: \n", player.getName());
        System.out.println(player.getCurrentMonster().getName());
        System.out.printf("Current HP: %s\n", player.getCurrentMonster().getStats().getHP());
        String condition = player.getCurrentMonster().getCondition().getCondition();
        System.out.printf("Current condition: %s\n", condition);
        System.out.printf("%s another monsters: \n", player.getName());
        int i = 0;
        for(Monster m : player.getMonsters()){
            if(m != player.getCurrentMonster()){
                System.out.printf("%d. %s\n", i+1, m.getName());
                i += 1;
            }
        }
        System.out.println("");
    }

    public void ShowMonsterStats(Monster m){
        System.out.printf("%s\n", m.getName());
        System.out.printf("Max HP: %.2f\n", m.getStats().getMaxHP());
        System.out.printf("Current HP: %.2f\n", m.getStats().getHP());
        System.out.printf("Attack: %.2f\n", m.getStats().getAttack());
        System.out.printf("Defense: %.2f\n", m.getStats().getDefense());
        System.out.printf("Special attack: %.2f\n", m.getStats().getSpecialAttack());
        System.out.printf("Special defense: %.2f\n", m.getStats().getSpecialDefense());
        System.out.printf("Speed: %.2f\n", m.getStats().getSpeed());
        System.out.printf("Condition: %s\n", m.getCondition().getCondition());
    }

    public void ShowMonsterBuff(Monster m){
        System.out.printf("%s\n", m.getName());
        System.out.printf("Max HP: %.2f\n", m.getStats().getMaxHP());
        System.out.printf("Current HP: %.2f -> %.2f\n", m.getStats().getHP(), m.getInitialStats().getHP() );
        System.out.printf("Attack: %.2f -> %.2f\n", m.getStats().getAttack(), m.getInitialStats().getAttack());
        System.out.printf("Defense: %.2f -> %.2f\n", m.getStats().getDefense(), m.getInitialStats().getDefense());
        System.out.printf("Special attack: %.2f -> %.2f\n", m.getStats().getSpecialAttack(), m.getInitialStats().getSpecialAttack());
        System.out.printf("Special defense: %.2f -> %.2f\n", m.getStats().getSpecialDefense(), m.getInitialStats().getSpecialDefense());
        System.out.printf("Speed: %.2f -> %.2f\n", m.getStats().getSpeed(), m.getInitialStats().getSpeed());
        System.out.printf("Condition: %s\n", m.getCondition().getCondition());
    }

    public void ShowWinner(Player winner){
        System.out.println("The winner of the game is:");
        System.out.printf("============== %s ==============", winner.getName());
        System.exit(0);
    }

}
