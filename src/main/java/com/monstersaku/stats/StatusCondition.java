package com.monstersaku.stats;

import com.monstersaku.stats.Condition;

public class StatusCondition{
    private Condition condition;

    public StatusCondition(){
        this.condition = Condition.NORMAL;
    }

    public StatusCondition(Condition condition){
        this.condition = condition;
    }

    public String getCondition(){
        switch(this.condition) {
            case NORMAL:
                return "NORMAL";
            case BURN:
                return "BURN";
            case POISON:
                return "POISON";
            case SLEEP:
                return "SLEEP";
            case PARALYZE:
                return "PARALYZE";
            default:
                return "NORMAL";
        }
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

}
