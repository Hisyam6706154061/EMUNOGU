package org.nuhadif.emunogu;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.NavUtils;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditorActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>,View.OnClickListener{

    private EditText mTitleEditText,mDescriptionEditText,mEditSong;
    private Uri currentSongUri;
    private boolean hasChange;
    private StringBuilder songNotation ;

    private TextWatcher changeListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


        }

        @Override
        public void afterTextChanged(Editable editable) {
            hasChange = true;
        }
    };

    private View.OnTouchListener touchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            hasChange = true;
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
        songNotation = new StringBuilder("");
        findViewById(R.id.not1).setOnClickListener(this);
        findViewById(R.id.not2).setOnClickListener(this);
        findViewById(R.id.not3).setOnClickListener(this);
        findViewById(R.id.not4).setOnClickListener(this);
        findViewById(R.id.not5).setOnClickListener(this);
        findViewById(R.id.not6).setOnClickListener(this);
        findViewById(R.id.not7).setOnClickListener(this);
        mTitleEditText = (EditText) findViewById(R.id.edit_song_title);
        mEditSong = (EditText) findViewById(R.id.edit_music);
        mDescriptionEditText = (EditText) findViewById(R.id.edit_song_description);

        mTitleEditText.addTextChangedListener(changeListener);
        mDescriptionEditText.addTextChangedListener(changeListener);

        currentSongUri = getIntent().getData();
        if(currentSongUri != null){
            setTitle("Add a Song");
            getSupportLoaderManager().initLoader(1,null,this);
        }else{
            setTitle("Add a Song");
            invalidateOptionsMenu();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_save:
                if(currentSongUri == null)
                    insertData();
                else
                    updateData();
                finish();
                return true;
            case R.id.action_delete:
                return true;
            case android.R.id.home:
                if(!hasChange)
                    onBackPressed();
                return true;
        }

        DialogInterface.OnClickListener discardButtonClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                NavUtils.navigateUpFromSameTask(EditorActivity.this);
            }
        };
        showUnsavedChangeDialog(discardButtonClickListener);
        return true;
    }

    private void insertData(){
        ContentValues values = new ContentValues();
        values.put(SongContract.Song.COL_TITLE, mTitleEditText.getText().toString().trim());
        values.put(SongContract.Song.COL_DESCTIPTION, mDescriptionEditText.getText().toString().trim());
        values.put(SongContract.Song.COL_MUSIC,mEditSong.getText().toString());

        getContentResolver().insert(SongContract.Song.CONTENT_URI,values);
        Toast.makeText(this,"Save Success",Toast.LENGTH_SHORT).show();
        // TODO: 27/04/2018
    }

    private void updateData(){
        ContentValues values = new ContentValues();
        values.put(SongContract.Song.COL_TITLE,mTitleEditText.getText().toString());
        values.put(SongContract.Song.COL_DESCTIPTION,mDescriptionEditText.getText().toString());
        values.put(SongContract.Song.COL_MUSIC,mEditSong.getText().toString());
        getContentResolver().update(currentSongUri,values,null,null);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        String[] projection = new String[]{
                SongContract.Song.COL_ID,
                SongContract.Song.COL_TITLE,
                SongContract.Song.COL_DESCTIPTION,
                SongContract.Song.COL_MUSIC
        };
        return new CursorLoader(this,currentSongUri, projection,null,null,null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if(cursor.moveToNext()){
            mTitleEditText.setText(cursor.getString(cursor.getColumnIndex(SongContract.Song.COL_TITLE)));
            mDescriptionEditText.setText(cursor.getString(cursor.getColumnIndex(SongContract.Song.COL_DESCTIPTION)));
            mEditSong.setText(cursor.getString(cursor.getColumnIndex(SongContract.Song.COL_MUSIC)));
            songNotation = new StringBuilder(mEditSong.getText().toString());
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mTitleEditText.setText("");
        mDescriptionEditText.setText("");
        mEditSong.setText("");
    }

    private void showUnsavedChangeDialog(DialogInterface.OnClickListener discardButtonClickListener){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Discard Change?");
        builder.setPositiveButton(R.string.discard_yes,discardButtonClickListener);
        builder.setNegativeButton(R.string.discard_no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(dialogInterface!=null){
                    dialogInterface.dismiss();
                }
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onClick(View view) {
        songNotation = new StringBuilder(mEditSong.getText().toString());
        switch (view.getId()){
            case R.id.not1:
                songNotation.append("1");
                break;

            case R.id.not2:
                songNotation.append("2");
                break;

            case R.id.not3:
                songNotation.append("3");
                break;

            case R.id.not4:
                songNotation.append("4");
                break;

            case R.id.not5:
                songNotation.append("5");
                break;

            case R.id.not6:
                songNotation.append("6");
                break;

            case R.id.not7:
                songNotation.append("7");
                break;

        }
        mEditSong.setText(songNotation);
    }

//    @Override
//    public void onBackPressed() {
//        if(!hasChange){
//            super.onBackPressed();
//            return;
//        }
//        DialogInterface.OnClickListener discardButtonClickListener = new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                finish();
//            }
//        };
//    }
}
