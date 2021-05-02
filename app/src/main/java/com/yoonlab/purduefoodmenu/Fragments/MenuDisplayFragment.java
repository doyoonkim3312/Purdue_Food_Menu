package com.yoonlab.purduefoodmenu.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.yoonlab.purduefoodmenu.Adapter.RecyclerViewAdapter;
import com.yoonlab.purduefoodmenu.Models.Item;
import com.yoonlab.purduefoodmenu.Models.Menu;
import com.yoonlab.purduefoodmenu.Models.Station;
import com.yoonlab.purduefoodmenu.R;
import com.yoonlab.purduefoodmenu.apiService;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class MenuDisplayFragment extends Fragment {
    private String courtName;
    private String timePath;
    private int mealIndex;
    private int currentTime;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MenuDisplayFragment(String courtName, String timePath, String currentTime, int mealIndex) {
        this.courtName = courtName;
        this.timePath = timePath;
        this.mealIndex = mealIndex;
        this.currentTime = Integer.parseInt(currentTime.replace(":", ""));
    }

    public MenuDisplayFragment() {
        //Required Empty Constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_display, container, false);
        RecyclerView breakfastRecyclerView = view.findViewById(R.id.breakfastRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext(),
                LinearLayoutManager.VERTICAL, false);
        breakfastRecyclerView.setLayoutManager(layoutManager);
        breakfastRecyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(), 1));

        //StartAPI Connection.
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.hfs.purdue.edu/")
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create()).build();
        Call<Menu> retrofitCall = retrofit.create(apiService.class).getMenu(courtName, timePath);
        retrofitCall.enqueue(new Callback<Menu>() {
            @Override
            public void onResponse(Call<Menu> call, Response<Menu> response) {
                if (response.isSuccessful()) {
                    Menu MenuResult = response.body();
                    try {
                        System.out.println("Called Success");
                        ArrayList<Item> resultList = new ArrayList<>();
                        for (Station station: MenuResult.getMeals().getMealList().get(mealIndex)
                                .getStations().getStationList()) {
                            for (Item item: station.getItems().getItemList()) {
                                resultList.add(item);
                            }
                        }
                        int[] operating = MenuResult.getMeals().getMealList().get(mealIndex).getHours()
                                .getOperatingInfo();
                        if (currentTime >= operating[0] && currentTime <= operating[1]) {
                            Toast.makeText(view.getContext(), "Status: Open", Toast.LENGTH_LONG)
                                    .show();
                        } else {
                            Toast.makeText(view.getContext(), "Status: Close", Toast.LENGTH_LONG)
                                    .show();
                        }

                        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(resultList);
                        breakfastRecyclerView.setAdapter(recyclerViewAdapter);
                    } catch (NullPointerException npe) {
                        System.out.println("Null Detected");
                        Toast.makeText(view.getContext(), "Menu is not available at this time"
                        , Toast.LENGTH_LONG).show();
                    }
                } else {
                    System.out.println("Null Detected");
                    Toast.makeText(view.getContext(), "Failed: Menu cannot be loaded"
                            , Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Menu> call, Throwable t) {
                Toast.makeText(view.getContext(), "Unable to get Menu for " +
                        courtName, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}