package com.kelompok2.pesanantar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kelompok2.pesanantar.Helper.DatabaseHelper;

public class Login extends AppCompatActivity {

    Button Login;
    TextView Register;
    EditText txPassword,txUsername;
    DatabaseHelper myDb;
    AlertDialogManager alert = new AlertDialogManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txUsername = findViewById(R.id.txUsername);
        txPassword = findViewById(R.id.txPassword);
        Login = findViewById(R.id.buttonLogin);
        Register = findViewById(R.id.tvCreateAccount);
        myDb = new DatabaseHelper(this);

        Login = findViewById(R.id.buttonLogin);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = txUsername.getText().toString().trim();
                String password = txPassword.getText().toString().trim();
                Boolean res = myDb.checkUser(email,password);
                if (res==true)
                {
                    Toast.makeText(Login.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                    Intent intentMoveToMain = new Intent(Login.this, MainActivity.class);
                    startActivity(intentMoveToMain);
                } else {
                    Toast.makeText(Login.this, "Login gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Register = findViewById(R.id.tvCreateAccount);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });



    }
    @Override
    public void onBackPressed() {
        final androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(Login.this);
        builder.setMessage("Apakah Anda ingin keluar dari aplikasi?");
        builder.setCancelable(true);
        builder.setNegativeButton(getString(R.string.batal), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton(getString(R.string.keluar), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}