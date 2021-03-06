package com.hunterdavis.adventureneverstops.fragments;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.hunterdavis.adventureneverstops.ANSApplication;
import com.hunterdavis.adventureneverstops.R;
import com.hunterdavis.adventureneverstops.activities.GameView;
import com.hunterdavis.adventureneverstops.engine.AdventureEngine;
import com.hunterdavis.adventureneverstops.events.HeroUpdatedEvent;
import com.hunterdavis.adventureneverstops.views.PrologueView;
import com.squareup.otto.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GameViewFragment extends Fragment {


    @BindView(R.id.prologue_view)
    PrologueView prologueView;

    private int offsetNumber = 0;

    AdventureEngine adventureEngine;

    public GameViewFragment() {
        ANSApplication.getEventBus().register(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Intent intent = getActivity().getIntent();
        offsetNumber = intent.getIntExtra(GameView.EXTRA_SAVE_NUMBER, 0);
        adventureEngine = AdventureEngine.loadAdventure(offsetNumber);

        adventureEngine.startAutoTick();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        adventureEngine.stopAutoTick();

        super.onPause();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_game_view, container, false);
        ButterKnife.bind(this, v);

        return v;
    }




}
