package com.hunterdavis.adventureneverstops.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hunterdavis.adventureneverstops.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class GameSelectActivityFragment extends Fragment {

    public GameSelectActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_game_select, container, false);
    }
}
