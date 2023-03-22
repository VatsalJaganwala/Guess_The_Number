package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button easy;
    Button hard;
    int num;
    private long pressedTime;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        easy=findViewById(R.id.easy);
        hard=findViewById(R.id.hard);
        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = (int)(Math.random()*(10+1));
                sendNum(num,5);
            }
        });
        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = (int)(Math.random()*(100+1));
                sendNum(num,7);
            }
        });

    }
    public void sendNum(int num,int chance){
        Intent game= new Intent(getApplicationContext(),gameScreen.class);
        game.putExtra("number",String.valueOf(num));
        game.putExtra("chance",String.valueOf(chance));
        startActivity(game);
    }
    @Override
    public void onBackPressed() {


        if (pressedTime + 2000 > System.currentTimeMillis()) {
            finishAffinity();

        } else {
            Toast.makeText(getBaseContext(), "Press home button to exit", Toast.LENGTH_SHORT).show();
        }
        pressedTime = System.currentTimeMillis();
    }
}
