package com.example.demonhunting;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.Arrays;
import java.util.Random;

public class Game extends AppCompatActivity {
    public static int damage = 20;
    public static int money1 = 100;
    public static int hpP = 100;
    public static int hpPM = 100;
    public static int kulta = 2;
    public static boolean win = false;
    public static boolean dead = false;
    public static int counter = 10;
    public static boolean attack = false;
    ImageView hpV, poV, feV, punch, boss;
    TextView hpt, count;
    boolean f_boss = false;
    int money_plus = 20;
    int[] back_images;
    int[] demons_im;
    String[] demons_n;
    int[] demons_m;
    int[] demons_hp;
    boolean enb = false, enb1 = false;
    CountDownTimer countDownTimer, countDownTimer1, countDownPoison, countDownFreez, countDownTimer2, countDownUlta, countDownUlta1;
    TextView money, d;
    @SuppressLint({"Range", "MissingInflatedId"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        d = findViewById(R.id.textView18);
        punch = findViewById(R.id.superpunch);
        hpt = findViewById(R.id.hpp);
        ImageView demon = findViewById(R.id.imageView);
        ProgressBar hp = findViewById(R.id.progressBar);
        TextView name = findViewById(R.id.textView);
        hpV = findViewById(R.id.heal);
        poV = findViewById(R.id.poison);
        feV = findViewById(R.id.imageView12);
        count = ((TextView) findViewById(R.id.textView34));
        money = findViewById(R.id.monp);
        back_images = new int[]{R.drawable.back1, R.drawable.backfon, R.drawable.backnight, R.drawable.train, R.drawable.pomeste};
        demons_im = new int[]{R.drawable.demon, R.drawable.rui, R.drawable.anmu, R.drawable.akaza,
        R.drawable.douma, R.drawable.kokushibo};
        demons_n = new String[]{"Демон", "Руи", "Энму", "Аказа", "Доума", "Кокушибо"};
        demons_hp = new int[]{50, 200, 250, 500, 650, 800};
        demons_m = new int[]{20, 50, 100, 500, 600, 1000};
        hp.setMax(demons_hp[0]);
        TextView counterP = (TextView) findViewById(R.id.textView19);
        counterP.setVisibility(View.INVISIBLE);
        TextView counterF = (TextView) findViewById(R.id.textView21);
        counterF.setVisibility(View.INVISIBLE);
        TextView time = (TextView) findViewById(R.id.timer);
        boss = ((ImageView) findViewById(R.id.button10));
        boss.setEnabled(false);
        boss.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.bossb));
        Random rnd = new Random();
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                money.setText(String.valueOf(money1));
                hpt.setText(String.valueOf(hpP));
                d.setText(String.valueOf(damage));
                count.setText(String.valueOf(counter));
                if(counter == 0){
                    boss.setEnabled(true);
                    count.setVisibility(View.INVISIBLE);
                    boss.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.boss));
                }
                if(MainActivity.bought1[0]){
                    hpV.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.heal));
                }
                else{
                    hpV.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.healb));
                }
                if(MainActivity.bought1[1]){
                    poV.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.poison));
                }
                else{
                    poV.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.poisonb));
                }
                if(MainActivity.bought1[2]){
                    feV.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.freez));
                }
                else{
                    feV.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.freezb));
                }
                if(MainActivity.sup[0]){
                    punch.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.punch));

                }
                else{
                    int color = getResources().getColor(R.color.black);
                    punch.setBackgroundColor(color);
                }

                handler.postDelayed(this, 30);
            }
        };
        handler.postDelayed(runnable, 30);

        countDownTimer2 = new CountDownTimer(1000, 10) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(hpP <= 0){
                    dead = true;
                    Intent intent;
                    intent = new Intent(Game.this, Dead.class);
                    startActivity(intent);
                }
                if(win){
                    Intent intent;
                    intent = new Intent(Game.this, Win.class);
                    startActivity(intent);
                }

            }

            @Override
            public void onFinish() {
              if(!win && !dead){
                  countDownTimer2.start();
              }
            }
        };
        countDownTimer2.start();

        countDownTimer = new CountDownTimer(1000000, 2000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if(hp.getProgress() >= 5) {
                    hp.setProgress(hp.getProgress() - hp.getMax() / 100 * 10);
                }
            }
            @Override
            public void onFinish() {
                if(!enb) {
                    countDownTimer.start();
                }
            }
        };
        if(!enb) {
            countDownTimer.start();
        }

        countDownTimer1 = new CountDownTimer(1000000, 5000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Animation animation = AnimationUtils.loadAnimation(Game.this, R.anim.enlarge);
                demon.startAnimation(animation);
                if(MainActivity.levels[0] && attack){
                    hpP -= 10;
                }
                if(MainActivity.levels[0]){
                    hpP -= 2;
                }
                if(MainActivity.levels[1] && attack){
                    hpP -= 20;
                }
                if(MainActivity.levels[1]){
                    hpP -= 4;
                }
                if(MainActivity.levels[2] && attack){
                    hpP -= 40;
                }
                if(MainActivity.levels[2]){
                    hpP -= 8;
                }
                if(MainActivity.levels[3] && attack){
                    hpP -= 50;
                }
                if(MainActivity.levels[3]){
                    hpP -= 10;
                }
                if(MainActivity.levels[4] && attack){
                    hpP -= 60;
                }
                if(MainActivity.levels[4]){
                    hpP -= 12;
                }

            }

            @Override
            public void onFinish() {
                if(!enb) {
                    countDownTimer1.start();
                }

            }
        };
        if(!enb) {
            countDownTimer1.start();
        }



        int array_length = back_images.length;
        View screenView = findViewById(R.id.game);


        demon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(Arrays.toString(MainActivity.levels));
                money.setText(String.valueOf(money1));
                hp.incrementProgressBy(damage);
                Animation animation = AnimationUtils.loadAnimation(Game.this, R.anim.rotate);
                demon.startAnimation(animation);
                if(hp.getMax() <= hp.getProgress()) {
                    System.out.println(hp.getMax());
                    System.out.println(hp.getProgress());
                    counter -= 1;
                    TextView count = ((TextView) findViewById(R.id.textView34));
                    count.setText(String.valueOf(counter));
                    money1 += money_plus;
                    hp.setProgress(0);
                    if(f_boss){
                        win = true;
                    }
                    if(MainActivity.levels[4]){
                        int rndo = rnd.nextInt(6);
                        demon.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), demons_im[rndo]));
                        name.setText(demons_n[rndo]);
                        hp.setMax(demons_hp[rndo]);
                        money_plus = demons_m[rndo];
                        screenView.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.pomeste));
                    }
                    if(MainActivity.levels[3]){
                        int rndo = rnd.nextInt(5);
                        demon.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), demons_im[rndo]));
                        name.setText(demons_n[rndo]);
                        hp.setMax(demons_hp[rndo]);
                        money_plus = demons_m[rndo];
                        screenView.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.backnight));
                    }

                    if(MainActivity.levels[2]){
                        int rndo = rnd.nextInt(4);
                        demon.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), demons_im[rndo]));
                        name.setText(demons_n[rndo]);
                        hp.setMax(demons_hp[rndo]);
                        money_plus = demons_m[rndo];
                        screenView.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.backfon));
                    }
                    if(MainActivity.levels[1]){

                        int rndo = rnd.nextInt(3);
                        demon.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), demons_im[rndo]));
                        name.setText(demons_n[rndo]);
                        hp.setMax(demons_hp[rndo]);
                        money_plus = demons_m[rndo];
                        screenView.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.train));
                    }

                    if (MainActivity.levels[0]){
                        int rndo = rnd.nextInt(2);
                        System.out.println(rndo);
                        demon.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),demons_im[rndo]));
                        name.setText(demons_n[rndo]);
                        hp.setMax(demons_hp[rndo]);
                        money_plus = demons_m[rndo];
                    }

                }
                if(MainActivity.levels[0] && attack){
                    attack = false;
                    MainActivity.levels[0] = false;
                    MainActivity.levels[1] = true;
                    demon.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), demons_im[2]));
                    name.setText(demons_n[2]);
                    hp.setMax(demons_hp[2]);
                    money_plus = demons_m[2];

                }
                if(MainActivity.levels[1] && attack){
                    attack = false;
                    MainActivity.levels[1] = false;
                    MainActivity.levels[2] = true;
                    demon.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), demons_im[3]));
                    name.setText(demons_n[3]);
                    hp.setMax(demons_hp[3]);
                    money_plus = demons_m[3];

                }
                if(MainActivity.levels[2] && attack){
                    attack = false;
                    MainActivity.levels[2] = false;
                    MainActivity.levels[3] = true;
                    demon.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), demons_im[4]));
                    name.setText(demons_n[4]);
                    hp.setMax(demons_hp[4]);
                    money_plus = demons_m[4];
                }
                if(MainActivity.levels[3] && attack){
                    attack = false;
                    MainActivity.levels[3] = false;
                    MainActivity.levels[4] = true;
                    demon.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), demons_im[5]));
                    name.setText(demons_n[5]);
                    hp.setMax(demons_hp[5]);
                    money_plus = demons_m[5];

                }
                if(MainActivity.levels[4] && attack){
                    attack = false;
                    hp.setMax(10000);
                    name.setText("Мудзан");
                    demon.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.muzan));
                    f_boss = true;
                }




            }
        });
        findViewById(R.id.heal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.bought1[0] && hpP + 50 <= hpPM){
                    hpP += 50;
                    hpt.setText(String.valueOf(hpP));
                    MainActivity.bought1[0] = false;
                }
                else if(hpPM == hpP && MainActivity.bought1[0]){
                    Toast.makeText(getApplicationContext(), "МАКСИМУМ", Toast.LENGTH_LONG).show();
                }
                else if(hpP + 50 > hpPM && MainActivity.bought1[0]){
                    MainActivity.bought1[0] = false;
                    hpP = hpPM;
                }
                else{
                    Toast.makeText(getApplicationContext(), "НЕ ЭКИПИРОВАНО", Toast.LENGTH_LONG).show();
                }
            }
        });

        findViewById(R.id.poison).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.bought1[1] && !enb1) {
                    enb1 = true;
                    MainActivity.bought1[1] = false;
                    counterP.setVisibility(View.VISIBLE);
                    countDownPoison = new CountDownTimer(15000, 1000) {

                        @Override
                        public void onTick(long millisUntilFinished) {
                            hp.setProgress(hp.getProgress() + hp.getMax() / 100 * 15);
                            int count = Integer.parseInt(counterP.getText().toString());
                            count -= 1;
                            counterP.setText(String.valueOf(count));

                        }

                        @Override
                        public void onFinish() {
                            enb1 = false;
                            counterP.setVisibility(View.INVISIBLE);
                            counterP.setText(String.valueOf(15));

                        }
                    };
                    countDownPoison.start();
                }
                else if(enb1){
                    Toast.makeText(getApplicationContext(), "УЖЕ ИСПОЛЬЗУЕТСЯ", Toast.LENGTH_LONG).show();
                }
                else{
                        Toast.makeText(getApplicationContext(), "НЕ ЭКИПИРОВАНО", Toast.LENGTH_LONG).show();
                    }
            }
        });

        findViewById(R.id.imageView12).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.bought1[2] && !enb) {
                    counterF.setVisibility(View.VISIBLE);
                    MainActivity.bought1[2] = false;
                    enb = true;
                    countDownTimer.onFinish();
                    countDownTimer1.onFinish();
                    countDownTimer.cancel();
                    countDownTimer1.cancel();
                    countDownFreez = new CountDownTimer(10000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            int count = Integer.parseInt(counterF.getText().toString());
                            count -= 1;
                            counterF.setText(String.valueOf(count));
                        }

                        @Override
                        public void onFinish() {
                            counterF.setVisibility(View.INVISIBLE);
                            countDownTimer.start();
                            countDownTimer1.start();
                            counterF.setText(String.valueOf(10));
                            enb = false;
                        }
                    };
                    countDownFreez.start();
                }
                else if(enb){
                    Toast.makeText(getApplicationContext(), "УЖЕ ИСПОЛЬЗУЕТСЯ", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "НЕ ЭКИПИРОВАНО", Toast.LENGTH_LONG).show();
                }
            }
        });
        countDownUlta = new CountDownTimer(60000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int count = Integer.parseInt(time.getText().toString());
                count -= 1;
                time.setText(String.valueOf(count));
            }

            @Override
            public void onFinish() {
                time.setText(String.valueOf(10));
                MainActivity.sup[0] = true;
                punch.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.punch));
                punch.setBackgroundColor(0);
            }
        };
        countDownUlta.start();
        findViewById(R.id.superpunch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.sup[0]){
                    damage *= kulta;
                    countDownUlta1 = new CountDownTimer(10000,1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            int count = Integer.parseInt(time.getText().toString());
                            count -= 1;
                            time.setText(String.valueOf(count));
                        }

                        @Override
                        public void onFinish() {
                            time.setText(String.valueOf(60));
                            countDownUlta.start();
                            punch.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.punch));
                            int color = getResources().getColor(R.color.black);
                            punch.setBackgroundColor(color);
                            MainActivity.sup[0] = false;
                            damage /= kulta;
                        }

                    };
                    countDownUlta1.start();
                }
                else{
                    Toast.makeText(getApplicationContext(), "ПЕРЕЗАРЯДКА", Toast.LENGTH_LONG).show();
                }
            }
        });

        

    }

    public void Shop(View v){
        Intent intent;
        intent = new Intent(Game.this, Shop.class);
        startActivity(intent);

    }
    public void Shop1(View v){
        Intent intent;
        intent = new Intent(Game.this, Shop1.class);
        startActivity(intent);
    }
    public void boss(View v){
        attack = true;
        boss.setEnabled(false);
        count.setVisibility(View.VISIBLE);
        counter = 10;
        boss.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.bossb));
    }

    @Override
    protected void onStart(){
        super.onStart();
        money.setText(String.valueOf(money1));
        hpt.setText(String.valueOf(hpP));
        d.setText(String.valueOf(damage));

    }

}