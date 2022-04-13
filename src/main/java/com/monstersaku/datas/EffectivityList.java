package com.monstersaku.datas;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.monstersaku.util.CSVReader;
import com.monstersaku.effectivity.ItemPair;
import com.monstersaku.elementtype.ElementType;
import com.monstersaku.Main;

public class EffectivityList {
    private static String filename;
    private static List<ItemPair<ElementType>> effectivities = null;

    public static void setFilename(String f) {
        filename = f;
    }


    private static List<ItemPair<ElementType>> CreateEffectivityList(){
        List<ItemPair<ElementType>> effectivities = new ArrayList<ItemPair<ElementType>>();
        try{
            CSVReader reader = new CSVReader(new File(Main.class.getClassLoader().getResource(filename).toURI()), ";");
            reader.setSkipHeader(true);
            List<String[]> rows = reader.read();
            rows.forEach((row) -> {
                ItemPair<ElementType> pair = new ItemPair<ElementType>(ElementType.valueOf(row[0]), ElementType.valueOf(row[1]), Double.parseDouble(row[2]));
                effectivities.add(pair);
            });
        }catch (Exception e) {
            System.out.println("Failed to create list of effectivities!");
        }
        return effectivities;
    }

    public static List<ItemPair<ElementType>> getEffectivities(){
        if(effectivities == null){
            effectivities = CreateEffectivityList();
        }
        return effectivities;
    }
}
