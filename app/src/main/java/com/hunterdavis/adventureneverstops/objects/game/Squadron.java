package com.hunterdavis.adventureneverstops.objects.game;

import java.util.ArrayList;

/**
 * Created by hunter on 10/30/16.
 */
public class Squadron {
    public ArrayList<Character> soldiers = null;

    public Squadron() {
        soldiers = new ArrayList<Character>();
    }

    public Squadron(int armySize) {
        // pre-allocate array size
        soldiers = new ArrayList<>(armySize);

        for(int i = 0; i < armySize; i++) {
            soldiers.add(Character.generateCharacter());
        }
    }

    public Squadron(Squadron a2) {
        this.soldiers = new ArrayList<>(a2.soldiers.size());
        for(Character soldier : a2.soldiers) {
            this.soldiers.add(new Character(soldier));
        }
    }

    public static Squadron generateArmy(int armySize) {
        return new Squadron(armySize);
    }
}
