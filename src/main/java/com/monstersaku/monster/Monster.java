package com.monstersaku.monster;

import com.monstersaku.stats.Stats;
import com.monstersaku.stats.Buff;
import com.monstersaku.stats.StatusCondition;
import com.monstersaku.elementtype.ElementType;
import com.monstersaku.moves.Move;
import java.util.List;

public class Monster {
    private int id;
    private String nama;
    private List<ElementType> elementTypes;
    private Stats baseStats;
    private Stats stats;
    private Buff buff;
    private StatusCondition condition;
    private List<Move> moves;
    private Status status;

    public Monster(int id, String nama, List<ElementType> elementTypes, Stats stats, List<Move> moves) {
        this.id = id;
        this.nama = nama;
        this.elementTypes = elementTypes;
        this.stats = stats;
        this.baseStats = stats;
        this.moves = moves;
        this.status = Status.ALIVE;
        this.condition = new StatusCondition();
        this.buff = new Buff();
    }

    public int getID(){
        return id;
    }

    public String getName(){
        return nama;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public List<ElementType> getElementTypes(){
        return elementTypes;
    }

    public void addElementType(ElementType type){
        elementTypes.add(type);
    }

    public Stats getStats(){
        return stats;
    }

    public Stats getInitialStats(){
        return baseStats;
    }

    public Status getStatus(){
        return status;
    }

    public Buff getBuff(){
        return this.buff;
    }

    public StatusCondition getCondition(){
        return this.condition;
    }

    public void setStats(Stats stats){
        this.stats = stats;
    }

    public void setStatus(Status status){
        this.status = status;
    }

    public void moveDamage(double damage){
        this.stats.setHP(this.stats.getHP() - damage);
        if(this.stats.getHP() <= 0){
            this.status = Status.DEATH;
        }
    }

    public List<Move> getMoves(){
        return moves;
    }

    public void addMove(Move move){
        moves.add(move);
    }

    public void setBuff(Buff buff){
        this.buff = buff;
    }

    public void setCondition(StatusCondition condition){
        this.condition = condition;
    }

    public void applyBuff(){
        double newHP = this.stats.getHP() + (this.stats.getMaxHP() * (this.buff.getHP()/100));
        double newAttack = this.stats.getAttack() * this.buff.getFactor(this.buff.getAttack());
        double newDefense = this.stats.getDefense() * this.buff.getFactor(this.buff.getDefense());
        double newSpecialAttack = this.stats.getSpecialAttack() * this.buff.getFactor(this.buff.getSpecialAttack());
        double newSpecialDefense = this.stats.getSpecialDefense() * this.buff.getFactor(this.buff.getSpecialDefense());
        double newSpeed = this.stats.getSpeed() * this.buff.getFactor(this.buff.getSpeed());
        this.stats.setStat(newHP, newAttack, newDefense, newSpecialAttack, newSpecialDefense, newSpeed);
    }

    public void removeBuff(){
        this.stats.setStat(this.stats.getHP(), this.baseStats.getAttack(), this.baseStats.getDefense(), this.baseStats.getSpecialAttack(), this.baseStats.getSpecialDefense(), this.baseStats.getSpeed());
    }
    
}