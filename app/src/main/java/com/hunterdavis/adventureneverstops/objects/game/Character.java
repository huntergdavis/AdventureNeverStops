package com.hunterdavis.adventureneverstops.objects.game;

import com.hunterdavis.adventureneverstops.utils.naming.NameUtils;

/**
 * Created by hunter on 10/30/16.
 */
public class Character {

    public Name name;

    public Character() {
        this.name = NameUtils.generatePlayerName();
    }

    public Character(Character c) {
        this.name = new Name(c.name);
    }

    public static Character generateCharacter() {
        return new Character();
    }
}
