package com.hunterdavis.adventureneverstops.events;

import com.hunterdavis.adventureneverstops.objects.game.GameState;

/**
 * Created by hunter on 10/30/16.
 */

public class GameAddedEvent {

    public GameState state;

    public GameAddedEvent(GameState addedGame) {
        this.state = addedGame;
    }
}
