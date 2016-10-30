package com.hunterdavis.adventureneverstops.objects.game;

import com.hunterdavis.adventureneverstops.utils.naming.NameUtils;

import java.util.ArrayList;

public class Player {
    public String name = "";

    // A player has a singluar 'hero', the main character in the journey
    public Character hero = null;

    // A player could have many squadrons following his hero
    // a group of characters is known as an 'squadron'
    // a player's group of squadroms is her 'army'
    public int defaultArmySize = 4;
    public int defaultNumberOfArmies = 2;
    public ArrayList<Squadron> army = null;


    public Player() {
        this.name = NameUtils.generatePlayerName();
        this.hero = Character.generateCharacter();

        this.army = new ArrayList<>(defaultNumberOfArmies);
        for(int i = 0; i < defaultNumberOfArmies; i++) {
            this.army.add(Squadron.generateArmy(defaultArmySize));
        }


    }

    public Player(Player p2) {
        this.name = p2.name;
        this.hero = p2.hero;

        this.army = new ArrayList<>(p2.army.size());
        for(Squadron squad : p2.army) {
            this.army.add(new Squadron(squad));
        }

    }


    public static Player generatePlayer() {
        return new Player();
    }

}
