package com.monstersaku.effectivity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.monstersaku.util.CSVReader;
import com.monstersaku.elementtype.ElementType;

public class EffectivityList {
    private static final String EFFECTIVITY_CSV_FILE_PATH = "src/main/resources/com/monstersaku/configs/element-type-effectivity-chart.csv";
    private List<ItemPair<ElementType>> effectivities;
    private List<String[]> rows;
    private CSVReader reader;
    private File file;

    public EffectivityList(){
        try{
            this.effectivities = new ArrayList<ItemPair<ElementType>>();
            this.rows = new ArrayList<String[]>();
            this.file = new File(EFFECTIVITY_CSV_FILE_PATH);
            reader = new CSVReader(file, ";");
            reader.setSkipHeader(true);
            this.rows = reader.read();
            rows.forEach((row) -> {
                ItemPair<ElementType> pair = new ItemPair<ElementType>(ElementType.valueOf(row[0]), ElementType.valueOf(row[1]), Double.parseDouble(row[2]));
                effectivities.add(pair);
            });
        }catch (IOException e){
            System.out.println("Failed to load file!");
        }

    }

    public List<ItemPair<ElementType>> getList(){
        return effectivities;
    }
}
