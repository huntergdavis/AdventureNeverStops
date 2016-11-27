package com.hunterdavis.adventureneverstops.engine;

import android.util.Log;

import com.hunterdavis.adventureneverstops.ANSApplication;
import com.hunterdavis.adventureneverstops.events.HeroUpdatedEvent;
import com.hunterdavis.adventureneverstops.objects.game.GameState;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by hunter on 11/27/16.
 */

public class AdventureEngine {

    public GameState state;

    private TimerTask timerTask = null;


    public AdventureEngine(GameState state) {
        this.state = state;
        ANSApplication.getEventBus().register(this);

    }

    public static AdventureEngine loadAdventure(int saveGameNumber) {
        return new AdventureEngine(ANSApplication.getGame(saveGameNumber));
    }

    public void tick() {
        // moves the simulation forward one tick
        state.epochLastUpdated = System.currentTimeMillis();
        state.currentPlayer.hero.experience++;
        ANSApplication.getEventBus().post(new HeroUpdatedEvent(state.currentPlayer.hero));

    }

    public void startAutoTick() {
        if(timerTask != null) {
            return;
        }
        timerTask = new TimerTask() {
            @Override
            public void run() {
                tick();
            }
        };


        new Timer().scheduleAtFixedRate(timerTask, 1000, 1000);

    }

    public void stopAutoTick() {
        if(timerTask != null) {
            // stops the repeated ticking
            timerTask.cancel();
            timerTask = null;
        }

    }

}
