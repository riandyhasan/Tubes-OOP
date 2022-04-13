package com.monstersaku.moves;

import com.monstersaku.monster.Monster;
import com.monstersaku.elementtype.ElementType;
import com.monstersaku.effectivity.Effectivity;

public class SpecialMove extends Move {
    private int basePower;

    public SpecialMove(int id, String name, int basePower, ElementType elementTypes, int accuracy, int priority, int ammunition, Target target) {
        super(id, name, elementTypes, accuracy, priority, ammunition, target);
        this.basePower = basePower;
    }

    public int getBasePower() {
        return basePower;
    }

    public void setBasePower(int basePower) {
        this.basePower = basePower;
    }

    public void doMove(Monster source, Monster target){
        double sourceAttack = source.getStats().getSpecialAttack();
        double targetDefense = target.getStats().getSpecialDefense();
        double randomize = (Math.random()*(1-0.85+1)+0.85);
        double burn = source.getCondition().getCondition().equals("BURN") ? 0.5 : 1;
        double effectivity =  1;
        for (ElementType et : target.getElementTypes()){
            effectivity *= Effectivity.getValue(super.getElementTypes(), et);
        }
        double damage = basePower * (sourceAttack/targetDefense) * randomize * effectivity * burn;
        target.moveDamage(damage);
        super.setAmmunition(super.getAmmunitions() - 1);
    }
}
