package com.hunterdavis.adventureneverstops;

import android.app.Application;
import android.content.res.Resources;

import com.hunterdavis.adventureneverstops.events.GameAddedEvent;
import com.hunterdavis.adventureneverstops.objects.game.AllGames;
import com.hunterdavis.adventureneverstops.objects.game.GameState;
import com.squareup.otto.Bus;

/**
 * Created by hunter on 10/30/16.
 */
public class ANSApplication extends Application {
    private static AllGames TheGames = new AllGames();
    private static Bus eventBus = new Bus();

    private static ANSApplication applicationInstance;

    public ANSApplication() {
        super();
        applicationInstance = this;
    }

    public static ANSApplication getApplicationInstance() {
        return applicationInstance;
    }

    public static Resources getApplicationResources() {
        return applicationInstance.getApplicationContext().getResources();
    }

    public static Bus getEventBus() {
        return eventBus;
    }

    public static AllGames getAllGames() {
        return TheGames;
    }

    public static int getSaveGameCount() {
        return TheGames.gameStates.size();
    }

    private static void loadAllGames() {
        // @todo - load all the games using GSON and shared preferences and instantiate TheGames
    }

    public static void createAndAddGameToAllGames() {
        GameState newGameState = new GameState();
        TheGames.gameStates.add(newGameState);

        eventBus.post(new GameAddedEvent(newGameState));
    }
}
