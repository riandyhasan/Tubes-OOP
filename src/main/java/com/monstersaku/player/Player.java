package com.monstersaku.player;

import com.monstersaku.monster.Monster;
import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Monster> monsters;
    private boolean isTurn;


    public Player(String name, ArrayList<Monster> monsters) {
        this.name = name;
        this.monsters = monsters;
        this.isTurn = true;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public boolean getIsTurn(){
        return isTurn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addMonster(Monster monster){
        monsters.add(monster);
    }

    public void setIsTurn(boolean isTurn){
        this.isTurn = isTurn;
    }
}
