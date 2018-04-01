package org.nuhadif.emunogu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by adifdermawan on 01/04/2018.
 */

public class HasilKuisBab1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hasil_kuis_bab1);

        TextView hasil = (TextView)findViewById(R.id.hasil);
        TextView nilai = (TextView)findViewById(R.id.nilai);

        hasil.setText("Jawaban Benar : "+KuisBab1.benar +"\nJawaban Salah : "+KuisBab1.salah);
        nilai.setText(""+KuisBab1.hasil);
    }

    public void ulangi(View view){
        finish();
        Intent i = new Intent(getApplicationContext(),EduMenuActivity.class);
        startActivity(i);
    }
}
