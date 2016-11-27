package com.hunterdavis.adventureneverstops.events;

import com.hunterdavis.adventureneverstops.objects.game.Character;

/**
 * Created by hunter on 11/27/16.
 */

public class HeroUpdatedEvent {

    public Character hero;

    public HeroUpdatedEvent(Character hero) {
        this.hero = hero;
    }
}
