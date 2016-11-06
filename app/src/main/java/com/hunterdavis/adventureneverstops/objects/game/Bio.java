package com.hunterdavis.adventureneverstops.objects.game;

/**
 * Created by hunter on 10/30/16.
 */

public class Bio {

    public String prefix;
    public String first;
    public String last;
    public String suffix;
    public String suffixTitleModifier;
    public String metal;
    public String landType;

    public Bio(String pre, String fir, String las, String suf, String sufTit, String met, String land) {
        this.prefix = pre;
        this.first = fir;
        this.suffix = suf;
        this.suffixTitleModifier = sufTit;
        this.metal = met;
        this.last = las;
        this.landType = land;
    }

    public Bio(Bio n1) {
        this.prefix = n1.prefix;
        this.first = n1.first;
        this.suffix = n1.suffix;
        this.suffixTitleModifier = n1.suffixTitleModifier;
        this.metal = n1.metal;
        this.last = n1.last;
        this.landType = n1.landType;
    }

    public String displayName() {
        return prefix + " " + first + " " + suffixTitleModifier + " " + landType;
    }

    public String fullName() {
        return  prefix + " " +
                first + " "  +
                last + " " +
                suffix.toLowerCase() + " " +
                suffixTitleModifier + " " +
                metal.toLowerCase() + " " +
                landType;
    }
}
