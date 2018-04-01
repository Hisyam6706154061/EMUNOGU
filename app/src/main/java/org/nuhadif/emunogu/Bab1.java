package org.nuhadif.emunogu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Bab1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bab1);

        Button back = (Button) findViewById(R.id.backtomenu);
        Button kuis = (Button) findViewById(R.id.gotokuis);


        //button back
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Bab1.this, EduMenuActivity.class);
                startActivity(i);
            }
        });


        //button kuis
        kuis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Bab1.this, KuisBab1.class);
                startActivity(i);
            }
        });

    }
}
