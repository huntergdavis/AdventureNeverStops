package com.hunterdavis.adventureneverstops.fragments;

import android.content.Context;
import android.content.Intent;
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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GameViewFragment extends Fragment {


    @BindView(R.id.history_text)
    TextView historyText;

    private int offsetNumber = 0;

    public GameViewFragment() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Intent intent = getActivity().getIntent();
        offsetNumber = intent.getIntExtra(GameView.EXTRA_SAVE_NUMBER, 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_game_view, container, false);
        ButterKnife.bind(this, v);

        historyText.setText(ANSApplication.getGame(offsetNumber).currentPlayer.hero.backStory());


        return v;
    }



}
