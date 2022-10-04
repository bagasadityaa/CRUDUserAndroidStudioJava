package com.kelompok2.pesanantar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kelompok2.pesanantar.Helper.DatabaseHelper;

public class Register extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editName,editPassword,editemail,editTextId;
    Button btnAddData,Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        myDb = new DatabaseHelper(this);
        editName = (EditText)findViewById(R.id.editText_name);
        editPassword = (EditText)findViewById(R.id.editText_password);
        editemail = (EditText)findViewById(R.id.editText_email);
        editTextId = (EditText)findViewById(R.id.editTextId);
        btnAddData = (Button)findViewById(R.id.button_add);
        Login = (Button)findViewById(R.id.buttonLogin);
        AddData();

        Login = findViewById(R.id.buttonLogin);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });
    }

    //fungsi tambah

    public void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(
                                editTextId.getText().toString(),
                                editName.getText().toString(),
                                editPassword.getText().toString(),
                                editemail.getText().toString());
                        if (isInserted == true) {
                            Toast.makeText(Register.this, "Data Berhasil Disimpan", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(Register.this, Login.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(Register.this, "Data Gagal Disimpan", Toast.LENGTH_LONG).show();

                        }

                    }
                }
        );

    }





    //membuat alert dialog
    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}