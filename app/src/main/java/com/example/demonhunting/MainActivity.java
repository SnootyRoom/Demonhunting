package com.example.demonhunting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    static boolean[] bought1;
    static boolean[] bought;
    static boolean[] sup;
    static boolean[] levels;
    static boolean[] bosses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bought = new boolean[]{false, false, false, false, false, false};
        bought1 = new boolean[]{false, false, false};
        sup = new boolean[]{false};
        levels = new boolean[]{true, false, false, false, false};

    }
    public void onClick(View v) {
        Intent intent;
        intent = new Intent(MainActivity.this, Prelud.class);
        startActivity(intent);
    }
}