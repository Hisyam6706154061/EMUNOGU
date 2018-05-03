package org.nuhadif.emunogu;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class SongListActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>{

    private SongAdapter songAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        //Setup fab to open editor
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SongListActivity.this, EditorActivity.class);
                startActivity(intent);
            }
        });

        ListView songListView = (ListView) findViewById(R.id.list_view_song);
        songListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(SongListActivity.this, EditorActivity.class);
                intent.setData(ContentUris.withAppendedId(SongContract.Song.CONTENT_URI,id));
                startActivity(intent);
            }
        });

        songAdapter = new SongAdapter(this,null);
        songListView.setAdapter(songAdapter);
        songListView.setEmptyView(findViewById(R.id.empty_view));

        getSupportLoaderManager().initLoader(1,null,this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_insert_dummy_data:
                insertData();
                return true;
            case R.id.action_delete_all_entries:
                getContentResolver().delete(SongContract.Song.CONTENT_URI,null,null);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void insertData(){
        ContentValues values = new ContentValues();
        values.put(SongContract.Song.COL_TITLE, "Song");
        values.put(SongContract.Song.COL_DESCTIPTION, "Description");

        getContentResolver().insert(SongContract.Song.CONTENT_URI,values);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = new String[]{
                SongContract.Song.COL_ID,
                SongContract.Song.COL_TITLE,
                SongContract.Song.COL_DESCTIPTION
        };
        return new CursorLoader(this, SongContract.Song.CONTENT_URI,
                projection,null,null,null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        songAdapter.swapCursor(cursor);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        songAdapter.swapCursor(null);
    }
}
