package com.monstersaku.effectivity;

public class ItemPair<P> {
    private P a, b;
    private double effect;

    public ItemPair(P a, P b, double effect) {
        this.a = a;
        this.b = b;
        this.effect = effect;
    }

    public P getFirst(){
        return a;
    }

    public P getSecond(){
        return b;
    }

    public double getValue(){
        return effect;
    }

    
}
