package org.nuhadif.emunogu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/*
 * Created by adifdermawan on 01/04/2018.
 */

public class HasilKuisActivity extends Activity {
    int hasil = 0;
    int benar = 0;
    int salah = 0;
    public static final String FLAG_HASIL_KUIS = "hasil.kuis";
    public static final String FLAG_HASIL_BENAR_KUIS = "hasil.benar.kuis";
    public static final String FLAG_HASIL_SALAH_KUIS = "hasil.salah.kuis";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hasil_kuis_bab1);
        TextView tvHasil = findViewById(R.id.hasil);
        TextView tvNilai = findViewById(R.id.nilai);

        if (getIntent() != null) {
            hasil = getIntent().getIntExtra(FLAG_HASIL_KUIS,0);
            benar = getIntent().getIntExtra(FLAG_HASIL_BENAR_KUIS,0);
            salah = getIntent().getIntExtra(FLAG_HASIL_SALAH_KUIS,0);
            String hasils = "Jawaban Benar : " + benar + "\nJawaban Salah : " + salah;
            tvHasil.setText(hasils);
            String summary = "" + hasil + "/10";
            tvNilai.setText(summary);
        }

    }

    public void ulangi(View view) {
        finish();
        Intent i = new Intent(getApplicationContext(), EduMenuActivity.class);
        startActivity(i);
    }
}
