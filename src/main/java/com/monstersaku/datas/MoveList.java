package com.monstersaku.datas;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import com.monstersaku.util.CSVReader;
import com.monstersaku.moves.*;
import com.monstersaku.elementtype.ElementType;
import com.monstersaku.Main;

public class MoveList {
    private static String filename;
    private static List<Move> moves = null;


    public static void setFilename(String f) {
        filename = f;
    }

    private static List<Move> CreateMoveList(){
        List<Move> moves = new ArrayList<Move>();
        try{
            CSVReader reader = new CSVReader(new File(Main.class.getResource(filename).toURI()), ";");
            reader.setSkipHeader(true);
            List<String[]> rows = reader.read();
            rows.forEach((row) -> {
                if (row.length == 9) {
                    if (row[1].equals("NORMAL")){
                        NormalMove normal = new NormalMove(Integer.parseInt(row[0]), row[2], Integer.parseInt(row[8]), ElementType.valueOf(row[3]),  Integer.parseInt(row[4]), Integer.parseInt(row[5]), Integer.parseInt(row[6]), Target.valueOf(row[7]));
                        moves.add(normal);
                    }else if(row[1].equals("SPECIAL")){
                        SpecialMove special = new SpecialMove(Integer.parseInt(row[0]), row[2], Integer.parseInt(row[8]), ElementType.valueOf(row[3]),  Integer.parseInt(row[4]), Integer.parseInt(row[5]), Integer.parseInt(row[6]), Target.valueOf(row[7]));
                        moves.add(special);
                    }
                }else{
                    if(row[1].equals("STATUS")){
                        String[] stat = row[9].split(",");
                        StatusMove status = new StatusMove(Integer.parseInt(row[0]), row[2], ElementType.valueOf(row[3]), Integer.parseInt(row[4]), Integer.parseInt(row[5]), Integer.parseInt(row[6]), Target.valueOf(row[7]), row[8], Integer.parseInt(stat[0]), Integer.parseInt(stat[1]), Integer.parseInt(stat[2]), Integer.parseInt(stat[3]), Integer.parseInt(stat[4]), Integer.parseInt(stat[5]));
                        moves.add(status);
                    }
                }
            });
        }catch (Exception e) {
            System.out.println("Failed to create list of move!");
        }
        return moves;
    }

    public static List<Move> getMoves(){
        if(moves == null){
            moves = CreateMoveList();
        }
        return moves;
    }
}
