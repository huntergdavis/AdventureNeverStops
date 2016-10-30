package com.hunterdavis.adventureneverstops.utils;

import android.content.res.Resources;

import com.hunterdavis.adventureneverstops.ANSApplication;
import com.hunterdavis.adventureneverstops.R;

import java.util.Random;

/**
 * Created by hunter on 10/30/16.
 */

public class ArrayUtils {

    public static String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    public static String getRandom(int resourceId) {
        Resources res = ANSApplication.getApplicationResources();

        String[] pickOneFromMe = res.getStringArray(resourceId);
        return getRandom(pickOneFromMe);

    }
}
