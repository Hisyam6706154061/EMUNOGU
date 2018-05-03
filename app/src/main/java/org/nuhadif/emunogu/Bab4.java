package org.nuhadif.emunogu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class Bab4 extends AppCompatActivity {

    String[] materi;
    String[] point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bab4);
        Button back = (Button) findViewById(R.id.backtomenu);
        Button kuis = (Button) findViewById(R.id.gotokuis);
        data();

        //button back
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Bab4.this, EduMenuActivity.class);
                startActivity(i);
            }
        });


        //button kuis
        kuis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Bab4.this, KuisBab4.class);
                startActivity(i);
            }
        });


    }

    void data() {
        point = new String[]{
                "4.\tKarateristik Musik Modern",
        };

        materi = new String[]{
                "Karakteristik musik tidak bisa terlepas dari unsur-unsur musik yang sangat penting. Setiap unsur saling mendukung satu dengan yang lain. Berikut adalah beberapa unsur yang termasuk karakteristik musik:\n" +
                        "o\tUnsur ritmis adalah unsur musik yang memainkan irama. Biasanya berupa alat musik tanpa nada seperti drum, perkusi, atau alat musik etnis yang tidak memiliki nada. Unsur ritmis memiliki fungsi untuk mengatur irama atau tempo musik sehingga terdengat stabil atau teratur.\n" +
                        "o\tUnsur melodis yaitu unsur musik yang mengutamakan nada. Artinya, unsur ini merupakan susunan nada yang merupakan inti dari sebuah lagu atau musik. Dari mendengar nadanya, kita bisa menentukan irama atau tempo dari melodinya. Alat musik yang mendukung unsur melodis adalah piano, biola, flute, gitar melodi, dan lain-lain yang memiliki nada dan cenderung dimainkan solo.\n" +
                        "o\tUnsur harmonis adalah unsur yang berfungsi sebagai pengiring melodi. Setiap melodi akan terdengar lebih harmonis apabila diiringi dengan nada-nada yang lain secara bersamaan atau disebut akor. Akorlah yang menentukan iringan sebuah musik. Unsur harmonis adalah unsur yang menentukan keselarasan atau harmonisasi musik. Alat musik yang mendukung unsur harmonis adalah gitar, piano atau keyboard, dan alat musik lain yang bisa untuk memainkan akor.\n" +
                        "o\tUnsur ekspesif adalah unsur yang menentukan keindahan sebuah lagu atau musik. Sering kali lihat seorang penyanyi atau musisi membawakan sebuah lagu dengan penuh perasaan, sehingga terdengat lebih indah dan lebih menyentuk perasaan, atau sebaliknya apabila lagu yang dibawakan adalah lagu yang bergembira atau bersemangat, maka pembawaannya juga dengan bersemangat dan enerjik, mencerminkan isi lagu yang dibawakan. Ekspresi adalah ungkapan perasaan atau penjiwaan melalui lagu atau musik. Ekspresi dapat ditampilkan melalui pakaian/kostum, make up, tarian, suara, dan dekorasi tempat pentas. \n",
        };

    }
}
