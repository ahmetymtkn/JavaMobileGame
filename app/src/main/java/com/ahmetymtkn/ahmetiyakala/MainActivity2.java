package com.ahmetymtkn.ahmetiyakala;



import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity2 extends AppCompatActivity {
    Rekor rekor;
    Handler handler;
    Runnable runnable;
    int puan;
    TextView textskor, textmaxskor, texttime;
    ImageView[] imagearray;
    Intent intent;
    ImageView imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9,imageView10,imageView11,imageView12,imageView13,imageView14,imageView15,imageView16;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);
        imageView10 = findViewById(R.id.imageView10);
        imageView11 = findViewById(R.id.imageView11);
        imageView12 = findViewById(R.id.imageView12);
        imageView13 = findViewById(R.id.imageView13);
        imageView14 = findViewById(R.id.imageView14);
        imageView15 = findViewById(R.id.imageView15);
        imageView16 = findViewById(R.id.imageView16);
        imagearray = new ImageView[]{imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9,imageView10,imageView11,imageView12,imageView13,imageView14,imageView15,imageView16};
        
        hideImages();


        intent = getIntent();
        rekor = new Rekor(MainActivity2.this,intent.getStringExtra("oyuncu"));

        texttime = findViewById(R.id.textTime);
        textskor = findViewById(R.id.textSkor);
        textmaxskor = findViewById(R.id.textMaxSkor);
        textmaxskor.setText("Max Skor:\n" + rekor.rekorAd  + "-" + rekor.rekorPuan);
        new CountDownTimer(15000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                texttime.setText("TIME:" + (millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                texttime.setText("SÜRE DOLDU");
                handler.removeCallbacks(runnable);
                for(ImageView image: imagearray){
                    image.setVisibility(View.INVISIBLE);}
                System.out.println("puan gönder:"+puan);
                rekor.kontrol(puan);
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity2.this);
                alert.setTitle("Tekrar?");
                alert.setMessage("Yeniden oynamak ister misiniz?");
                alert.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity2.this, "Yeniden başlatılıyor" , Toast.LENGTH_SHORT).show();
                    }
                });
                alert.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity2.this, "Oyun bitti!", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.show();
            }
        }.start();

    }

    private void hideImages() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for(ImageView image: imagearray){
                    image.setVisibility(View.INVISIBLE);
                }
                Random random = new Random();
                int i = random.nextInt(16);
                imagearray[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this,1000);

            }
        };

        handler.post(runnable);

    }

    public void puanArttir(View view) {
        puan++;
        textskor.setText("SKOR:\n" + puan);

    }


}