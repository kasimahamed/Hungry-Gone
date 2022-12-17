package com.example.hungrygone.HelperClass;

import static android.content.Context.MODE_PRIVATE;
import android.content.Context;
import android.content.SharedPreferences;

public class Commonfunctions {
    public static String logged = "";
    public static SharedPreferences sharedPreferences;

    public static void SavePreferences(String key, String value, Context con) {
        sharedPreferences = con.getSharedPreferences("MY_SHARED_PREF", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static void LoadPreferences(Context con) {
        sharedPreferences = con.getSharedPreferences("MY_SHARED_PREF", MODE_PRIVATE);
        logged = sharedPreferences.getString("Logged", "");

    }
}