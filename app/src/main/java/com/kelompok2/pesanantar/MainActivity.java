package com.kelompok2.pesanantar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imgProfile,imgKereta,imgRide,imgHistory;
    Button buttonnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgProfile = findViewById(R.id.imgProfile);
        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Profile.class);
                startActivity(i);
            }
        });

        imgKereta = findViewById(R.id.imgKereta);
        imgKereta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Order.class);
                startActivity(intent);
            }
        });

        buttonnLogout = findViewById(R.id.logout);
        buttonnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Anda yakin ingin keluar ?")
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("Tidak", null)
                        .create();
                dialog.show();
            }
        });

        imgHistory = findViewById(R.id.imgHistory);
        imgHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Maaf sedang dalam pengembangan",Toast.LENGTH_SHORT).show();
            }
        });

        imgRide = findViewById(R.id.imgToko);
        imgRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Maaf sedang dalam pengembangan",Toast.LENGTH_SHORT).show();
            }
        });
    }
}