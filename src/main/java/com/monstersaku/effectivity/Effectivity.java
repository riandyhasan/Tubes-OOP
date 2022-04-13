package com.monstersaku.effectivity;

import com.monstersaku.datas.EffectivityList;
import com.monstersaku.elementtype.ElementType;
import java.util.List;

public class Effectivity {
    private static final List<ItemPair<ElementType>> effectList = EffectivityList.getEffectivities();

    public static double getValue(ElementType a, ElementType b){
        for(ItemPair<ElementType> pair : effectList){
            if(pair.getFirst() == a && pair.getSecond() == b){
                return pair.getValue();
            }
        }
        return 1;
    }
}
