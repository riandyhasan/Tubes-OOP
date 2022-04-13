package com.monstersaku;

import java.util.*;
import com.monstersaku.datas.*;
import com.monstersaku.gameplay.StartGame;
import com.monstersaku.monster.Monster;
import com.monstersaku.moves.*;


public class Main {
    private static final List<String> CSV_FILE_PATHS = Collections.unmodifiableList(Arrays.asList(
        "configs/monsterpool.csv",
        "configs/movepool.csv",
        "configs/element-type-effectivity-chart.csv"));

    private static void readConfig() {
        MoveList.setFilename(CSV_FILE_PATHS.get(1));
        MonsterList.setFilename(CSV_FILE_PATHS.get(0));
        EffectivityList.setFilename(CSV_FILE_PATHS.get(2));
    }

    public static void main(String[] args){
        readConfig();
        List<Move> moveList = MoveList.getMoves();
        List<Monster> monsterList = MonsterList.getMonsters();
        // StartGame newgame = new StartGame();
        // newgame.startTheGame();
    }
}
