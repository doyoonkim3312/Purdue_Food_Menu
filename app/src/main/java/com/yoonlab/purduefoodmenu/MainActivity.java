package com.yoonlab.purduefoodmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

        
public class MainActivity extends AppCompatActivity { //Activity is like page with in the book(App)

    private boolean buttonClickStatus = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //Protected = Kind of like a mid level between public and private
        // Treat this method as a public static void main String[] args() {...}  
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //**********************************************************************************************
        TextView Hello_World = findViewById(R.id.helloWorld_TextView);
        Button Test_Button = findViewById(R.id.testBtn);


        Test_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonClickStatus == false) {
                    Hello_World.setText("This is my first Android Application!");
                    buttonClickStatus = true;
                } else {
                    Hello_World.setText("Hello World");
                    buttonClickStatus= false;
                }
            }
        });
    }
}