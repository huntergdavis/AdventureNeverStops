package com.hunterdavis.adventureneverstops.events;

/**
 * Created by hunter on 10/31/16.
 */

public class GameDeletedEvent {

    public int index;

    public GameDeletedEvent(int index) {
        this.index = index;
    }
}
