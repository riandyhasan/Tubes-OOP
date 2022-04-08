package com.monstersaku.moves;

import com.monstersaku.moves.Move;

public class NormalMove extends Move {
    private int basePower;

    public NormalMove(int basePower, String elementTypes, int accuracy, int priority, int ammunition) {
        super(elementTypes, accuracy, priority, ammunition);
        this.basePower = basePower;
    }

    public int getBasePower() {
        return basePower;
    }

    public void setBasePower(int basePower) {
        this.basePower = basePower;
    }

    public void doMove(){

    }
}
