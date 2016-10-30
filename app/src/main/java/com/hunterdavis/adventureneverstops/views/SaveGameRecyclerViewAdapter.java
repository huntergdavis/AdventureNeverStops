package com.hunterdavis.adventureneverstops.views;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hunterdavis.adventureneverstops.ANSApplication;
import com.hunterdavis.adventureneverstops.R;
import com.hunterdavis.adventureneverstops.objects.game.GameState;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hunter on 10/30/16.
 */

public class SaveGameRecyclerViewAdapter extends RecyclerView.Adapter<SaveGameRecyclerViewAdapter.SaveGameViewHolder> {


    public SaveGameRecyclerViewAdapter() {
        super();
    }

    @Override
    public SaveGameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_save_game,parent,false);
        ButterKnife.bind(this,v);

        SaveGameViewHolder viewHolder=new SaveGameViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SaveGameViewHolder holder, int position) {
        GameState gameState = ANSApplication.getAllGames().gameStates.get(position);
        holder.heroName.setText(gameState.currentPlayer.hero.name);
        holder.gameName.setText(gameState.currentPlayer.name);
    }

    @Override
    public int getItemCount() {
        return ANSApplication.getSaveGameCount();
    }

    public static class SaveGameViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.game_name) public TextView gameName;
        @BindView(R.id.hero_name) public TextView heroName;

        public SaveGameViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
