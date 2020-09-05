package com.arthureduardo.joaopedro.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class ColorPreferences {

    private final SharedPreferences mySharedPreferences;

    public ColorPreferences(Context context) {
        this.mySharedPreferences = context.getSharedPreferences("Color", Context.MODE_PRIVATE);
    }
    public void alterarCor(String key, String valor){
        this.mySharedPreferences.edit().putString(key, valor).apply();
    }
    public String getAlterarCor(String key){
        return this.mySharedPreferences.getString(key, "Fundo Branco!");
    }
}
