package com.hunterdavis.adventureneverstops;

import android.app.Application;

import com.hunterdavis.adventureneverstops.objects.game.AllGames;
import com.hunterdavis.adventureneverstops.objects.game.GameState;

/**
 * Created by hunter on 10/30/16.
 */
public class ANSApplication extends Application {
    private static AllGames TheGames;


    public static AllGames getAllGames() {
        return TheGames;
    }

    private static void loadAllGames() {
        // @todo - load all the games using GSON and shared preferences and instantiate TheGames
    }

    public static void createAndAddGameToAllGames() {
        GameState newGameState = new GameState();
        TheGames.gameStates.add(newGameState);
    }
}
