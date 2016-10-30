package com.hunterdavis.adventureneverstops.objects.game;

import java.util.Date;

/**
 * Created by hunter on 10/30/16.
 */
public class GameState {

    public Player currentPlayer;
    public long epochCreated;
    public long epochLastUpdated;

    public GameState() {
        currentPlayer = new Player();
        epochCreated = epochLastUpdated = System.currentTimeMillis();
    }

    public GameState(GameState g2) {
        this.currentPlayer = new Player(g2.currentPlayer);
        this.epochCreated = g2.epochCreated;
        this.epochLastUpdated = g2.epochLastUpdated;
    }

    public static GameState generateGameState() {
        return new GameState();
    }
}
