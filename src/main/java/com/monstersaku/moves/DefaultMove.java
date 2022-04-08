package com.monstersaku.moves;

import com.monstersaku.moves.Move;

public class DefaultMove extends Move {
    private int basePower;

    public DefaultMove() {
        super("ALL", 100, 0, Integer.MAX_VALUE);
        this.basePower = 50;
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
