package org.nuhadif.emunogu;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.CancellationSignal;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

public class SongProvider extends ContentProvider {
    private SongDatabase db;

    private static final int SONG = 101;
    private static final int SONG_ID = 102;
    private static UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sUriMatcher.addURI(SongContract.CONTENT_AUTHORITY,
                SongContract.Song.TABLE_SONG, SONG);
        sUriMatcher.addURI(SongContract.CONTENT_AUTHORITY,
                SongContract.Song.TABLE_SONG + "/#", SONG_ID);
    }

    public boolean onCreate(){
        db = new SongDatabase(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteDatabase sqLiteDatabase = db.getReadableDatabase();

        Cursor cursor = null;
        int match = sUriMatcher.match(uri);
        switch (match){
            case SONG:
                cursor = sqLiteDatabase.query(SongContract.Song.TABLE_SONG,
                        projection,selection,selectionArgs,null,null,sortOrder);
                break;
            case SONG_ID:
                selection = SongContract.Song.COL_ID + " =?";
                selectionArgs = new String[]
                        {String.valueOf(ContentUris.parseId(uri))};
                cursor = sqLiteDatabase.query(SongContract.Song.TABLE_SONG,
                        projection,selection,selectionArgs,null,null,sortOrder);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        cursor.setNotificationUri(getContext().getContentResolver(),uri);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        int match = sUriMatcher.match(uri);
        switch (match){
            case SONG:
                return insertData(uri, contentValues);
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
    }

    private Uri insertData(Uri uri, ContentValues contentValues) {
        SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();

        String title = contentValues.getAsString(SongContract.Song.COL_TITLE);
        if(title==null)
            throw new IllegalArgumentException("Song Require a Title");

        long id = sqLiteDatabase.insert(SongContract.Song.TABLE_SONG,null,contentValues);

        if(id==-1){
            Log.e("Song Provider","Failed To Save DATA" + uri);
            return null;
        }
        return ContentUris.withAppendedId(uri,id);
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();
        int match = sUriMatcher.match(uri);
        int result;
        switch (match){
            case SONG:
                result = sqLiteDatabase.delete(SongContract.Song.TABLE_SONG,selection,selectionArgs);
                break;
            case SONG_ID:
                selection = SongContract.Song.COL_ID + " =?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                result = sqLiteDatabase.delete(SongContract.Song.TABLE_SONG,selection,selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        if(result>0)
            getContext().getContentResolver().notifyChange(uri,null);
        return result;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String selection, @Nullable String[] selectionArgs) {
        int match = sUriMatcher.match(uri);
        switch (match){
            case SONG_ID:
                selection = SongContract.Song.COL_ID + " =?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                return update(uri, contentValues, selection, selectionArgs);
            default:
                throw new IllegalArgumentException("Unknown Uri: " + uri);
        }
    }

    private int updateData(Uri uri, ContentValues values, String selection, String[] selectionArgs){
        SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();

        int result = sqLiteDatabase.update(SongContract.Song.TABLE_SONG,values,selection,selectionArgs);
        if(result>0)
            getContext().getContentResolver().notifyChange(uri,null);
        return result;
    }
}
