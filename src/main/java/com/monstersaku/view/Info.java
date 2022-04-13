package com.monstersaku.view;

import java.util.List;
import com.monstersaku.moves.*;
import com.monstersaku.monster.Monster;

public class Info {
    public static void ShowMove(List<Move> moves){
        int i = 0;
        for(Move m : moves){
            System.out.printf("%d. %s\n", i+1, m.getName());
            System.out.println("Ammunition: " + m.getAmmunitions());
            i += 1;
        }
    }

    public static void ShowMonster(List<Monster> monsters){
        int i = 0;
        for(Monster m : monsters){
            System.out.printf("%d. %s\n", i+1, m.getName());
            System.out.println("Current HP: %.1f/%.1f\n" + m.getStats().getHP());
            i += 1;
        }
    }

}
