package com.hunterdavis.adventureneverstops.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.hunterdavis.adventureneverstops.ANSApplication;
import com.hunterdavis.adventureneverstops.R;

public class GameView extends BaseActivity {

    public static final String EXTRA_SAVE_NUMBER = "com.hunterdavis.adventureneverstops.extra_save_numer";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_view);
    }

}
