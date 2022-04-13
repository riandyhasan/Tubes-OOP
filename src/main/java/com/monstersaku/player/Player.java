package com.monstersaku.player;

import com.monstersaku.monster.Monster;
import java.util.List;

public class Player {
    private String name;
    private List<Monster> monsters;
    private Monster currentMonster;
    private boolean isTurn;


    public Player(String name, List<Monster> monsters) {
        this.name = name;
        this.monsters = monsters;
        this.isTurn = true;
    }


    public String getName() {
        return name;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public Monster getCurrentMonster() {
        return currentMonster;
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

    public void setCurrentMonster(Monster currentMonster) {
        this.currentMonster = currentMonster;
    }
}
