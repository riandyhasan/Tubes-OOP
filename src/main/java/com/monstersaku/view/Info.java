package com.monstersaku.view;

import java.util.List;
import com.monstersaku.moves.*;
import com.monstersaku.monster.Monster;

public class Info {
    public static Info INSTANCE = new Info();

    public Info() {};

    public void ShowMove(List<Move> moves){
        int i = 0;
        for(Move m : moves){
            System.out.printf("%d. %s\n", i+1, m.getName());
            System.out.println("Ammunition: " + (m.getAmmunitions() == Integer.MAX_VALUE ? "\u221e" : m.getAmmunitions()));
            i += 1;
        }
    }

    public void ShowMonsterInfo(List<Monster> monsters){
        int i = 0;
        for(Monster m : monsters){
            System.out.printf("%d. %s\n", i+1, m.getName());
            System.out.printf("Current HP: %.2f\n", m.getStats().getHP());
            i += 1;
        }
        System.out.println("");
    }

}
