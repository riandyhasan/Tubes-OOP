package com.monstersaku.effectivity;

import com.monstersaku.datas.EffectivityList;
import com.monstersaku.elementtype.ElementType;
import java.util.List;

public class Effectivity {
    public static Effectivity effectivity = new Effectivity();
    private static EffectivityList effectivities = new EffectivityList();
    private List<ItemPair<ElementType>> effectList;

    public Effectivity(){
        this.effectList = effectivities.getList();
    }

    public double getValue(ElementType a, ElementType b){
        for(ItemPair<ElementType> pair : effectList){
            if(pair.getFirst() == a && pair.getSecond() == b){
                return pair.getValue();
            }
        }
        return 1;
    }
}
