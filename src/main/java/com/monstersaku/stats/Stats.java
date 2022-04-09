package com.monstersaku.stats;

public class Stats {
    private double maxHP, healthPoint, attack, defense, specialAttack, specialDefense, speed;

    public Stats(double healthPoint, double attack, double defense, double specialAttack, double specialDefense, double speed) {
        this.maxHP = healthPoint;
        this.healthPoint = healthPoint;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
    }

    public double getMaxHP(){
        return maxHP;
    }

    public double getHP(){
        return this.healthPoint;
    }
   
    public double getAttack(){
        return this.attack;
    }

    public double getDefense(){
        return this.defense;
    }

    public double getSpecialAttack(){
        return this.specialAttack;
    }

    public double getSpecialDefense(){
        return this.specialDefense;
    }

    public double getSpeed(){
        return this.speed;
    }


    public void setHP(double hp){
        this.healthPoint = hp;
    }

    public void setAttack(double attack){
        this.attack = attack;
    }

    public void setDefense(double defense){
        this.defense = defense;
    }

    public void setSpecialAttack(double specialAttack){
        this.specialAttack = specialAttack;
    }

    public void setSpecialDefense(double specialDefense){
        this.specialDefense = specialDefense;
    }

    public void setSpeed(double speed){
        this.speed = speed;
    }

    public void setStat(double healthPoint, double attack, double defense, double specialAttack, double specialDefense, double speed) {
        setHP(healthPoint);
        setAttack(attack);
        setDefense(defense);
        setSpecialAttack(specialAttack);
        setSpecialDefense(specialDefense);
        setSpeed(speed);
    }

}