package com.monstersaku.moves;

import com.monstersaku.monster.Monster;
import com.monstersaku.elementtype.ElementType;
import com.monstersaku.stats.*;

public class StatusMove extends Move {
    private Target target;
    private Buff buff;
    private StatusCondition condition;

    public StatusMove(int id, String name, ElementType elementTypes, int accuracy, int priority, int ammunition, Target target, String condition, int HP, int attack, int defense, int specialAttack, int specialDefense, int speed) {
        super(id, name, elementTypes, accuracy, priority, ammunition);
        this.buff = new Buff(HP, attack, defense, specialAttack, specialDefense, speed);
        this.target = target;
        this.condition = condition.equals("-") ? new StatusCondition() : new StatusCondition(Condition.valueOf(condition));
    }

    public void doMove(Monster source, Monster target){
        if(this.target == Target.OWN){
            source.setBuff(this.buff);
            source.applyBuff();
        }else{
            target.setBuff(this.buff);
            target.applyBuff();
            target.setCondition(condition);
        }
    }
}
