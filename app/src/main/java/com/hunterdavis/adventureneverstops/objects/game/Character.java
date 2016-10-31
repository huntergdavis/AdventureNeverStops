package com.hunterdavis.adventureneverstops.objects.game;

import com.hunterdavis.adventureneverstops.utils.naming.NameUtils;
import com.hunterdavis.adventureneverstops.utils.story.BackStoryUtils;

/**
 * Created by hunter on 10/30/16.
 */
public class Character {

    public Bio bio;
    public long experience;

    public Character() {
        this.bio = NameUtils.generatePlayerName();
        this.experience = 0;
    }

    public Character(Character c) {
        this.bio = new Bio(c.bio);
        this.experience = c.experience;
    }

    public static Character generateCharacter() {
        return new Character();
    }

    public String backStory() {
        return BackStoryUtils.generateBackStory(this);
    }
}
