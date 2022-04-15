package com.monstersaku.stats;

public class StatusCondition{
    private Condition condition;
    private int sleep;

    public StatusCondition(){
        this.condition = Condition.NORMAL;
        this.sleep = 0;
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

    public int getSleepingTime(){
        return sleep;
    }

    public void setSleepingTime(int sleepTime) {
        this.sleep = sleepTime;
    }

}
