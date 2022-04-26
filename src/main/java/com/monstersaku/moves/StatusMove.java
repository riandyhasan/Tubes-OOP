package com.monstersaku.moves;

import java.util.Random;
import com.monstersaku.monster.Monster;
import com.monstersaku.elementtype.ElementType;
import com.monstersaku.stats.*;
import com.monstersaku.view.*;

public class StatusMove extends Move {
    private Buff buff;
    private StatusCondition condition;

    public StatusMove(int id, String name, ElementType elementTypes, int accuracy, int priority, int ammunition, Target target, String condition, int HP, int attack, int defense, int specialAttack, int specialDefense, int speed) {
        super(id, name, elementTypes, accuracy, priority, ammunition, target);
        this.buff = new Buff(HP, attack, defense, specialAttack, specialDefense, speed);
        this.condition = condition.equals("-") ? new StatusCondition() : new StatusCondition(Condition.valueOf(condition));
    }

    public Buff getBuff() {
        return buff;
    }

    public StatusCondition getStatusCondition() {
        return condition;
    }

    public void doMove(Monster source, Monster target){
        if(getTarget() == Target.OWN){
            if(source.getStats() != source.getInitialStats()){
                source.removeBuff();
            }
            source.setBuff(this.buff);
            source.applyBuff();
            System.out.printf("%s apply buff to itself\n", source.getName());
            System.out.printf("Now %s's stats\n", source.getName());
            Info.INSTANCE.ShowMonsterStats(source);
        }else{
            if(target.getStats() != target.getInitialStats()){
                target.removeBuff();
            }
            target.setBuff(this.buff);
            target.applyBuff();
            target.setCondition(condition);
            if (!(target.getCondition().getCondition().equals("NORMAL"))){
                System.out.printf("%s apply %s to %s\n", source.getName(), target.getCondition().getCondition(), target.getName());
                if(condition.getCondition().equals("SLEEP")){
                    Random rn = new Random();
                    int sleepTime = rn.nextInt(7) + 1;
                    target.getCondition().setSleepingTime(sleepTime);
                    System.out.printf("%s sleep for %d turns\n", target.getName(), target.getCondition().getSleepingTime());
                }
            }
            System.out.printf("Now %s's stats\n", target.getName());
            Info.INSTANCE.ShowMonsterStats(target);
        }
        setAmmunition(getAmmunitions() - 1);
    }
}
