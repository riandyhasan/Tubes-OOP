package com.monstersaku.monster;

import com.monstersaku.stats.Stats;
import com.monstersaku.moves.Move;
import com.monstersaku.elementtype.ElementType;

import java.util.ArrayList;

public class Monster {
    
    private String nama;
    private ArrayList<ElementType> elementTypes;
    private Stats baseStats;
    private ArrayList<Move> moves;

    public Monster(String nama, ArrayList<ElementType> elementTypes, Stats baseStats, ArrayList<Move> moves){
        this.nama = nama;
        this.elementTypes = elementTypes;
        this.baseStats = baseStats;
        this.moves = moves;
    }

    public String getNama(){
        return nama;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public ArrayList<ElementType> getElementTypes(){
        return elementTypes;
    }

    public void setElementTypes(ArrayList<ElementType> elementTypes){
        this.elementTypes = elementTypes;
    }

    public Stats getBaseStats(){
        return baseStats;
    }

    public void setBaseStats(Stats baseStats){
        this.baseStats = baseStats;
    }

    public ArrayList<Move> getMoves(){
        return moves;
    }

    public void setMoves(ArrayList<Move> moves){
        this.moves = moves;
    }
    
}