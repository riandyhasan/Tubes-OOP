package com.monstersaku.moves;

import com.monstersaku.monster.Monster;
import com.monstersaku.elementtype.ElementType;

public abstract class Move {
    private ElementType elementTypes;
    private int id;
    private int accuracy;
    private int priority;
    private int ammunition;

    public Move(int id, ElementType elementTypes, int accuracy, int priority, int ammunition) {
        this.id = id;
        this.elementTypes = elementTypes;
        this.accuracy = accuracy;
        this.priority = priority;
        this.ammunition = ammunition;
    }

    public int getID(){
        return id;
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
