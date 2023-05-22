package com.example.demonhunting;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Shop extends AppCompatActivity {
      Button tan;
      Button ino;
      Button zen;
      Button shi;
      Button ren;


      Button tom;
      TextView mon, dam;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        ren = findViewById(R.id.button9);
        mon = findViewById(R.id.Mon);
        dam = findViewById(R.id.Dam);
        mon.setText(String.valueOf(Game.money1));
        dam.setText(String.valueOf(Game.damage));
        tan = findViewById(R.id.Tanjiro);
        ino = findViewById(R.id.Inoske);
        zen = findViewById(R.id.Zenitsu);
        shi = findViewById(R.id.Shinobu);
        tom = findViewById(R.id.Tomioka);
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(Game.money1 < 100){
                    tan.setEnabled(false);
                }
                else{
                    tan.setEnabled(true);
                }
                if(Game.money1 < 50){
                    ino.setEnabled(false);
                }
                else{
                    ino.setEnabled(true);
                }
                if(Game.money1 < 75){
                    zen.setEnabled(false);
                }
                else{
                    zen.setEnabled(true);
                }

                if(Game.money1 < 500){
                    shi.setEnabled(false);
                }
                else{
                    shi.setEnabled(true);
                }
                if(Game.money1 < 750){
                    ren.setEnabled(false);
                }
                else{
                    ren.setEnabled(true);
                }

                if(Game.money1 < 1000){
                    tom.setEnabled(false);
                }
                else{
                    tom.setEnabled(true);
                }
                if(MainActivity.bought[0]){
                    tan.setEnabled(false);
                    tan.setText("Нанят");
                }
                if(MainActivity.bought[5]){
                    ren.setEnabled(false);
                    ren.setText("Нанят");
                }
                if(MainActivity.bought[1]){
                    ino.setEnabled(false);
                    ino.setText("Нанят");
                }
                if(MainActivity.bought[2]){
                    zen.setEnabled(false);
                    zen.setText("Нанят");
                }
                if(MainActivity.bought[3]){
                    shi.setEnabled(false);
                    shi.setText("Нанят");
                }
                if(MainActivity.bought[4]){
                    tom.setEnabled(false);
                    tom.setText("Нанят");
                }

                handler.postDelayed(this, 1);
            }
        };
        handler.postDelayed(runnable, 1);




    }


    public void Tanjiro(View v){
        Game.damage += 50;
        Game.money1 -= 100;
        tan.setText("Нанят");
        tan.setEnabled(false);
        mon.setText(String.valueOf(Game.money1));
        dam.setText(String.valueOf(Game.damage));
        MainActivity.bought[0] = true;
    }
    public void Inoske(View v){
            Game.damage += 40;
            ino.setText("Нанят");
            ino.setEnabled(false);
            Game.money1 -= 50;
        mon.setText(String.valueOf(Game.money1));
        dam.setText(String.valueOf(Game.damage));
        MainActivity.bought[1] = true;
    }

    public void Zenitsu(View v){
            Game.damage += 45;
            zen.setText("Нанят");
            zen.setEnabled(false);
            Game.money1 -= 75;
        mon.setText(String.valueOf(Game.money1));
        dam.setText(String.valueOf(Game.damage));
        MainActivity.bought[2] = true;

    }
    public void Shinobu(View v){
            Game.damage += 150;
            shi.setText("Нанят");
            shi.setEnabled(false);
            Game.money1 -= 500;
        mon.setText(String.valueOf(Game.money1));
        dam.setText(String.valueOf(Game.damage));
        MainActivity.bought[3] = true;
    }

    public void Tomioka(View v){
            Game.damage += 450;
            Game.money1 -= 1000;
            tom.setText("Нанят");
            tom.setEnabled(false);
        mon.setText(String.valueOf(Game.money1));
        dam.setText(String.valueOf(Game.damage));
        MainActivity.bought[4] = true;
    }
    public void Rengoku(View v){
        Game.damage += 300;
        Game.money1 -= 750;
        ren.setText("Нанят");
        ren.setEnabled(false);
        mon.setText(String.valueOf(Game.money1));
        dam.setText(String.valueOf(Game.damage));
        MainActivity.bought[5] = true;

    }


}
