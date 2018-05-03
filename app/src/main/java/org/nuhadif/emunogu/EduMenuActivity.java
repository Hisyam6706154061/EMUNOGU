package org.nuhadif.emunogu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class EduMenuActivity extends AppCompatActivity implements View.OnClickListener {
    PrefManager prefManager;
    int lastBab = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edu_menu);
        prefManager = new PrefManager(this);
        TextView bBab1 = (TextView) findViewById(R.id.bBab1);
        TextView bBab2 = (TextView) findViewById(R.id.bBab2);
        TextView bBab3 = (TextView) findViewById(R.id.bBab3);
        TextView bBab4 = (TextView) findViewById(R.id.bBab4);
        TextView bBab5 = (TextView) findViewById(R.id.bBab5);
        bBab1.setOnClickListener(this);
        bBab2.setOnClickListener(this);
        bBab3.setOnClickListener(this);
        bBab4.setOnClickListener(this);
        bBab5.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        lastBab = prefManager.getLastBab();
    }

    @Override
    public void onClick(View view) {
        Intent menu = null;
        switch (view.getId()) {
            case R.id.bBab1:
                if (lastBab >= 1) {
                    menu = new Intent(EduMenuActivity.this, Bab1.class);
                } else {
                    Toast.makeText(this, "Anda Harus Menyelesaikan Bab 1", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.bBab2:
                if (lastBab >= 2) {
                    menu = new Intent(EduMenuActivity.this, Bab2.class);
                } else {
                    Toast.makeText(this, "Anda Harus Menyelesaikan Bab 1", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.bBab3:
                if (lastBab >= 3) {
                    menu = new Intent(EduMenuActivity.this, Bab3.class);
                } else {
                    Toast.makeText(this, "Anda Harus Menyelesaikan Bab 2", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.bBab4:
                if (lastBab >= 4) {
                    menu = new Intent(EduMenuActivity.this, Bab4.class);
                } else {
                    Toast.makeText(this, "Anda Harus Menyelesaikan Bab 3", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.bBab5:
                if (lastBab >= 5) {
                    menu = new Intent(EduMenuActivity.this, Bab5.class);
                } else {
                    Toast.makeText(this, "Anda Harus Menyelesaikan Bab 4", Toast.LENGTH_LONG).show();
                }
                break;
            default:
                menu = null;
        }
        if (menu != null)
            startActivity(menu);

    }
}
