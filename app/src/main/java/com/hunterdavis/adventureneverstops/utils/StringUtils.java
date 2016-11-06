package com.hunterdavis.adventureneverstops.utils;

/**
 * Created by hunter on 11/6/16.
 */

public class StringUtils {

    public static String capitolizeFirstLetter(String a) {
        return a.substring(0, 1).toUpperCase() + a.substring(1).toLowerCase();
    }
}
