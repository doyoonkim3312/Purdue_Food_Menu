package com.yoonlab.purduefoodmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.yoonlab.purduefoodmenu.Adapter.ViewPagerAdapter;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    final String[] tabNames = {"Breakfast", "Lunch", "Dinner"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent arrivedIntent = getIntent();
        String courtName = arrivedIntent.getExtras().getString("court");

        TextView titleText = findViewById(R.id.courtNameTextView);
        titleText.setText(courtName);

        TabLayout mainTabLayout = findViewById(R.id.resultTabLayout);
        ViewPager2 mainViewPager = findViewById(R.id.resultViewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this, courtName,
                this.getApplicationContext());
        // If this getApplicationContext doesn't work, change parameter from context to date formatted
        // String value.

        mainViewPager.setAdapter(viewPagerAdapter);
        new TabLayoutMediator(mainTabLayout, mainViewPager,
                ((tab, position) -> tab.setText(tabNames[position]))
        ).attach();

    }
}