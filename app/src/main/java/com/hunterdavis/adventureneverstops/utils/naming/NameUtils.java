package com.hunterdavis.adventureneverstops.utils.naming;

import com.hunterdavis.adventureneverstops.R;
import com.hunterdavis.adventureneverstops.objects.game.Bio;
import com.hunterdavis.adventureneverstops.utils.ArrayUtils;

/**
 * Created by hunter on 10/30/16.
 */
public class NameUtils {

    public static Bio generatePlayerName() {
        return generatePlayerName("");
    }

    public static Bio generatePlayerName(String baseSeed) {
        return new Bio(prefix(),
                generateFirstNaame(baseSeed),
                generateLastNaame(),
                suffix(),
                suffixTitleModifier(),
                metal(),
                landType());
    }

    public static String capitolizeFirstLetter(String a) {
        return a.substring(0, 1).toUpperCase() + a.substring(1).toLowerCase();
    }

    public static String generateFirstNaame(String baseSeed) {
        return capitolizeFirstLetter(consonent() + vowel() + vowel() + baseSeed + consonent() + vowel() + consonent());
    }

    public static String generateLastNaame() {
        return capitolizeFirstLetter(vowel() + consonent() + vowel() + consonent() + vowel() + vowel() + consonent());
    }


    public static String consonent() {
        return ArrayUtils.getRandomFromStringArray(R.array.base_consonents);
    }

    public static String vowel() {
        return ArrayUtils.getRandomFromStringArray(R.array.base_vowels);
    }

    public static String prefix() {
        return ArrayUtils.getRandomFromStringArray(R.array.prefixes);
    }

    public static String suffixTitleModifier() {

        return ArrayUtils.getRandomFromStringArray(R.array.title_prefixes);
    }

    public static String suffix() {
        return ArrayUtils.getRandomFromStringArray(R.array.suffixes);
    }

    public static String metal() {
        return ArrayUtils.getRandomFromStringArray(R.array.metals);
    }

    public static String landType() {
        return ArrayUtils.getRandomFromStringArray(R.array.types_of_land);

    }
}
