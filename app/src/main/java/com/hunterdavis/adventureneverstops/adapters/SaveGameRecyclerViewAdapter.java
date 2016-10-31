package com.hunterdavis.adventureneverstops.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hunterdavis.adventureneverstops.ANSApplication;
import com.hunterdavis.adventureneverstops.R;
import com.hunterdavis.adventureneverstops.activities.GameView;
import com.hunterdavis.adventureneverstops.dialogs.SaveGameDialogs;
import com.hunterdavis.adventureneverstops.objects.game.GameState;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
        holder.updateWithGameStateandPosition(gameState,position);
    }

    @Override
    public int getItemCount() {
        return ANSApplication.getSaveGameCount();
    }

    public static class SaveGameViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.game_name) public TextView gameName;
        @BindView(R.id.hero_name) public TextView heroName;
        @BindView(R.id.hero_experience) public TextView heroExp;

        public long exp;
        public String fullName;
        public int position;


        public SaveGameViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void updateWithGameStateandPosition(GameState gameState, int position) {
            this.position = position;
            heroName.setText(gameState.currentPlayer.hero.bio.displayName());
            gameName.setText(gameState.currentPlayer.bio.displayName());
            heroExp.setText(gameState.currentPlayer.hero.experience + " " + ANSApplication.getApplicationResources().getString(R.string.xp));
            exp = gameState.currentPlayer.hero.experience;
            fullName = gameState.currentPlayer.bio.fullName();
        }

        @OnClick(R.id.delete_save)
        public void deleteSaveGame() {
            SaveGameDialogs.promptToDeleteSaveGame(ANSApplication.getApplicationInstance().currentActivity, exp, fullName, position);
        }

        @OnClick(R.id.save_game_item)
        public void goToSaveGame() {
            Intent intent = new Intent(ANSApplication.getApplicationInstance().currentActivity, GameView.class);
            intent.putExtra(GameView.EXTRA_SAVE_NUMBER, position);
            ANSApplication.getApplicationInstance().currentActivity.startActivity(intent);
        }

    }
}
