package com.arthureduardo.joaopedro;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    LinearLayout myLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recuperar();
    }

    public static class viewHolder {

    }

    //EXIBE O MENU NA TELA
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //EXECUTA O QUE FOI CLICADO NO MENU
    public void roxo(MenuItem item) {
        String tipo = "roxo";
        myLayout = findViewById(R.id.myLayout);
        myLayout.setBackgroundColor(Color.rgb(128, 0, 128));
        gravar(tipo);
    }

    //EXECUTA O QUE FOI CLICADO NO MENU
    public void azul(MenuItem item) {
        String tipo = "azul";
        myLayout = findViewById(R.id.myLayout);
        myLayout.setBackgroundColor(Color.rgb(8, 77, 110));
        gravar(tipo);
    }


    //GRAVA A ALTERAÇÃO DO BACKGROUND
    public void gravar(String tipo) {
        SharedPreferences prefs = getSharedPreferences("background", MODE_PRIVATE);
        SharedPreferences.Editor ed = prefs.edit();
        ed.putString("cor", tipo);
        ed.apply();
    }

    //RECUPERA A ALTERAÇÃO DO BACKGROUND
    public void recuperar() {
        SharedPreferences prefs = getSharedPreferences("background", MODE_PRIVATE);
        if (prefs.getString("cor", "").equals("roxo")) {
            myLayout = findViewById(R.id.myLayout);
            myLayout.setBackgroundColor(Color.rgb(128, 0, 128));
        } else if (prefs.getString("cor", "").equals("azul")) {
            myLayout = findViewById(R.id.myLayout);
            myLayout.setBackgroundColor(Color.rgb(8, 77, 110));
        }
    }

}