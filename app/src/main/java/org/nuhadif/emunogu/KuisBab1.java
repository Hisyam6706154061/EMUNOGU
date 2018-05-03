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

public class KuisBab1 extends AppCompatActivity {

    TextView pertanyaan;
    RadioGroup rg;
    RadioButton PilihanA, PilihanB, PilihanC, PilihanD;
    int nomor = 0;
    public static int hasil, benar, salah;

    //Pertanyaan
    String[] pertanyaan_kuis = new String[]{
            "1. Susunan tangga nada mayor adalah..",
            "2. Ciri-ciri nada mayor adalah, kecuali…",
            "3. Nada yang termasuk dalam tangga nada G mayor adalah..",
            "4. Nada yang termasuk dalam tangga nada E mayor adalah..",
            "5. Dari gambar tuts piano diatas termasuk tangga nada dari mayor …",
            "6. Ciri-ciri yang termasuk dalam tangga nada minor adalah..",
            "7. Susunan tangga nada minor adalah..",
            "8. Dalam setiap tangga nada minor terdapat 3 macam yaitu, kecuali…",
            "9. Interval dari tangga nada Fis minor asli adalah..",
            "10 .Tangga nada minor melodis berasal dari tangga nada minor asal dengan nada ke-6 dan ke-7 nya dinaikkan setengah nada sewaktu bergerak naik dan kembali natural (minor asal lagi) sewaktu turun adalah pengertian dari minor macam apa?"
    };

    //Jawaban
    String[] pilihan_jawaban = new String[]{
            "1 1 ½ 1 1 1 ½", "1 ½ 1 1 1 ½ 1", "½ 1 1 1 ½ 1 1", "1 ½ 1 1 ½ 1 1",
            "Bersifat riang gembira", "Nadanya bersemangat", "Mempunyai pola interval 1 ½ 1 1 ½ 1 1 ", "Biasanya diawali dan diakhiri dengan nada Do",
            "g a b c d e fis g’", "g a b c’ d’ e’ fis’ g’", "g a cis’ gis d e’ fis g’", "g a’ b’ c d e’ fis’ g’",
            "e fis a b cis’ dis’ e’", "e fis’gis a’ b’ cis’ d e’", "e gis gis a b cis’ dis’ e’", "e fis g a b cis d’ e’",
            "F mayor (1 mol)", "Es mayor (3 mol)", "Bes mayor (2 mol)", "As mayor (4 mol)",
            "bersifat sedih", "nadanya bersemangat", "mempunyai pola interval: 1 ½ 1 1 ½ 1 ½", "Biasanya diawali dan diakhiri dengan nada Sol",
            "1 1 ½ 1 1 1 ½", "1 ½ 1 1 1 ½ 1", "½ 1 1 1 ½ 1 1", "1 ½ 1 1 ½ 1 1",
            "Minor asli ", "Minor ritme", "Minor harmonis", "Minor melodis",
            "fis gis a b cis’ d’ eis’ fis’", "fis gis a b cis’ dis’ eis’ fis’", "fis gis a b cis’ d’ e’ fis’", "fis gis a b cis’ dis’ eis fis’",
            "Minor Harmonis", "Minor asli", "Minor ritme", "Minor melodis"
    };

    //Jawaban Benar
    String[] jawaban_benar = new String[]{
            "1 1 ½ 1 1 1 ½",
            "Mempunyai pola interval 1 ½ 1 1 ½ 1 1 ",
            "g a b c’ d’ e’ fis’ g’",
            "e gis gis a b cis’ dis’ e’",
            "As mayor (4 mol)",
            "bersifat sedih",
            "1 ½ 1 1 ½ 1 1",
            "Minor ritme",
            "fis gis a b cis’ d’ e’ fis’",
            "Minor melodis"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis_bab1);

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
                PilihanA.setText(pilihan_jawaban[(nomor *4) + 0]);
                PilihanB.setText(pilihan_jawaban[(nomor *4) + 1]);
                PilihanC.setText(pilihan_jawaban[(nomor *4) + 2]);
                PilihanD.setText(pilihan_jawaban[(nomor *4) + 3]);
            } else {
                hasil = benar;
                Intent selesai = new Intent(getApplicationContext(), HasilKuisActivity.class);
                selesai.putExtra(FLAG_HASIL_KUIS,hasil);
                selesai.putExtra(FLAG_HASIL_BENAR_KUIS,benar);
                selesai.putExtra(FLAG_HASIL_SALAH_KUIS,salah);
                if(hasil>=7) {
                    PrefManager prefManager = new PrefManager(this);
                    prefManager.setLastBab(2);
                }
                startActivity(selesai);
            }
        }
        else{
            Toast.makeText(this,"Pilih Jawaban Terlebih Dahulu",Toast.LENGTH_SHORT).show();
        }
    }
}

