package com.example.guessthenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class gameScreen extends AppCompatActivity {
    TextView textView;
    String temp;
    TextView Chancesop;
    TextView result;
    TextView lt;
    TextView gt;
    int chance,num;
    @SuppressLint({"MissingInflatedId", "CutPasteId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        MediaPlayer gameon =  MediaPlayer.create(this, R.raw.gameon);
        gameon.start();
        Intent game = getIntent();
        String str = game.getStringExtra("number");
        chance = Integer.parseInt(game.getStringExtra("chance"));
        num=Integer.parseInt(str);
        textView= findViewById(R.id.enterValue);
        Chancesop = findViewById(R.id.chance);
        Chancesop.setText("Chances left: " + String.valueOf(chance));
        result = findViewById(R.id.result);
        result.setText("");
        gt = findViewById(R.id.gt);
        lt = findViewById(R.id.lt);
        Intent result= new Intent(getApplicationContext(),result.class);
        result.putExtra("number",str);


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             temp=textView.getText().toString();
             if(!temp.equals("")){
                 if(num==Integer.parseInt(temp)){
//                     Toast.makeText(gameScreen.this, "You Guess the number", Toast.LENGTH_SHORT).show();
                     result.putExtra("result","1");
                     startActivity(result);

                 }
                 else if(num>Integer.parseInt(temp))
                 {
                     chance--;
                     Chancesop.setText("Chances left: " + String.valueOf(chance));
                     gt.setText(temp);
                     textView.setText("");

                 }
                 else if(num<Integer.parseInt(temp))
                 {
                     chance--;
                     Chancesop.setText("Chances left: " + String.valueOf(chance));
                     lt.setText(temp);
                     textView.setText("");
                 }
                 if(chance==0) {
                     result.putExtra("result","0");
                     startActivity(result);
                 }
             }
            }
        });
    }
}