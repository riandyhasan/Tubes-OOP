package com.monstersaku.gameplay;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import com.monstersaku.player.Player;
import com.monstersaku.monster.Monster;
import com.monstersaku.datas.MonsterList;

public class StartGame {
    private Turn turn;
    private static List<Monster> monsters = MonsterList.getMonsters();
    private List<Player> players = new ArrayList<Player>();

    public void StartTheGame(){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.print("Masukkan nama pemain pertama: ");
            String name1 = scanner.nextLine();
            int random1 = (int)(5.0 * Math.random());
            Player player1 = new Player(name1, getRandomMonster());
            player1.setCurrentMonster(player1.getMonsters().get(random1));
            players.add(player1);
            System.out.print("Masukkan nama pemain kedua: ");
            String name2 = scanner.nextLine();
            int random2 = (int)(5.0 * Math.random());
            Player player2 = new Player(name2, getRandomMonster());
            player1.setCurrentMonster(player2.getMonsters().get(random2));
            players.add(player2);
            this.turn = new Turn(player1, player2);
            scanner.close();
        }catch(Exception e){
            System.out.println("Failed to start game!");
        }
    }

    public void startTheGame(){
        while(!this.turn.gameOver()){
            this.turn.playerTurn(players.get(0));
            this.turn.playerTurn(players.get(1));
            this.turn.resetTurn();
        }
    }

    private List<Monster> getRandomMonster(){
        List<Monster> randomMonster = new ArrayList<Monster>();
        for (int i = 0; i < 6; i++){
            int randomNum = ThreadLocalRandom.current().nextInt(1, monsters.size() + 1);
            randomMonster.add(getMonsterByID(randomNum));
        }
        return randomMonster;
    }

    private Monster getMonsterByID(int id){
        Monster monster = null;
        for (Monster m : monsters){
            if(id == m.getID()){
                return m;
            }
        }
        return monster;
    }
}
