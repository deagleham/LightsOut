package com.example.lightsout;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.WHITE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
//De'Ante Agleham
//October 8
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ChangeButton[][] layout = new ChangeButton[5][5];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout column = findViewById(R.id.layout);
        Button reset = findViewById(R.id.reset);
        //Creates a 5x5 array of buttons with random colors (black or white)
        for(int y = 0; y < 5; y++){
            LinearLayout row = new LinearLayout(this);
            column.addView(row);
            for(int x = 0; x < 5; x++){
                int random = (int)(2*Math.random());
                ChangeButton button = new ChangeButton(this, x, y, random == 1);
                button.setWidth(200);
                button.setHeight(200);
                if(random == 0){
                    button.setBackgroundColor(BLACK);
                }
                else{
                    button.setBackgroundColor(WHITE);
                }
                layout[x][y] = button;
                button.setOnClickListener(this);
                row.addView(button);
            }
        }
        reset.setOnClickListener(layout1 -> recreate());
    }

    @Override
    public void onClick(View view) {
        LinearLayout background = findViewById(R.id.back);
        ChangeButton local = (ChangeButton) view;
        local.colorFlip(layout, local.findX(), local.findY());
        if(local.win(layout)){
            background.setBackgroundColor(GREEN);
        }
    }
}