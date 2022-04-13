package com.monstersaku.datas;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import com.monstersaku.util.CSVReader;
import com.monstersaku.elementtype.ElementType;
import com.monstersaku.monster.Monster;
import com.monstersaku.stats.Stats;
import com.monstersaku.moves.*;
import com.monstersaku.Main;

public class MonsterList {
    private static String filename;
    private static List<Monster> monsters = null;

    public static void setFilename(String f) {
        filename = f;
    }

    private static List<Monster> CreateMonsterList(){
        List<Monster> monsters = new ArrayList<Monster>();
        List<Move> mms = MoveList.getMoves();
        try{
            CSVReader reader = new CSVReader(new File(Main.class.getResource(filename).toURI()), ";");
            reader.setSkipHeader(true);
            List<String[]> rows = reader.read();
            rows.forEach((row) -> {
                String[] ets = row[2].split(",");
                List<ElementType> elementTypes = new ArrayList<ElementType>();
                for (String et : ets){
                    elementTypes.add(ElementType.valueOf(et));
                }
                String[] stats = row[3].split(",");
                Stats stat = new Stats(Double.parseDouble(stats[0]), Double.parseDouble(stats[1]), Double.parseDouble(stats[2]), Double.parseDouble(stats[3]), Double.parseDouble(stats[4]), Double.parseDouble(stats[5]));
                String[] monsterMoves = row[4].split(",");
                List<Move> listMoves = new ArrayList<Move>();
                DefaultMove dm = new DefaultMove();
                listMoves.add(dm);
                for(String mm : monsterMoves){
                    listMoves.add(getMoveByID(Integer.parseInt(mm), mms));
                }
                Monster monster = new Monster(Integer.parseInt(row[0]), row[1], elementTypes, stat, listMoves);
                monsters.add(monster);
            });

        }catch (Exception e){
            System.out.println("Failed to create list of monsters!");
        }
        return monsters;
    }

    private static Move getMoveByID(int id, List<Move> moves){
        Move move = null;
        for (Move m : moves){
            if(id == m.getID()){
                return m;
            }
        }
        return move;
    }

    public static List<Monster> getMonsters(){
        if(monsters == null){
            monsters = CreateMonsterList();
        }
        return monsters;
    }

    private static Move copyMove(){
        Move move = null;
        return move;
    }


}
