package org.nuhadif.emunogu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {

    ListView lvSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //manggil array ke adapter yang akan di set ke listview ke lvsong
        //array nya pake song
        lvSong = (ListView) findViewById(R.id.lvSong);


//        ArrayAdapter adapter = new ArrayAdapter(ListActivity.this, android.R.layout.simple_list_item_1,song);
//        lvSong.setAdapter(adapter);
    }
}
