package com.hunterdavis.adventureneverstops.dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.hunterdavis.adventureneverstops.ANSApplication;
import com.hunterdavis.adventureneverstops.R;
import com.hunterdavis.adventureneverstops.events.GameDeletedEvent;

/**
 * Created by hunter on 10/31/16.
 */

public class SaveGameDialogs {

    public static void promptToDeleteSaveGame(Context context, long exp, String fullName, final int adapterPosition) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.save_game_delete_question_title);
        builder.setMessage(context.getString(R.string.save_game_delete_question,fullName,exp));
        builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                ANSApplication.getEventBus().post(new GameDeletedEvent(adapterPosition));

                dialog.dismiss();
            }
        });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
