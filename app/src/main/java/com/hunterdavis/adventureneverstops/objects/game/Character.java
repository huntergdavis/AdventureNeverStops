package com.hunterdavis.adventureneverstops.objects.game;

import com.hunterdavis.adventureneverstops.utils.naming.NameUtils;

/**
 * Created by hunter on 10/30/16.
 */
public class Character {

    public Name name;
    public long experience;

    public Character() {
        this.name = NameUtils.generatePlayerName();
        this.experience = 0;
    }

    public Character(Character c) {
        this.name = new Name(c.name);
        this.experience = c.experience;
    }

    public static Character generateCharacter() {
        return new Character();
    }
}
