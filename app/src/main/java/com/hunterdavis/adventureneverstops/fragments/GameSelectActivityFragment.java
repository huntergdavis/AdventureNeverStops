package com.hunterdavis.adventureneverstops.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.hunterdavis.adventureneverstops.ANSApplication;
import com.hunterdavis.adventureneverstops.R;
import com.hunterdavis.adventureneverstops.events.GameAddedEvent;
import com.hunterdavis.adventureneverstops.views.SaveGameRecyclerViewAdapter;
import com.squareup.otto.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class GameSelectActivityFragment extends Fragment {

    @BindView(R.id.savegame_container)
    RecyclerView saveGameRecyclerView;

    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    public GameSelectActivityFragment() {
        ANSApplication.getEventBus().register(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game_select, container, false);
        ButterKnife.bind(this,view);

        layoutManager=new LinearLayoutManager(getActivity());
        saveGameRecyclerView.setLayoutManager(layoutManager);

        adapter=new SaveGameRecyclerViewAdapter();
        saveGameRecyclerView.setAdapter(adapter);

        return view;
    }

    @Subscribe
    public void updatedSaveGames(GameAddedEvent event) {
        adapter.notifyDataSetChanged();
        adapter.notifyItemRangeChanged(ANSApplication.getSaveGameCount(),1, event.state);
    }
}
