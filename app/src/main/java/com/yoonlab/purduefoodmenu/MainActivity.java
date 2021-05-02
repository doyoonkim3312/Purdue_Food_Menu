package com.yoonlab.purduefoodmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.xml.transform.Result;


public class MainActivity extends AppCompatActivity { //Activity is like page with in the book(App)

    private boolean buttonClickStatus = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //Protected = Kind of like a mid level between public and private
        // Treat this method as a public static void main String[] args() {...}
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //**********************************************************************************************

        //Buttons
        findViewById(R.id.earhartButton).setOnClickListener(startActivityWithIntent("Earhart"));
        findViewById(R.id.fordButton).setOnClickListener(startActivityWithIntent("Ford"));
        findViewById(R.id.hillenbrandButton).setOnClickListener(startActivityWithIntent("Hillenbrand"));
        findViewById(R.id.wileyButton).setOnClickListener(startActivityWithIntent("Wiley"));
        findViewById(R.id.windsorButton).setOnClickListener(startActivityWithIntent("Windsor"));
    }

    public View.OnClickListener startActivityWithIntent(String courtName) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("court", courtName);
                startActivity(intent);
            }
        };
    }
}