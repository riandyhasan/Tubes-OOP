package com.monstersaku.moves;

public abstract class Move {
    private String elementTypes;
    private int accuracy;
    private int priority;
    private int ammunition;

    public Move(String elementTypes, int accuracy, int priority, int ammunition) {
        this.elementTypes = elementTypes;
        this.accuracy = accuracy;
        this.priority = priority;
        this.ammunition = ammunition;
    }

    public String getElementTypes() {
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

    public void setElementTypes(String elementTypes) {
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

    public abstract void doMove();

}
