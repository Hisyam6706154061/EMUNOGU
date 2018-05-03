package org.nuhadif.emunogu;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SongDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "song.db";
    private static final int DATABASE_VERSION = 1;

    public SongDatabase(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_SONG =
                "CREATE TABLE " + SongContract.Song.TABLE_SONG +
                " (" + SongContract.Song.COL_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + SongContract.Song.COL_TITLE + " TEXT NOT NULL, "
                + SongContract.Song.COL_MUSIC + " TEXT, "
                + SongContract.Song.COL_DESCTIPTION + " TEXT)";
        sqLiteDatabase.execSQL(SQL_CREATE_SONG);

        String SQL_CREATE_MATERI =
                "CREATE TABLE " + SongContract.Song.TABLE_MATERI +
                        " (" + SongContract.Song.COL_ID_MATERI +
                        " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + SongContract.Song.COL_BAB + " INTEGER, "
                        + SongContract.Song.COL_MATERI + " TEXT, "
                        + SongContract.Song.COL_IMAGE + " TEXT)";
        sqLiteDatabase.execSQL(SQL_CREATE_MATERI);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
