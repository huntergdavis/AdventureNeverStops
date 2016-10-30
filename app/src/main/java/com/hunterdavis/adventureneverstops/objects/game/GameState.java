package com.hunterdavis.adventureneverstops.objects.game;

/**
 * Created by hunter on 10/30/16.
 */
public class GameState {

    public Player currentPlayer;

    public GameState() {
        currentPlayer = new Player();
    }

    public GameState(GameState g2) {
        this.currentPlayer = g2.currentPlayer;
    }

    public static GameState generateGameState() {
        return new GameState();
    }
}
