package com.monstersaku.datas;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.monstersaku.util.CSVReader;
import com.monstersaku.moves.*;
import com.monstersaku.elementtype.ElementType;

public class MoveList {
    private static final String MOVE_CSV_FILE_PATH = "src/main/resources/com/monstersaku/configs/move-config.csv";
    private List<Move> moves;
    private List<String[]> rows;
    private CSVReader reader;
    private File file;

    public MoveList(){
        try{
            this.moves = new ArrayList<Move>();
            this.rows = new ArrayList<String[]>();
            this.file = new File(MOVE_CSV_FILE_PATH);
            reader = new CSVReader(file, ";");
            reader.setSkipHeader(true);
            this.rows = reader.read();
            rows.forEach((row) -> {
                switch (row[1]) {
                    case "NORMAL":
                        NormalMove normal = new NormalMove(Integer.parseInt(row[0]), row[2], Integer.parseInt(row[7]), ElementType.valueOf(row[3]),  Integer.parseInt(row[4]), Integer.parseInt(row[5]), Integer.parseInt(row[6]));
                        moves.add(normal);
                    case "SPECIAL":
                        SpecialMove special = new SpecialMove(Integer.parseInt(row[0]), row[2], Integer.parseInt(row[7]), ElementType.valueOf(row[3]),  Integer.parseInt(row[4]), Integer.parseInt(row[5]), Integer.parseInt(row[6]));
                        moves.add(special);
                    case "STATUS":
                        StatusMove status = new StatusMove(Integer.parseInt(row[0]), row[2], ElementType.valueOf(row[3]), Integer.parseInt(row[4]), Integer.parseInt(row[5]), Integer.parseInt(row[6]), Target.valueOf(row[7]), row[8], Integer.parseInt(row[9]), Integer.parseInt(row[10]), Integer.parseInt(row[11]), Integer.parseInt(row[12]), Integer.parseInt(row[13]), Integer.parseInt(row[14]));
                        moves.add(status);
                    default:
                }
            });
        }catch (IOException e){
            System.out.println("Failed to load file!");
        }

    }

    public List<Move> getList(){
        return moves;
    }
}
