package com.hunterdavis.adventureneverstops.activities;

import android.support.v7.app.AppCompatActivity;

import com.hunterdavis.adventureneverstops.ANSApplication;

/**
 * Created by hunter on 10/31/16.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    public void onResume(){
        super.onResume();
        ANSApplication.getApplicationInstance().currentActivity = this;

    }

    @Override
    public void onPause(){
        super.onPause();
        ANSApplication.getApplicationInstance().currentActivity = null;

    }
}
