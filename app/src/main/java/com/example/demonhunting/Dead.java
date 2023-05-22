package com.example.demonhunting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Dead extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dead);
        Game.money1 = 100;
        Game.hpP = 100;
        Game.hpPM = 100;
        Game.kulta = 2;
        Game.damage = 20;
        MainActivity.bought = new boolean[]{false, false, false, false, false, false};
        MainActivity.bought1 = new boolean[]{false, false, false};
        MainActivity.sup = new boolean[]{false};
        MainActivity.levels = new boolean[]{true, false, false, false, false};
    }
    public void menu(View v){
        Game.dead = false;
        Game.win = false;
        Intent intent;
        intent = new Intent(Dead.this, MainActivity.class);
        startActivity(intent);


    }
}
