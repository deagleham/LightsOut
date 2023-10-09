package com.example.lightsout;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.WHITE;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
//De'Ante Agleham
//October 8
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button[][] layout = new Button[5][5];
        LinearLayout column = findViewById(R.id.layout);
        Button reset = findViewById(R.id.reset);

        for(int y = 0; y < 5; y++){
            LinearLayout row = new LinearLayout(this);
            column.addView(row);
            for(int x = 0; x < 5; x++){
                int random = (int)(2*Math.random());
                Button button = new Button(this);
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
        view.setBackgroundColor(BLACK);
    }
}