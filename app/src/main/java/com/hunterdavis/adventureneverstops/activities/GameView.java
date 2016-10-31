package com.hunterdavis.adventureneverstops.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.hunterdavis.adventureneverstops.ANSApplication;
import com.hunterdavis.adventureneverstops.R;

public class GameView extends BaseActivity {

    public static final String EXTRA_SAVE_NUMBER = "com.hunterdavis.adventureneverstops.extra_save_numer";

    private int offsetNumber = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_view);

        Intent intent = getIntent();
        offsetNumber = intent.getIntExtra(GameView.EXTRA_SAVE_NUMBER, 0);


        Toast.makeText(this, "Game Name: " + ANSApplication.getApplicationInstance().getAllGames().gameStates.get(offsetNumber).currentPlayer.name.displayName(),Toast.LENGTH_LONG).show();

    }

}
