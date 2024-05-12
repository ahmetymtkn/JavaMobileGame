package com.ahmetymtkn.ahmetiyakala;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class Rekor {
    String rekorAd, oyuncu;
    int rekorPuan;
    SharedPreferences sharedPreferences;

    public Rekor(Context context, String oyuncu) {
        this.oyuncu = oyuncu;
        sharedPreferences = context.getSharedPreferences("com.ahmetymtkn.ahmetiyakala", Context.MODE_PRIVATE);
        rekorAd = sharedPreferences.getString("rekorAd","bilinmiyor");
        rekorPuan = sharedPreferences.getInt("rekorPuan",0);
    }
    public void kontrol(int puan){
        System.out.println(rekorPuan);
        System.out.println(puan);
        if(puan> rekorPuan){
            rekorPuan = puan;
            rekorAd = oyuncu;

            sharedPreferences.edit().putString("rekorAd", rekorAd).apply();
            sharedPreferences.edit().putInt("rekorPuan", rekorPuan).apply();
        }

    }
}

