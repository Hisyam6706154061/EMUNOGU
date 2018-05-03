package org.nuhadif.emunogu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class Bab5 extends AppCompatActivity {

    String[] materi;
    String[] point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bab5);
        Button back = (Button) findViewById(R.id.backtomenu);
        Button kuis = (Button) findViewById(R.id.gotokuis);
        data();

        //button back
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Bab5.this, EduMenuActivity.class);
                startActivity(i);
            }
        });


        //button kuis
        kuis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Bab5.this, KuisBab5.class);
                startActivity(i);
            }
        });


    }

    void data() {
        point = new String[]{
                "5.\tKarya Musik Modern",
        };

        materi = new String[]{
                "A.\tMenulis melofi lagu dengan notasi musik\n" +
                        "\uF0A7\tMencari inspirasi lagu\n" +
                        "Proses penulisan atau pembuatan lagu memerlukan inspirasi yang baik. Inspirasi biasanya dipengaruhi oleh suasana hati. Misalnya suasana sedih, gembira, atau bahagia. Inspirasi yang tercipta akan menentukan tema yang akan diciptakan.\n" +
                        "\uF0A7\tMentukan tema dan rama lagu\n" +
                        "Tema lagu akan sangat menentukan langkah berikutnya sehingga hal ini memang harus ada dalam proses penciptaan lagu. Misalnya tema “cinta”. Cinta yang seperti apa yang mau diungkapkan? Bagaimana suasananya, sedih atau gembira? Dan sebagainya. Tema dan suasana ini berhubungan dengan irama atau tempo, harmoni, dan melodi lagu yang akan diciptakan. Apabila tema lagunya sedih, maka irama lagu sebaiknya lambat dan akan lebih mengena jika menggunakan akor minor. Jika lagu yang sukacita/bergembira/bahagia. Akan cocok untuk irama sedang atau irama cepat. Berikut penjelasan mengenai irama lambat dan irama cepat.\n" +
                        "•\tIrama lambat dalam notasi musik adalah irama yang terdapat dalam birama 4/4 atau 6/8.\n" +
                        "•\tIrama cepat dalam notasi musik adalah irama yang terdapat dalam birama 2/4, ½, atau 4/4.\n" +
                        "\uF0A7\tMenulis melodi lagu \n" +
                        "Setelah mendapatkan tema dan irama yang diinginkan, kita dapat mulai menulis lagu/melodinya. Ada beberapa langkah yang perlu diperhatikan:\n" +
                        "•\tMenentukan nada dasar lagu\n" +
                        "Nada dasar sebaiknya disesuaikan dengan ambitus (wilayah suara) penciptanya. Misalnya, do=C, berarti menggunakan tangga nada C. Hal ini sangat penting untuk menentukan penulisan notasi, terutama notasi balok.\n" +
                        "•\tMembuat melodi dari akor\n" +
                        "Dalam mencipta notasi lagu, kita juga memerlukan bantuan alat musik harmonis. Misalnya piano/keyboard atau gitar. Alat-alat musik ini akan sangat membantu terutama bagi mereka yang suka memainkan alat musik tersebut. Setiap orang memiliki cara tersendiri untuk menciptakan lagu. Namun, bagi pemula sebaiknya mengikuti cara seperti yang telah dijelaskan di atas. Bisa juga dengan menentukan akornya terlebih dahulu.\n" +
                        "•\tMenentukan akor sebuah melodi\n" +
                        "Beberapa langkah yang diambil dalam menentukan akor sebuah lagu adalah:\n" +
                        "o\tMenentukan melodi lagu yang dinyanyikan.\n" +
                        "o\tMenyanyikan melodi tersebut\n" +
                        "o\tMencari akor sambil menyanyikan melodi mengandalkan perasaan. Untuk mempermudah mendapatkan akor, nyanyian dapat mengiringi alat musik harmonis misalnya gitar atau keyboard.\n",
        };

    }
}
