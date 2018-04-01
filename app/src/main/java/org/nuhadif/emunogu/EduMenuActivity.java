package org.nuhadif.emunogu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EduMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edu_menu);

        //bab1
        TextView bBab1 = (TextView) findViewById(R.id.bBab1);
        bBab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menu = new Intent( EduMenuActivity.this, Bab1.class);
                startActivity(menu);
            }
        });
    }
}
