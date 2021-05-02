package com.yoonlab.purduefoodmenu.Adapter;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.yoonlab.purduefoodmenu.Fragments.BreakfastFragment;
import com.yoonlab.purduefoodmenu.Fragments.DinnerFragment;
import com.yoonlab.purduefoodmenu.Fragments.LunchFragment;
import com.yoonlab.purduefoodmenu.Models.Menu;
import com.yoonlab.purduefoodmenu.apiService;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class ViewPagerAdapter extends FragmentStateAdapter {

    private Calendar calendar = Calendar.getInstance();
    private String courtName;
    private Menu menuResult;

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity, String courtName, Context context) {
        super(fragmentActivity);
        this.courtName = courtName;

        SimpleDateFormat mdyFormat = new SimpleDateFormat("MM-dd-yyyy");
        String timePath = mdyFormat.format(calendar.getTime());

        //Start API connection.
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.hfs.purdue.edu/")
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create()).build();
        Call<Menu> retrofitCall = retrofit.create(apiService.class).getMenu(courtName, timePath);
        retrofitCall.enqueue(new Callback<Menu>() {
            @Override
            public void onResponse(Call<Menu> call, Response<Menu> response) {
                if (response.isSuccessful()) {
                    menuResult = response.body();
                } else {
                    Toast.makeText(context, "Failed: Menu cannot be loaded", Toast.LENGTH_LONG);
                }
            }

            @Override
            public void onFailure(Call<Menu> call, Throwable t) {
                Toast.makeText(context, "CRITICAL", Toast.LENGTH_SHORT);
            }
        });
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {


        switch (position) {
            case 0: {
                return new BreakfastFragment(menuResult);
            }
            case 1: {
                return new LunchFragment(menuResult);
            }
            case 2: {
                return new DinnerFragment(menuResult);
            }
        }
        return new BreakfastFragment(menuResult);
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
