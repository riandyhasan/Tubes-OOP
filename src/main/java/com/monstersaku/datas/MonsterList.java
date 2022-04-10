package com.monstersaku.datas;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.monstersaku.util.CSVReader;
import com.monstersaku.elementtype.ElementType;
import com.monstersaku.monster.Monster;
import com.monstersaku.moves.*;

public class MonsterList {
    private static final String MONSTER_CSV_FILE_PATH = "src/main/resources/com/monstersaku/configs/monster-config.csv";
    private List<Move> moves;
    private List<String[]> rows;
    private CSVReader reader;
    private File file;

    public MonsterList(){
        try{
            this.moves = new ArrayList<Move>();
            this.rows = new ArrayList<String[]>();
            this.file = new File(MONSTER_CSV_FILE_PATH);
            reader = new CSVReader(file, ";");
            reader.setSkipHeader(true);
            this.rows = reader.read();
            rows.forEach((row) -> {
                Monster monster = new Monster();
            });
        }catch (IOException e){
            System.out.println("Failed to load file!");
        }
    }


}
