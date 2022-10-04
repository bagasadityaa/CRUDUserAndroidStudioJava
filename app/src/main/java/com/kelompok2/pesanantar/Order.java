package com.kelompok2.pesanantar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class Order extends AppCompatActivity {

    int quantity_ayambakar=0,quantity_ayamgoreng=0,quantity_ayamkremes=0,totalQuantity=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
    }

    public void increment_AyamBakar(View view){//perintah tombol tambah
        if(quantity_ayambakar==100){
            Toast.makeText(this,"Maaf pesanan maximal 100",Toast.LENGTH_LONG).show();
            return;
        }
        quantity_ayambakar = quantity_ayambakar+1 ;
        display_ayambakar(quantity_ayambakar);
    }

    public void decrement_AyamBakar(View view){//perintah tombol tambah
        if (quantity_ayambakar==1){
            Toast.makeText(this,"Maaf pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity_ayambakar = quantity_ayambakar -1;
        display_ayambakar(quantity_ayambakar);
    }

    public void increment_AyamGoreng(View view){//perintah tombol tambah
        if(quantity_ayamgoreng==100){
            Toast.makeText(this,"Maaf pesanan maximal 100",Toast.LENGTH_LONG).show();
            return;
        }
        quantity_ayamgoreng = quantity_ayamgoreng+1 ;
        display_ayamgoreng(quantity_ayamgoreng);
    }

    public void decrement_AyamGoreng(View view){//perintah tombol tambah
        if (quantity_ayamgoreng==1){
            Toast.makeText(this,"Maaf pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity_ayamgoreng = quantity_ayamgoreng -1;
        display_ayamgoreng(quantity_ayamgoreng);
    }

    public void increment_AyamKremes(View view){//perintah tombol tambah
        if(quantity_ayamkremes==100){
            Toast.makeText(this,"Maaf pesanan maximal 100",Toast.LENGTH_LONG).show();
            return;
        }
        quantity_ayamkremes = quantity_ayamkremes+1 ;
        display_ayamkremes(quantity_ayamkremes);
    }

    public void decrement_AyamKremes(View view){//perintah tombol tambah
        if (quantity_ayamkremes==1){
            Toast.makeText(this,"Maaf pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity_ayamkremes = quantity_ayamkremes -1;
        display_ayamkremes(quantity_ayamkremes);
    }

    public void TotalQuantity(View view){
        totalQuantity = quantity_ayambakar+quantity_ayamgoreng+quantity_ayamkremes;
        displayTotalQuantity(totalQuantity);
    }
    public void Submitorder(View view) {
        EditText nameEditText=(EditText)findViewById(R.id.edt_name);
        String name=nameEditText.getText().toString();
        Log.v("Order","Nama:"+name);

        EditText mejaEditText=(EditText)findViewById(R.id.edt_meja);
        String meja=mejaEditText.getText().toString();
        Log.v("Order","Meja:"+meja);

        CheckBox AyamBakarChekBox= (CheckBox) findViewById(R.id.AyamBakar_checkbox);
        boolean hasAyamBakar=AyamBakarChekBox.isChecked();//mengidentifikasi check
        Log.v("Order","has ayambakar:"+hasAyamBakar);

        CheckBox AyamGorengChekBox= (CheckBox) findViewById(R.id.AyamGoreng_checkbox);
        boolean hasAyamGoreng=AyamGorengChekBox.isChecked();//mengidentifikasi check
        Log.v("Order","has ayamgoreng:"+hasAyamGoreng);

        CheckBox AyamKremesChekBox= (CheckBox) findViewById(R.id.AyamKremes_checkbox);
        boolean hasAyamKremes=AyamKremesChekBox.isChecked();//mengidentifikasi check
        Log.v("Order","has ayamkremes:"+hasAyamKremes);

        int price=calculateprice(hasAyamBakar,hasAyamGoreng,hasAyamKremes);//memanggil method jumlah harga
        String pricemessage=createOrderSummary(price,name,meja,hasAyamBakar,hasAyamGoreng,hasAyamKremes);

        displayMessage(pricemessage);
    }
    private int calculateprice(boolean hasAyamBakar,boolean hasAyamGoreng,boolean hasAyamKremes){//jumlah pesanan * harga
        int total,totalayambakar=0,totalayamgoreng=0,totalayamkremes = 0,ayamBakar=14000,ayamgoreng=14000,ayamkremes=15000;

        if(hasAyamBakar){
            totalayambakar=ayamBakar*quantity_ayambakar;//harga tambahan toping
        }

        if (hasAyamGoreng){
            totalayamgoreng=ayamgoreng*quantity_ayamgoreng;
        }

        if (hasAyamKremes){
            totalayamkremes=ayamkremes*quantity_ayamkremes;
        }

        total=totalayambakar+totalayamgoreng+totalayamkremes;
        return total;
    }

    private String createOrderSummary(int price, String name,String meja, boolean addAyamBakar, boolean addAyamGoreng,boolean addAyamKremes) {//hasil pemesanan
        String
                pricemessage=" Nama = "+name;
        pricemessage+="\n Meja = "+meja;
        pricemessage+="\n Ayam Bakar ="+quantity_ayambakar;
        pricemessage+="\n Ayam Goreng "+quantity_ayamgoreng;
        pricemessage+="\n Ayam Kremes "+quantity_ayamkremes;
        pricemessage+="\n Total Rp"+price;
        pricemessage+="\n Thankyou";
        return  pricemessage;
    }

    //method ini untuk mencetak hasil perintah yang di tampilkan dengan inisial quantity_textview di textview 0
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_textview);
        priceTextView.setText(message);
    }
    private void displayTotalQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_textview);
        quantityTextView.setText("" + number);
    }

    private void display_ayambakar(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_textview_AyamBakar);
        quantityTextView.setText("" + number);
    }

    private void display_ayamgoreng(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_textview_AyamGoreng);
        quantityTextView.setText("" + number);
    }

    private void display_ayamkremes(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_textview_AyamKremes);
        quantityTextView.setText("" + number);
    }
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_textview);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

}