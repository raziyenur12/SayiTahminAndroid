package com.example.sayitahminetmeoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
private TextView txtKalanHak,txtSonuc;
private EditText editTxtSayi;
private  String gelendeger;
private int kalanHak=3,randomsayi;
private Random rndNumber;
private  boolean tahminDogrumu=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtKalanHak=(TextView) findViewById(R.id.txtViewKalanHak);
        txtSonuc=(TextView) findViewById(R.id.txtViewSonuc);
        editTxtSayi= (EditText) findViewById(R.id.editTxt);
        rndNumber= new Random();
        randomsayi=rndNumber.nextInt(2);
        System.out.println("Random sayı : "+randomsayi);
    }
    public  void btnTahminEt(View v){
        gelendeger=editTxtSayi.getText().toString();
        if(!TextUtils.isEmpty(gelendeger)){
            if(kalanHak>0 &&tahminDogrumu==false){
                if(gelendeger.equals(String.valueOf(randomsayi))){
sonucGoster("tebrikler doğru tahminde bulundunuz.");
tahminDogrumu=true;
                }else{
                    txtSonuc.setText("yanlış tahminde bulundunuz");
                    editTxtSayi.setText("");
                }
                kalanHak--;

                txtKalanHak.setText("kalan hak: "+kalanHak);
                if(kalanHak==0 && tahminDogrumu==false){
                    sonucGoster("tahmin hakkınız bitti");
              editTxtSayi.setText(" ");
                }

            }else {
                txtSonuc.setText("oyun bitti");
            }
        }else {
            txtSonuc.setText("girilen değer boş olamaz");
        }

    }

    private void sonucGoster(String mesaj) {
        editTxtSayi.setEnabled(false);
        txtSonuc.setText(mesaj);
    }
}