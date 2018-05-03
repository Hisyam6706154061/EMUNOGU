package org.nuhadif.emunogu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static org.nuhadif.emunogu.HasilKuisActivity.FLAG_HASIL_BENAR_KUIS;
import static org.nuhadif.emunogu.HasilKuisActivity.FLAG_HASIL_KUIS;
import static org.nuhadif.emunogu.HasilKuisActivity.FLAG_HASIL_SALAH_KUIS;

public class KuisBab2 extends AppCompatActivity {

    TextView pertanyaan;
    RadioGroup rg;
    RadioButton PilihanA, PilihanB, PilihanC, PilihanD;
    int nomor = 0;
    public int hasil, benar, salah;

    //Pertanyaan
    String[] pertanyaan_kuis = new String[]{
            "1. Perhitungan jarak interval satu disebut..",
            "2. Perhitungan jarak interval lima disebut…",
            "3. Perhitungan jarak interval enam disebut…",
            "4. Perhitungan jarak interval tujuh disebut…",
            "5. Perhitungan jarak interval tiga disebut…",
            "6. Nama lain dari pembalikan interval adalah…",
            "7. Disesuaikan dengan mudah dilakukan seperti C – G menjadi G – C, D – F menjadi F – D, atau D - F - A menjadi F - A - D atau A - D - F, dan seterusnya, adalah pengertian dari..",
            "8. Istilah yang terdapat di dalam derajat interval, kecuali..",
            "9. Macam-macam dari triad, kecuali..",
            "10. Rancangan perpaduan nada berjarak tiga nada antara satu dengan lainnya, adalah pembentukan dari.."
    };

    //Jawaban
    String[] pilihan_jawaban = new String[]{
            "prime", "second ", "terts", "kuart",
            "terts", "septim ", "kuint", "sekt",
            "terts", "septim ", "kuint", "sekt",
            "terts", "septim ", "kuint", "sekt",
            "terts", "kuart ", "kuint", "oktaf",
            "inversi", "invertor", "insentif", "invertis",
            "Inversi ", "Invertis", "Triad ", " Intensif",
            "mayor", "minor", "perfect", "virtual ",
            " Triad mayor", "Triad minor", " Triad Dimished", " Triad virtual",
            "Pembentukan Triad", " Pembentukan Inversi", " Pembentukan Interval", " Pembentukan Mayor"
    };

    //Jawaban Benar
    String[] jawaban_benar = new String[]{
            "prime",
            "kuint",
            "sekt",
            "septim ",
            "terts",
            "inversi",
            "Inversi ",
            "virtual ",
            " Triad virtual",
            "Pembentukan Triad"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis_bab2);

        pertanyaan = (TextView) findViewById(R.id.pertanyaan);
        rg = (RadioGroup) findViewById(R.id.radio_group);
        PilihanA = (RadioButton) findViewById(R.id.PilihanA);
        PilihanB = (RadioButton) findViewById(R.id.PilihanB);
        PilihanC = (RadioButton) findViewById(R.id.PilihanC);
        PilihanD = (RadioButton) findViewById(R.id.PilihanD);

        rg.check(0);
        benar = 0;
        salah = 0;

        pertanyaan.setText(pertanyaan_kuis[nomor]);
        PilihanA.setText(pilihan_jawaban[0]);
        PilihanB.setText(pilihan_jawaban[1]);
        PilihanC.setText(pilihan_jawaban[2]);
        PilihanD.setText(pilihan_jawaban[3]);
    }

    public void next(View view) {
        if (PilihanA.isChecked() | PilihanB.isChecked() | PilihanC.isChecked() | PilihanD.isChecked()) {
            RadioButton jawaban_user = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
            String ambil_jawaban_user = jawaban_user.getText().toString();
            if (ambil_jawaban_user.equalsIgnoreCase(jawaban_benar[nomor])) benar++;
            else salah++;
            nomor++;
            rg.check(0);
            if (nomor < pertanyaan_kuis.length) {
                pertanyaan.setText(pertanyaan_kuis[nomor]);
                PilihanA.setText(pilihan_jawaban[(nomor * 4) + 0]);
                PilihanB.setText(pilihan_jawaban[(nomor * 4) + 1]);
                PilihanC.setText(pilihan_jawaban[(nomor * 4) + 2]);
                PilihanD.setText(pilihan_jawaban[(nomor * 4) + 3]);
            } else {
                hasil = benar;
                Intent selesai = new Intent(getApplicationContext(), HasilKuisActivity.class);
                selesai.putExtra(FLAG_HASIL_KUIS, hasil);
                selesai.putExtra(FLAG_HASIL_BENAR_KUIS, benar);
                selesai.putExtra(FLAG_HASIL_SALAH_KUIS, salah);
                if (hasil >= 7) {
                    PrefManager prefManager = new PrefManager(this);
                    prefManager.setLastBab(3);
                }
                startActivity(selesai);
            }
        } else {
            Toast.makeText(this, "Pilih Jawaban Terlebih Dahulu", Toast.LENGTH_SHORT).show();
        }
    }
}
