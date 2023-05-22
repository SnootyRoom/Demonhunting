package com.example.demonhunting;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Shop1 extends AppCompatActivity {
    Button healbu, poinsnu, freezingu;
    CountDownTimer countDownTimer;
    Button hpb, dmgb, ultab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop1);
        healbu = findViewById(R.id.button2);
        poinsnu = findViewById(R.id.button3);
        freezingu = findViewById(R.id.button4);
        hpb = findViewById(R.id.button5);
        dmgb = findViewById(R.id.button6);
        ultab = findViewById(R.id.button7);

        countDownTimer = new CountDownTimer(1000000, 50) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(MainActivity.bought1[0]){
                    healbu.setEnabled(false);
                    healbu.setText("Экипировано");
                }
                if(MainActivity.bought1[2]){
                    freezingu.setEnabled(false);
                    freezingu.setText("Экипировано");
                }
                if(MainActivity.bought1[1]){
                    poinsnu.setEnabled(false);
                    poinsnu.setText("Экипировано");
                }
                if(Game.money1 < 25){
                    healbu.setEnabled(false);
                    hpb.setEnabled(false);
                }
                if(Game.money1 < 100){
                    poinsnu.setEnabled(false);
                    ultab.setEnabled(false);
                }
                if (Game.money1 < 50){
                    freezingu.setEnabled(false);
                    dmgb.setEnabled(false);
                }
                TextView textView = (TextView) findViewById(R.id.countmon);
                textView.setText(String.valueOf(Game.money1));
                TextView textView1 = (TextView) findViewById(R.id.textView25);
                textView1.setText(String.valueOf(Game.hpPM));
                TextView textView2 = (TextView) findViewById(R.id.textView26);
                textView2.setText(String.valueOf(Game.damage));
                TextView textView3 = (TextView) findViewById(R.id.textView27);
                textView3.setText(String.valueOf(Game.kulta));
            }
            @Override
            public void onFinish() {
                countDownTimer.start();
            }
        };
        countDownTimer.start();


    }
    public void heal(View v){
       Game.money1 -= 25;
       healbu.setEnabled(false);
       MainActivity.bought1[0] = true;
       healbu.setText("Экипировано");

    }
    public void poison(View v){
        Game.money1 -= 100;
        poinsnu.setEnabled(false);
        MainActivity.bought1[1] = true;
        poinsnu.setText("Экипировано");


    }
    public void freezing(View v){
        Game.money1 -= 50;
        freezingu.setEnabled(false);
        MainActivity.bought1[2] = true;
        freezingu.setText("Экипировано");

    }
    public void hp(View v){
        Game.money1 -= 25;
        Game.hpP += 5;
        Game.hpPM += 5;
        TextView textView = (TextView) findViewById(R.id.textView25);
        textView.setText(String.valueOf(Game.hpPM));


    }
    public void dmg(View v){
        Game.money1 -= 50;
        Game.damage += 5;
        TextView textView = (TextView) findViewById(R.id.textView26);
        textView.setText(String.valueOf(Game.damage));
    }
    public void sp(View v){
        Game.money1 -= 150;
        Game.kulta += 1;
        TextView textView = (TextView) findViewById(R.id.textView27);
        textView.setText(String.valueOf(Game.kulta));

    }
}