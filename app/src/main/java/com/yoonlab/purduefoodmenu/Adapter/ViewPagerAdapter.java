package com.yoonlab.purduefoodmenu.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.yoonlab.purduefoodmenu.Fragments.BreakfastFragment;
import com.yoonlab.purduefoodmenu.Fragments.DinnerFragment;
import com.yoonlab.purduefoodmenu.Fragments.LunchFragment;
import com.yoonlab.purduefoodmenu.Models.Menu;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ViewPagerAdapter extends FragmentStateAdapter {

    private Calendar calendar = Calendar.getInstance();
    private String courtName;

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity, String courtName) {
        super(fragmentActivity);
        this.courtName = courtName;

        //Start API connection.
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        SimpleDateFormat mdyFormat = new SimpleDateFormat("MM-dd-yyyy");
        String timePath = mdyFormat.format(calendar.getTime());

        switch (position) {
            case 0: {
                return new BreakfastFragment();
            }
            case 1: {
                return new LunchFragment();
            }
            case 2: {
                return new DinnerFragment();
            }
        }
        return new BreakfastFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
