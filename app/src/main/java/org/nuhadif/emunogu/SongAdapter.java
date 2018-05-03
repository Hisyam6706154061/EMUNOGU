package org.nuhadif.emunogu;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class SongAdapter extends CursorAdapter{
    public SongAdapter(Context context, Cursor c){super(context, c, 0);}

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.list_item,viewGroup,false);
    }

    @Override
    public void bindView(View view,Context context, Cursor cursor) {
        TextView title = (TextView) view.findViewById(R.id.song_title);
        title.setText(cursor.getString(
                cursor.getColumnIndex(SongContract.Song.COL_TITLE)));
        TextView description = (TextView) view.findViewById(R.id.song_description);
        description.setText(cursor.getString(
                cursor.getColumnIndex(SongContract.Song.COL_DESCTIPTION)));
    }
}
