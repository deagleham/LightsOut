package com.example.lightsout;

import static android.graphics.Color.*;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Button;

import androidx.annotation.NonNull;
//author@ De'Ante Agleham
//October 8

@SuppressLint("AppCompatCustomView")
public class ChangeButton extends Button {
    int x;
    int y;
    boolean color;

    public ChangeButton(Context context, int posX, int posY, boolean col) {
        super(context);
        x = posX;
        y = posY;
        color = col;
    }

    //finds value of x
    public int findX() {
        return x;
    }

    //finds value of x
    public int findY() {
        return y;
    }

    //returns color as a boolean value
    public boolean getColor(){
        return color;
    }

    //switches color of button when called
    public void changeColor(){
        if(color){
            color = false;
            setBackgroundColor(BLACK);
        }
        else{
            color = true;
            setBackgroundColor(WHITE);
        }
    }

    //swaps colors of button and adjacent buttons
    public void colorFlip(@NonNull ChangeButton[][] t, int x, int y){
        t[x][y].changeColor();
        if(x<t.length-1){
            t[x+1][y].changeColor();
        }
        if(x>0){
            t[x-1][y].changeColor();
        }
        if(y<t[0].length-1){
            t[x][y+1].changeColor();
        }
        if(y>0){
            t[x][y-1].changeColor();
        }
    }

    //checks if the win condition has been met
    public boolean win(ChangeButton[][] t){
        int max = t.length * t[0].length;
        int count = 0;
        for(int x=0; x<t.length; x++){
            for(int y = 0; y<t[0].length; y++){
                if(t[x][y].getColor() == false){
                    count ++;
                }
            }
        }
        if(count == max){
            return true;
        }
        return false;
    }
}
