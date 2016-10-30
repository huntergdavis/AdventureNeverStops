package com.hunterdavis.adventureneverstops.utils.naming;

import android.content.res.Resources;

import com.hunterdavis.adventureneverstops.ANSApplication;
import com.hunterdavis.adventureneverstops.R;
import com.hunterdavis.adventureneverstops.utils.ArrayUtils;

import java.lang.reflect.Array;

/**
 * Created by hunter on 10/30/16.
 */
public class NameUtils {

    public static String generatePlayerName() {
        return generatePlayerName("");
    }

    public static String generatePlayerName(String baseSeed) {
        return prefix() + " " +
                generateFirstNaame(baseSeed) + " "  +
                generateLastNaame() + " " +
                suffix() + " " +
                suffixTitleModifier() + " " +
                metalAndLandType();
    }

    public static String generateFirstNaame(String baseSeed) {
        return consonent() + vowel() + vowel() + baseSeed + consonent() + vowel() + consonent();
    }

    public static String generateLastNaame() {
        return vowel() + consonent() + vowel() + consonent() + vowel() + vowel() + consonent();
    }


    public static String consonent() {
        return ArrayUtils.getRandom(R.array.base_consonents);
    }

    public static String vowel() {
        return ArrayUtils.getRandom(R.array.base_vowels);
    }

    public static String prefix() {
        return ArrayUtils.getRandom(R.array.prefixes);
    }

    public static String suffixTitleModifier() {

        return ArrayUtils.getRandom(R.array.title_prefixes);
    }

    public static String suffix() {
        return ArrayUtils.getRandom(R.array.suffixes);
    }

    public static String metalAndLandType() {
        return ArrayUtils.getRandom(R.array.metals) + " " + ArrayUtils.getRandom(R.array.types_of_land);
    }
}
