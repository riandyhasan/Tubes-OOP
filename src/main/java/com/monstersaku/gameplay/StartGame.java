package com.monstersaku.gameplay;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import com.monstersaku.player.Player;
import com.monstersaku.monster.Monster;
import com.monstersaku.stats.*;
import com.monstersaku.view.*;
import com.monstersaku.datas.MonsterList;

public class StartGame {
    private static List<Monster> monsters = MonsterList.getMonsters();
    private List<Player> players = new ArrayList<Player>();

    public StartGame() {}

    public void StartTheGame(){
        try{
            Scanner scanner = new Scanner(System.in);
            Banner.INSTANCE.showMessage();
            System.out.print("\n================ GAME START ================\n");
            mainMenu(scanner);
            System.out.print("Masukkan nama pemain pertama: ");
            String name1 = scanner.nextLine();
            int random1 = (int)(5.0 * Math.random());
            Player player1 = new Player(name1, getRandomMonster());
            player1.setCurrentMonster(player1.getMonsters().get(random1));
            players.add(player1);
            TurnMove tm1 = new TurnMove(player1, null);
            System.out.print("Masukkan nama pemain kedua: ");
            String name2 = scanner.nextLine();
            int random2 = (int)(5.0 * Math.random());
            Player player2 = new Player(name2, getRandomMonster());
            player2.setCurrentMonster(player2.getMonsters().get(random2));
            players.add(player2);
            TurnMove tm2 = new TurnMove(player2, null);
            Turn turn = new Turn(players.get(0), players.get(1));
            System.out.println("\n======= TURN DIMULAI =======");
            System.out.printf("Pemain %s menggunakan monster %s\n", players.get(0).getName(), players.get(0).getCurrentMonster().getName());
            System.out.printf("Pemain %s menggunakan monster %s\n", players.get(1).getName(), players.get(1).getCurrentMonster().getName());
            while(!turn.gameOver()){
                TurnMove[] pMoves = {tm1,tm2};
                turn.playerTurn(players.get(0),players.get(1), scanner, pMoves[0]);
                turn.playerTurn(players.get(1),players.get(0), scanner, pMoves[1]);
                turn.moveTurn(pMoves, scanner);
                if(turn.gameOver()){
                    Info.INSTANCE.ShowWinner(turn.getWinner());
                }else{
                    turn.resetTurn();
                    turn.nextRound();
                }
            }
            scanner.close();
        }catch(Exception e){
            System.out.println("Failed to start game!");
        }
    }


    private List<Monster> getRandomMonster(){
        List<Monster> randomMonster = new ArrayList<Monster>();
        for (int i = 0; i < 6; i++){
            int randomNum = ThreadLocalRandom.current().nextInt(1, monsters.size() + 1);
            Monster addM = copyMonster(getMonsterByID(randomNum)); 
            randomMonster.add(addM);
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

    private Monster copyMonster(Monster m){
        Stats ms = m.getStats();
        Stats newStats = new Stats(ms.getMaxHP(), ms.getAttack(), ms.getDefense(), ms.getSpecialAttack(), ms.getSpecialDefense(), ms.getSpeed());
        Monster newMonster = new Monster(m.getID(), m.getName(), m.getElementTypes(), newStats, m.getMoves());
        return newMonster;
    }

    private void mainMenu(Scanner scanner){
        boolean startmenu = false;
        while(!startmenu){
            try{
                MainMenu.INSTANCE.showMessage();
                int mainmenu_choice = scanner.nextInt();
                scanner.nextLine();
                if(mainmenu_choice == 1){
                    startmenu = true;
                }else if(mainmenu_choice == 2){
                    Help.INSTANCE.showMessage();
                }else if(mainmenu_choice == 3){
                    System.out.println("Out from game! Bye-bye.");
                    System.exit(0);
                }else{
                    throw new Exception("Invalid input! Input between 1-3"); 
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
