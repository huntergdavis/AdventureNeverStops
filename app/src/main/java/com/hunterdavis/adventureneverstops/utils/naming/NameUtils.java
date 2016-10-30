package com.hunterdavis.adventureneverstops.utils.naming;

/**
 * Created by hunter on 10/30/16.
 */
public class NameUtils {

    public static String generatePlayerName() {
        return generatePlayerName("");
    }

    public static String generatePlayerName(String baseSeed) {
        return baseSeed + "hunter";
    }
}
