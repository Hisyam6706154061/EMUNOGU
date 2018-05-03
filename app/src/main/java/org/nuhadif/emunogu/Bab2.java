package org.nuhadif.emunogu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class Bab2 extends AppCompatActivity {

    String[] materi;
    String[] image;
    String[] point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bab2);

        Button back = (Button) findViewById(R.id.backtomenu);
        Button kuis = (Button) findViewById(R.id.gotokuis);
        data();

        //button back
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Bab2.this, EduMenuActivity.class);
                startActivity(i);
            }
        });


        //button kuis
        kuis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Bab2.this, KuisBab2.class);
                startActivity(i);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.rv_materi);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        Bab2Adapter adapter = new Bab2Adapter(materi,image,point);
        recyclerView.setAdapter(adapter);
    }

    void data() {
        point = new String[]{
                "2.\tKunci Akor",
                "",
                "B.\tPembentukan Triad",
                "C.\tMacam-macam Triad:",

        };

        materi = new String[]{
                "A.\tInterval\n" +
                        "Perhitungan jarak\n" +
                        "Dibawah ini adalah perhitungan jarak antara nada satu dengan nada yang lain serta nama-namanya yang terdapat dalam tangga nada C mayor:\n" +
                        "a. C – C disebut interval satu (prime)\n" +
                        "b. C – D disebut interval dua (second)\n" +
                        "c. C – E disebut interval tiga (terts)\n" +
                        "d. C – F disebut interval empat (kuart)\n" +
                        "e. C – G disebut interval lima (kuint)\n" +
                        "f. C – A disebut interval enam (sekt)\n" +
                        "g. C – B disebut interval tujuh (septim)\n" +
                        "h. C – C disebut interval delapan (oktaf)\n",
                "Penamaan yang sama terjadi dalam nada dasar D, E, F, G, A, dan B – sesuai dengan pola yang ada di atas. \n" +
                        "\n- Derajat Interval\n" +
                        "Derajat Interval dapat dilihat melalui beberapa istilah di antaranya mayor(major), minor (minor), murni (perfect), lebih (augmented), dan kurang (diminished).\n" +
                        "\n- Pembalikan Interval\n" +
                        "Pembalikan juga sering disebut inversi (balikan), yaitu membalikan susunan akor disesuaikan dengan mudah dilakukan seperti C – G menjadi G – C, D – F menjadi F – D, atau D - F - A menjadi F - A - D atau A - D - F, dan seterusnya. Inversi dilakukan apabila akor yang digunakan pada sebuah lagu dibalik, hingga jari tidak bergeser terlalu jauh. Hal ini dilakukan untuk memudahkan jari memainkan akor. \n",
                "Pembentukan triad adalah rancangan perpaduan nada berjarak tiga nada antara satu dengan lainnya. Contohnya, C E G: artinya C ke E berjarak 3 nada, E ke G juga berjarak 3 nada. Triad juga disebut dengan akor dasar (akor sederhana).",
                        "- Triad mayor\n" +
                        "- Triad mayor – enam\n" +
                        "- Triad mayor – tujuh \n" +
                        "- Triad lebih (augmented)\n" +
                        "- Triad minor\n" +
                        "- Triad minor – enam\n" +
                        "- Triad kurang (dimished)\n" +
                        "- Triad mayor minor tujuh\n" +
                        "- Triad minor 7 \n",
        };

        image = new String[]{
                "https://drive.google.com/open?id=1rr6RB6CyP3_8d8YH6VFUvRXsKZ1QPGGV/view",
                "",
                "",
                "",

        };
    }
}
