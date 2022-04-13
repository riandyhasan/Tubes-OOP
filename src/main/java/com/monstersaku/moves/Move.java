package com.monstersaku.moves;

import com.monstersaku.monster.Monster;
import com.monstersaku.elementtype.ElementType;

public abstract class Move {
    private ElementType elementTypes;
    private int id;
    private String name;
    private int accuracy;
    private int priority;
    private int ammunition;
    private Target target;

    public Move(int id, String name, ElementType elementTypes, int accuracy, int priority, int ammunition, Target target) {
        this.id = id;
        this.name = name;
        this.elementTypes = elementTypes;
        this.accuracy = accuracy;
        this.priority = priority;
        this.ammunition = ammunition;
        this.target = target;
    }

    public int getID(){
        return id;
    }

    public String getName(){
        return name;
    }

    public ElementType getElementTypes() {
        return elementTypes;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getPriority() {
        return priority;
    }

    public int getAmmunitions() {
        return ammunition;
    }

    public Target getTarget() {
        return target;
    }

    public void setElementTypes(ElementType elementTypes) {
        this.elementTypes = elementTypes;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public void setPriority(int priority){
        this.priority = priority;
    }

    public void setAmmunition(int ammunition) {
        this.ammunition = ammunition;
    }

    public abstract void doMove(Monster source, Monster target);

}
