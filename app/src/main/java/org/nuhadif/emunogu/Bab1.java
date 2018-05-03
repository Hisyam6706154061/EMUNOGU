package org.nuhadif.emunogu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;


public class Bab1 extends AppCompatActivity {

    String[] materi;
    String[] image;
    String[] point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bab1);

        Button back = (Button) findViewById(R.id.backtomenu);
        Button kuis = (Button) findViewById(R.id.gotokuis);
        data();



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

        RecyclerView recyclerView = findViewById(R.id.rv_materi);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        Bab1Adapter adapter = new Bab1Adapter(materi,image,point);
        recyclerView.setAdapter(adapter);

    }

    void data(){
        point = new String[]{
                "1.\tTangga Nada",
                "-\tTangga nada C mayor",
                "",
                "",
                "-\tTangga nada G mayor (1#)",
                "",
                "",
                "-\tTangga nada D mayor (2#)",
                "",
                "",
                "-\tTangga nada A mayor (3#)",
                "",
                "",
                "-\tTangga nada E mayor (4#)",
                "",
                "",
                "-\tTangga nada B mayor (5#)",
                "",
                "",
                "-\tTangga nada Fis mayor (6# = 6 mol)",
                "",
                "",
                "",
                "",
                "-\tTangga nada Des mayor (7# = 5 mol)",
                "",
                "",
                "-\tTangga nada F mayor (1 mol)",
                "",
                "",
                "-\tTangga nada Bes mayor (2 mol)",
                "",
                "",
                "-\tTangga nada Es mayor (3 mol)",
                "",
                "",
                "-\tTangga nada As mayor (4 mol)",
                "",
                "",
                "Tangga nada Minor adalah salah satu tangga nada diatonik.",
                "-\tTangga nada A minor",
                "",
                "",
                "",
                "-\tTangga nada E minor",
                "",
                "",
                "",
                "-\tTangga nada B minor",
                "",
                "",
                "",
                "-\tTangga nada Fis minor",
                "",
                "",
                "",
                "-\tTangga nada cis minor",
                "",
                "",
                "",
                "-\tTangga nada Gis minor (= As minor)",
                "",
                "",
                "-\tTangga nada Dis minor (= Es minor)",
                "",
                "",
        };

        materi = new String[]{
                "Tangga nada mayor adalah tangga nada yang menggunakan susunan interval \n" +
                        "1\t1\t½\t1\t1\t1\t½\n" +
                        "\n" +
                        "Ciri-ciri tangga nada mayor adalah:\n" +
                        "•\tBersifat riang gembira\n" +
                        "•\tBersemangat\n" +
                        "•\tBiasanya diawali dan diakhiri dengan nada Do\n" +
                        "•\tMempunyai pola interval : 1 , 1 , ½, 1 , 1 , 1, ½\n",
                "Nada-nada yang terdapat dalam Tangga Nada C Mayor adalah: c d e f g a b c’. \nTangga nada ini disebut nada C karena diawali dengan nada dasar C. \nKemudian, disebut mayor sebab diawali dengan nada-nada dengan jarak terts bersifat mayor.\n" +
                        "Jarak C ke E adalah 1 + 1 = Mayor C ke E = 1 + 1 = 2 = mayor\n",
                "Contoh tangga nada C mayor dalam tuts piano sebagai berikut:",
                "",
                "Nada-nada yang terdapat dalam Tangga Nada G Mayor adalah: g a b c’ d’ e’ fis’ g’. \nTangga nada ini disebut nada G karena bernada dasar G dan diawali dengan jarak terts bersifat mayor. \nJarak G ke B adalah 1 + 1 = 2 = mayor.",
                "Contoh tangga nada G mayor dalam tuts piano sebagai berikut:",
                "",
                "Nada-nada yang terdapat dalam tangga nada D mayor adalah: d e fis g a b cis’ d’. \nTangga nada ini bernada dasar D, dan mempunyai nada awal dengan jarak terts bersifat mayor.\n" +
                        "Jarak D ke Fis adalah 1 + 1 = mayor.\n",
                "Contoh tangga nada D mayor dalam tuts piano sebagai berikut",
                "Nada-nada yang terdapat dalam tangga nada A adalah: a b cis’ d’ e’ fis’ gis’ a’. \nSama seperti yang lainnya, berasal dari nada dasar yang digunakan dan jarak terts nada awalnya. Tangga nada ini memakai nada dasar A.\n" +
                        "Jarak A ke Cis adalah 1 + 1 = 2 = mayor.\n",
                "Contoh tangga nada A mayor dalam tuts piano sebagai berikut:",
                "Nada-nada yang termasuk dalam tangga nada E adalah: e fis gis a b cis’ dis’ e’. \nTangga nada ini memakai nada dasar E, dengan jarak terts mayor.\n" +
                        "Jarak E ke Gis adalah 1 + 1 = 2 = mayor.\n",
                "Contoh tangga nada E mayor dalam tuts piano sebagai berikut:",
                "Nada-nada yang termasuk dalam tangga nada B adalah: b cis’ dis’ e’ fis’ gis’ ais’ b’. \nTangga nada ini merupakan tangga nada dengan nada dasar B dan jarak terts awal yang bersifat mayor. \n" +
                        "Jarak B ke Dis adalah 1 + 1 = 2 = mayor.\n",
                "Contoh tangga nada B mayor dalam tuts piano sebagai berikut:",
                "Nada-nada yang termasuk dalam tangga nada Fis adalah: fis gis ais b cis’ dis’ eis’ fis’. \nTangga nada ini adalah tangga nada dengan nada dasar Fis dan diawali dengan jarak terts awal yang bersifat mayor.\n" +
                        "Jarak Fis ke Ais adalah 1 + 1 = 2 = mayor\n",
                "Contoh tangga nada Fis mayor dalam tuts piano sebagai berikut:",
                "Tangga nada Fis mayor identik dengan tangga nada Ges mayor (6 mol). \nHal ini disebabkan oleh penempatan posisi Fis yang sama dengan Ges pada alat musik papan nada klaviatur. Hal seperti ini disebut dengan enharmonis, nada dengan tinggi yang sama dalam sebutan yang berbeda. \n" +
                        "Nada-nada yang ada di dalam tangga nada Ges Mayor adalah: ges as bes ces’ des’ es’ f’ ges’. \nSebutannya menjadi seperti itu karena memakai nada dasar Ges dengan jarak terts awal yang bersifat mayor.\n" +
                        "Jarak Ges ke Bes adalah 1 + 1 = 2 = mayor.\n",
                "Contoh tangga nada Ges mayor dalam tuts piano sebagai berikut (sama dengan Fis mayor):",
                "Nada-nada yang ada di dalamnya adalah: des es f ges as bes c’ des’. \nAlasan yang sama juga berlaku pada tangga nada ini, menggunakan nada dasar Des dengan jarak terts awal bersifat mayor. \n" +
                        "Jarak Des ke F adalah 1 + 1 = 2 = mayor.\n",
                "Contoh tangga nada Des mayor dalam tuts piano sebagai berikut (sama dengan Cis mayor):",
                "Tangga nada Des mayor (5 mol) identik dengan tangga nada Cis mayor (7#)",
                "Nada-nada yang ada di dalamnya adalah: f g a bes c’ d’ e’ f’. \nTangga nada ini disebut tangga nada F sebab nada dasrnya adalah F. \nKemudian, disebut nada mayor sebab diawali dengan jarak terts bersifat mayor.\n" +
                        "Jarak F ke A adalah 1 + 1 = 2 = mayor.\n",
                "Contoh tangga nada F mayor dalam tuts piano sebagai berikut:",
                "Nada-nada yang ada di dalamnya adalah: bes c’ d’ es’ f’ g’ a’ bes’. \nTangga nada ini disebut tangga nada Bes sebab nada dasarnya Bes. \nKemudian, disebut nada mayor sebab diawali dengan jarak terts berderajat mayor.\n" +
                        "Jarak Bes ke D adalah 1 + 1 = 2 = mayor.\n",
                "Contoh tangga nada Bes mayor dalam tuts piano sebagai berikut:",
                "Nada-nada yang ada di dalamnya adalah: es f g as bes c’ d’ es’. \nTangga nada ini mempunyai nada dasar Es dengan jarak terts awal bersifat mayor. \n" +
                        "Jarak Es ke G adalah 1 + 1 = 2 = mayor.\n",
                "Contoh tangga nada Es mayor dalam tuts piano sebagai berikut:",
                "",
                "Nada-nada yang ada di dalamnya adalah: as bes c’ des’ es’ f’ g’ as’. \nTangga nada ini diawali dengan nada dasar As yang mempunyai jarak terts bersifat mayor.\n" +
                        "Jarak As ke C adalah 1 + 1 = 2 = mayor.\n",
                "Contoh tangga nada As mayor dalam tuts piano sebagai berikut:",
                "",
                "Ciri-cirinya adalah:\n" +
                        "•\tBersifat sedih\n" +
                        "•\tKurang Bersemangat\n" +
                        "•\tBiasanya diawali dan diakhiri dengan nada La = A\n" +
                        "•\tMempunyai pola interval : 1, ½ , 1 , 1 , ½ , 1 , 1\n",
                "Minor asli didapat dari tangga nada mayor, dimulali dari nada ke enam (la), tanpa ada nada yang diubah. Karena tangga nada mayor natural dimulai dari nada C, maka tangga nada minor natural dimulai dari nada ke enamnya, yaitu:\n" +
                        "\tSehingga, nada-nada yang ada di dalamnya: a b c’ d’ e’ f’ g’ a’. Interval yang digunakan dalam tangga nada minor asli adalah:\n",
                "Minor Harmonis didapat dari tangga nada minor asal yang nada ke tujuhnya dinaikkan setengah nada. Sehingga nada-nada yang ada di dalamnya: a b c’ d’ e’ f’ gis’ a’/ Interval yang digunakan:",
                "Minor melodis berasar dari tangga nada minor asal dengan nada ke-6 dan ke-7 nya dinaikkan setengah nada sewaktu bergerak naik dan kembali natural (minor asal lagi) sewaktu bergerak turun. Sehingga, nada-nada yang ada di dalamnya: a b c’ d’ e’ fis’ gis’ a’. Interval yang gunakan: (interval naik dan turun berbeda)",
                "Minor asli di dalamnya terdapat: e fis g a b c’ d’ e’. interval yang digunakan:",
                "Minor harmonis di dalamnya terdapat: e fis g a b c’ dis’ e’. interval yang digunakan:",
                "Minor melodis di dalamnya terdapat: e fis g a b cis’ dis’ e’. interval yang digunakan:",
                "Minor asli di dalamnya terdapat: B cis d e fis g a b. interval yang digunakan:",
                "Minor harmonis di dalamnya terdapat: B cis d e fis g ais b. interval yang digunakan:",
                "Minor melodis di dalamnya terdapat: B cis d e fis gis ais b. Interval yang digunakan: ",
                "Minor asli di dalamnya terdapat: fis gis a b cis’ d’ e’ fis’. Interval yang digunakan:",
                "Minor harmonis di dalamnya terdapat: fis gis a b cis’ d’ eis’ fis’. Interval yang ",
                "Minor melodis di dalamnya terdapat: fis gis a b cis’ dis’ eis’ fis’. Interval yang ",
                "Minor asli di dalamnya terdapat: cis dis fis gis a  b cis’. Interval yang digunakan:",
                "Minor harmonis di dalamnya terdapat: cis dis e fis gis a bis cis’. Interval yang digunakan:",
                "Minor melodis di dalamnya terdapat: cis dis e fis gis ais bis cis’. Interval yang digunakan: ",
                "Minor asli di dalamnya terdapat: gis ais b cis’ dis’ e’ fis’ gis’. Interval yang digunakan: ",
                "Minor harmonis di dalamnya terdapat: gis ais b cis’ dis’ e’ fisis’ gis’. Interval yang digunakan: ",
                "Minor asli di dalamnya terdapat: dis eis fis gis ais b cis’ dis’. Interval yang digunakan:",
                "Minor harmonis di dalamnya terdapat: dis eis fis gis ais b cisis’ dis’. Interval yang digunakan:",
        };

        image = new String[]{
                "",
                "",
                "https://image.ibb.co/fjb3in/scan1.png",
                "https://image.ibb.co/j2qcb7/scan2.png",
                "",
                "https://image.ibb.co/djWiG7/scan3.png",
                "https://image.ibb.co/j3NC9S/scan4.png",
                "https://image.ibb.co/dHvAw7/scan5.png",
                "https://image.ibb.co/jNyxb7/scan6.png",
                "https://image.ibb.co/jOjEOn/scan7.png",
                "https://image.ibb.co/mp9QUS/scan8.png",
                "https://image.ibb.co/eP7ZOn/scan9.png",
                "https://image.ibb.co/ka5zpS/scan10.png",
                "https://image.ibb.co/eCnqw7/scan11.png",
                "https://image.ibb.co/ianOG7/scan12.png",
                "https://image.ibb.co/iHpg3n/scan13.png",
                "https://image.ibb.co/nG2yG7/scan14.png",
                "https://image.ibb.co/cwjs9S/scan15.png",
                "https://image.ibb.co/kneyin/scan16.png",
                "https://image.ibb.co/nkYDG7/scan17.png",
                "https://image.ibb.co/dgacb7/scan18.png",
                "https://image.ibb.co/bu6iG7/scan19.png",
                "https://image.ibb.co/cLkcb7/scan20.png",
                "https://image.ibb.co/kScZOn/scan21.png",
                "https://image.ibb.co/fSFcb7/scan22.png",
                "https://image.ibb.co/j44s9S/scan23.png",
                "https://image.ibb.co/dY3kUS/scan24.png",
                "https://image.ibb.co/kjGuOn/scan25.png",
                "https://image.ibb.co/mgNqw7/scan26.png",
                "https://image.ibb.co/jg5kw7/scan27.png",
                "https://image.ibb.co/jYYupS/scan28.png",
                "https://image.ibb.co/b3pOin/scan29.png",
                "https://image.ibb.co/djuCb7/scan30.png",
                "https://image.ibb.co/ewR3in/scan31.png",
                "https://image.ibb.co/kHvkw7/scan32.png",
                "https://image.ibb.co/cTYupS/scan33.png",
                "https://image.ibb.co/caJS9S/scan34.png",
                "https://image.ibb.co/k7tupS/scan35.png",
                "https://image.ibb.co/jXECb7/scan36.png",
                "https://image.ibb.co/ggXb3n/scan37.png",
                "https://image.ibb.co/gzGQw7/scan38.png",
                "https://image.ibb.co/mXq79S/scan39.png",
                "https://image.ibb.co/mXq79S/scan39.png",
                "https://image.ibb.co/exREpS/scan40.png",
                "https://image.ibb.co/exREpS/scan40.png",
                "https://image.ibb.co/mAJS9S/scan41.png",
                "https://image.ibb.co/mKoiin/scan42.png",
                "https://image.ibb.co/hDQUOn/scan43.png",
                "https://image.ibb.co/jY579S/scan44.png",
                "https://image.ibb.co/euM3in/scan45.png",
        };

    }


}
