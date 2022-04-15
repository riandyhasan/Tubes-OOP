package com.monstersaku;

import java.util.*;
import com.monstersaku.datas.*;
import com.monstersaku.gameplay.StartGame;
// import com.monstersaku.monster.Monster;
// import com.monstersaku.moves.*;


public class Main {
    private static final List<String> CSV_FILE_PATHS = Collections.unmodifiableList(Arrays.asList(
        "configs/monsterpool.csv",
        "configs/movepool.csv",
        "configs/element-type-effectivity-chart.csv"));

    private static void readConfig() {
        MonsterList.setFilename(CSV_FILE_PATHS.get(0));
        MoveList.setFilename(CSV_FILE_PATHS.get(1));
        EffectivityList.setFilename(CSV_FILE_PATHS.get(2));
    }

    public static void main(String[] args){
        readConfig();
        StartGame game = new StartGame();
        game.StartTheGame();
    }
}
