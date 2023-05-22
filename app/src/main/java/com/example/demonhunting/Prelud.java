package com.example.demonhunting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Prelud extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prelud);
    }
    public void menu(View v){
        Intent intent;
        intent = new Intent(Prelud.this, Game.class);
        startActivity(intent);
    }
}