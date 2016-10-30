package com.hunterdavis.adventureneverstops.utils.naming;

/**
 * Created by hunter on 10/30/16.
 */
public class NameUtils {

    public static String generatePlayerName() {
        return generatePlayerName("");
    }

    public static String generatePlayerName(String baseSeed) {
        return prefix() + " " +
                generateFirstNaame(baseSeed) + " " +
                generateLastNaame() + " " +
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
        return "";
    }

    public static String vowel() {
        return "";
    }

    public static String prefix() {
        return "";
    }

    public static String suffixTitleModifier() {
        return "";
    }

    public static String suffix() {
        return "";
    }

    public static String metalAndLandType() {
        return "" + "" + "";
    }
}
