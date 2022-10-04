package com.kelompok2.pesanantar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class logounpam extends AppCompatActivity {

    private int loading=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(" ");
        setContentView(R.layout.activity_logounpam);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent unpam = new Intent(logounpam.this, Login.class);
                startActivity(unpam);
                finish();
            }
        },loading);
    }
}