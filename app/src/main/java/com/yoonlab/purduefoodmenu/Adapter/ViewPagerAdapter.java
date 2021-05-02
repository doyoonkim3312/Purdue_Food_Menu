package com.yoonlab.purduefoodmenu.Adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.yoonlab.purduefoodmenu.Fragments.MenuDisplayFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ViewPagerAdapter extends FragmentStateAdapter {

    private Calendar calendar = Calendar.getInstance();
    private String courtName;
    private String timePath;
    // private Menu menuResult = new Menu();

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity, String courtName, Context context) {
        super(fragmentActivity);
        this.courtName = courtName;

        SimpleDateFormat mdyFormat = new SimpleDateFormat("MM-dd-yyyy");
        this.timePath = mdyFormat.format(calendar.getTime());
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0: {
                return new MenuDisplayFragment(courtName, timePath, 0);
            }
            case 1: {
                return new MenuDisplayFragment(courtName, timePath, 1);
            }
            case 2: {
                return new MenuDisplayFragment(courtName, timePath, 2);
            }
        }
        return new MenuDisplayFragment(courtName, timePath, 0);
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
