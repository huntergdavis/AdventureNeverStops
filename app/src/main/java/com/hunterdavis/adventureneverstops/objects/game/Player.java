package com.hunterdavis.adventureneverstops.objects.game;

import com.hunterdavis.adventureneverstops.utils.naming.NameUtils;

public class Player {
    public String name = "Player 1";

    public Player() {
        this.name = NameUtils.generatePlayerName();
    }

    public Player(Player p2) {
        this.name = p2.name;
    }


    public static Player generatePlayer() {
        return new Player();
    }

}
