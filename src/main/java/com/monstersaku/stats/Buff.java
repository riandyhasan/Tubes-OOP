package com.monstersaku.stats;

public class Buff{
    private int HP, attack, defense, specialAttack, specialDefense, speed;

    public Buff() {
        this.HP = 0;
        this.attack = 0;
        this.defense = 0;
        this.specialAttack = 0;
        this.specialDefense = 0;
        this.speed = 0;
    }

    public Buff(int HP, int attack, int defense, int specialAttack, int specialDefense, int speed) {
      this.HP = HP;
      this.attack = attack;
      this.defense = defense;
      this.specialAttack = specialAttack;
      this.specialDefense = specialDefense;
      this.speed = speed;
    }

    public int getHP(){
      return HP;
    }

    public int getAttack(){
        return this.attack;
    }

    public int getDefense(){
        return this.defense;
    }

    public int getSpecialAttack(){
        return this.specialAttack;
    }

    public int getSpecialDefense(){
        return this.specialDefense;
    }

    public int getSpeed(){
        return this.speed;
    }

    public void setAttack(int attack){
        this.attack = attack;
    }

    public void setDefense(int defense){
        this.defense = defense;
    }

    public void setSpecialAttack(int specialAttack){
        this.specialAttack = specialAttack;
    }

    public void setSpecialDefense(int specialDefense){
        this.specialDefense = specialDefense;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }

    public float getFactor(int buff){
        switch(buff) {
            case -4:
              return 2/6;
            case -3:
              return 2/5;
            case -2:
              return 2/4;
            case -1:
              return 2/3;
            case 0:
              return 1;
            case 1:
              return 3/2;
            case 2:
              return 4/2;
            case 3:
              return 5/2;
            case 4:
              return 6/2;
            default:
              return 1;
        }
    }
}