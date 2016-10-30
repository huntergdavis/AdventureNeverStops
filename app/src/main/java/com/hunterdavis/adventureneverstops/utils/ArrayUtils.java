package com.hunterdavis.adventureneverstops.utils;

import android.content.res.Resources;
import android.support.annotation.ArrayRes;
import android.support.annotation.StringRes;

import com.hunterdavis.adventureneverstops.ANSApplication;

import java.util.Random;

/**
 * Created by hunter on 10/30/16.
 */

public class ArrayUtils {

    public static String getRandomFromStringArray(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    public static String getRandomFromStringArray(@ArrayRes int resourceId) {
        Resources res = ANSApplication.getApplicationResources();

        String[] pickOneFromMe = res.getStringArray(resourceId);
        return getRandomFromStringArray(pickOneFromMe);

    }
}
