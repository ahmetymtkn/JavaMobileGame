package com.ahmetymtkn.ahmetiyakala;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    Rekor rekor;
    String oyuncu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editTextText);
        textView= findViewById(R.id.textView3);

        rekor = new Rekor(MainActivity.this,"");

        textView = findViewById(R.id.textView3);
        textView.setText("MAX SKOR:\n"+rekor.rekorAd+"\n"+rekor.rekorPuan);




    }
    public void calistirOyun(View view){
        String oyuncu = editText.getText().toString();
        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
        intent.putExtra("oyuncu",oyuncu);
        startActivity(intent);

    }



}