package org.nuhadif.emunogu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class Bab3 extends AppCompatActivity {

    String[] materi;
    String[] image;
    String[] point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bab3);
        Button back = (Button) findViewById(R.id.backtomenu);
        Button kuis = (Button) findViewById(R.id.gotokuis);
        data();

        //button back
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Bab3.this, EduMenuActivity.class);
                startActivity(i);
            }
        });


        //button kuis
        kuis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Bab3.this, KuisBab3.class);
                startActivity(i);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.rv_materi);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        Bab3Adapter adapter = new Bab3Adapter(materi,image,point);
        recyclerView.setAdapter(adapter);

    }

    void data() {
        point = new String[]{
                "3. Harmoni",
                "",
                "",
                "",
                "",
        };

        materi = new String[]{
                "Harmoni berarti keselarasan, keindahan, dan terdengar serasi dan indah. Harmonisasi dalam seni musik adalah suatu proses usaha yang ingin membuahkan keindahan suatu melodi. Ini adalah bagian yang sangat penting dalam teknik aransemen. \nAda beberapa cara memadukan nada yang membuahkan keindahan, yaitu:\n" +
                        "a.\tHarmoni dua suara \n" +
                        "b.\tHarmoni tiga suara \n" +
                        "c.\tHarmoni empat suara",
                "A. Harmoni Dua Suara adalah perpaduan dua nada menurun jarak interval tertentu.",
                "Melodi utama lagu biasanya adalah notasi yang bawah, sedangkan suara duanya adalah yang di atas melodi lagunya. Suara 2 seringkali diambil dari nada terts-nya. Misalnya:\n" +
                        "- C terts-nya E\n" +
                        "- D terts-nya F\n" +
                        "- E terts-nya G\n" +
                        "- F terts-nya A\n" +
                        "- G terts-nya C\n" +
                        "- B terts-nya D’\n" +
                        "- Dan seterusnya\n",
                "B. Harmonisasi Tiga Suara adalah pengembangan dari melodi harmoni dua suara. Harmoni Tiga Suara sama halnya dengan akor triad. Misalnya C – E – G. Walaupun tidak menutup kemungkinan adanya inversi (kebalikan) dari letak nada.",
                "Melodi pada lagu di atas terletak pada notasi yang bawah, sedangkan suara duanya di atas melodi yang paling atas. Namun, untuk harmoni tiga suara tidak tertutup kemungkinan kalau yang merupakan melodi utamanya adalah melodi yang di tengah. Suara tiga diambil dari nada kuint-nya. Misalnya:\n" +
                        "- C kuint-nya G\n" +
                        "- D kuint-nya A\n" +
                        "- E kuint-nya B\n" +
                        "- F kuint-nya c\n" +
                        "- G kuint-nya d\n" +
                        "- A kuint-nya e\n" +
                        "- B kuint-nya f\n",
                "C. Harmoni Empat Suara adalah pengembangan triad, baik dengan menambahkan nada ke empat dari luar triad maupun dengan cara menggandakan salah satu di antara nada dari triad tersebut.\n" +
                        "Misalnya:\n" +
                        "- C terts-nya R, Kuint-nya G, suara empatnya c atau nada yang lain dari luar triad.\n" +
                        "- D terts-nya F, Kuint-nya A, suara empatnya d atau nada yang lain dari luar triad.\n" +
                        "- E terts-nya G, Kuint-nya B, suara empatnya e atau nada yang lain dari luar triad.\n" +
                        "- F terts-nya A, Kuint-nya c, suara empatnya b atau nada yang lain dari luar triad.\n" +
                        "- G terts-nya B, Kuint-nya d, suara empatnya g atau nada yang lain dari luar triad.\n" +
                        "- A terts-nya C, Kuint-nya e, suara empatnya a atau nada yang lain dari luar triad.\n" +
                        "- B terts-nya D, Kuint-nya f, suara empatnya b atau nada yang lain dari luar triad.\n" +
                        "\nNada ke empat disesuaikan dengan akor yang digunakan. Letaknya juga di atas atau dibawah nada-nada yang lain (bisa inversi). \n",
        };

        image = new String[]{
                "",
                "https://drive.google.com/open?id=1FcVD_RfNADoOx00Vc3IlMW3zc19SmO3u/view",
                "https://drive.google.com/open?id=15xJdzxTAXiNZsMkrrkspYxMJQfLjam8Z/view",
                "",
                "",
                "",
        };

    }
}

