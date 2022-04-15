package com.monstersaku.gameplay;

import com.monstersaku.player.Player;
import com.monstersaku.moves.*;

public class TurnMove {
    private Player player;
    private Move move;

    public TurnMove(Player player, Move move){
        this.player = player;
        this.move = move;
    }

    public Player getPlayer(){
        return player;
    }

    public Move getMove(){
        return move;
    }

    public void setMove(Move move){
        this.move = move;
    }

    public void setPlayer(Player player){
        this.player = player;
    }


}
