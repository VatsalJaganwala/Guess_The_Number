package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class result extends AppCompatActivity {
    Button home;
    TextView numdec;
    TextView op;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent result = getIntent();
        String output = result.getStringExtra("result");
        String num = result.getStringExtra("number");
        Intent gohome = new Intent(getApplicationContext(),MainActivity.class);
        MediaPlayer yeah = MediaPlayer.create(this, R.raw.yeah);
        MediaPlayer no = MediaPlayer.create(this, R.raw.no);
        op = findViewById(R.id.output);
        numdec = findViewById(R.id.numdec);
        home = findViewById(R.id.hellohome);
//        Toast.makeText(this, output, Toast.LENGTH_SHORT).show();
        if(Objects.equals(output, "1")) {
            op.setText("You Won");
            yeah.start();
        }
        else  if(Objects.equals(output, "0")) {
            op.setText("You Lost");
            no.start();
        }
        numdec.setText("Number was "+ num);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(gohome);
            }
        });

    }
}