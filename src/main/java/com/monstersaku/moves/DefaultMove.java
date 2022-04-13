package com.monstersaku.moves;

import com.monstersaku.monster.Monster;
import com.monstersaku.elementtype.ElementType;
import com.monstersaku.effectivity.Effectivity;

public class DefaultMove extends Move {
    private int basePower;

    public DefaultMove() {
        super(0, "Default Move", ElementType.NORMAL, 100, 0, Integer.MAX_VALUE, Target.ENEMY);
        this.basePower = 50;
    }

    public int getBasePower() {
        return basePower;
    }

    public void setBasePower(int basePower) {
        this.basePower = basePower;
    }

    public void doMove(Monster source, Monster target){
        double sourceAttack = source.getStats().getAttack();
        double targetDefense = target.getStats().getDefense();
        double randomize = (Math.random()*(1-0.85+1)+0.85);
        double burn = source.getCondition().getCondition().equals("BURN") ? 0.5 : 1;
        double effectivity =  1;
        for (ElementType et : target.getElementTypes()){
            effectivity *= Effectivity.getValue(super.getElementTypes(), et);
        }
        double damage = basePower * (sourceAttack/targetDefense) * randomize * effectivity * burn;
        target.moveDamage(damage);
        super.setAmmunition(super.getAmmunitions() - 1);
        double penalty = Math.floor(source.getStats().getMaxHP() * 1/4);
        source.moveDamage(penalty);
    }
}
