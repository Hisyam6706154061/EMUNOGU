package org.nuhadif.emunogu;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class KuisBab1 extends AppCompatActivity {

    TextView pertanyaan;
    RadioGroup rg;
    RadioButton PilihanA, PilihanB, PilihanC, PilihanD;
    int nomor = 0;
    public static int hasil, benar, salah;

    //Pertanyaan
    String[] pertanyaan_kuis = new String[]{
            "1. Pertanyaan ke-1",
            "2. Pertanyaan ke-2",
            "3. Pertanyaan ke-3",
            "4. Pertanyaan ke-4",
            "5. Pertanyaan ke-5",
            "6. Pertanyaan ke-6",
            "7. Pertanyaan ke-7",
            "8. Pertanyaan ke-8",
            "9. Pertanyaan ke-9",
            "10. Pertanyaan ke-10"
    };

    //Jawaban
    String[] pilihan_jawaban = new String[]{
            "Benar", "Salah", "Salah", "Salah",
            "Salah", "Salah", "Benar", "Salah",
            "Benar", "Salah", "Salah", "Salah",
            "Salah", "Salah", "Salah", "Benar",
            "Benar", "Salah", "Salah", "Salah",
            "Salah", "Salah", "Benar", "Salah",
            "Benar", "Salah", "Salah", "Salah",
            "Salah", "Benar", "Salah", "Salah",
            "Salah", "Salah", "Salah", "Benar",
            "Salah", "Salah", "Benar", "Salah"
    };

    //Jawaban Benar
    String[] jawaban_benar = new String[]{
            "Benar",
            "Benar",
            "Benar",
            "Benar",
            "Benar",
            "Benar",
            "Benar",
            "Benar",
            "Benar",
            "Benar"
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

        pertanyaan.setText(pertanyaan_kuis[nomor]);
        PilihanA.setText(pilihan_jawaban[0]);
        PilihanB.setText(pilihan_jawaban[1]);
        PilihanC.setText(pilihan_jawaban[2]);
        PilihanD.setText(pilihan_jawaban[3]);

        rg.check(0);
        benar = 0;
        salah = 0;
    }

    public void next(View view) {
        if (PilihanA.isChecked() | PilihanB.isChecked() | PilihanC.isChecked() | PilihanD.isChecked()) {
            RadioButton jawaban_user = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
            String ambil_jawaban_user = jawaban_user.getText().toString();
            nomor++;
            rg.check(0);
            if (nomor < pertanyaan_kuis.length) {
                pertanyaan.setText(pertanyaan_kuis[nomor]);
                PilihanA.setText(pilihan_jawaban[(nomor *4) + 0]);
                PilihanB.setText(pilihan_jawaban[(nomor *4) + 1]);
                PilihanC.setText(pilihan_jawaban[(nomor *4) + 2]);
                PilihanD.setText(pilihan_jawaban[(nomor *4) + 3]);
                if (ambil_jawaban_user.equalsIgnoreCase(jawaban_benar[nomor])) benar++;
                else salah++;
            } else {
                hasil = benar * 10;
                Intent selesai = new Intent(getApplicationContext(), HasilKuisBab1.class);
                startActivity(selesai);
            }
        }
        else{
            Toast.makeText(this,"Pilih Jawaban Terlebih Dahulu",Toast.LENGTH_SHORT).show();
        }
    }
}

