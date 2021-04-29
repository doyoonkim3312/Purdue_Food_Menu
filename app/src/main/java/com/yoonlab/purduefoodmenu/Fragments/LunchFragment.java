package com.yoonlab.purduefoodmenu.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yoonlab.purduefoodmenu.Models.Item;
import com.yoonlab.purduefoodmenu.Models.Menu;
import com.yoonlab.purduefoodmenu.Models.Station;
import com.yoonlab.purduefoodmenu.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LunchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LunchFragment extends Fragment {

    private ArrayList<String> lunchResult = new ArrayList<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LunchFragment(Menu lunchMenu) {
        for (Station station: lunchMenu.getMeals().getMealList().get(1).getStations()
                .getStationList()) {
            for (Item item: station.getItems().getItemList()) {
                lunchResult.add(item.getItemName());
            }
        }
    }

    public LunchFragment() {
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
        View view = inflater.inflate(R.layout.fragment_lunch, container, false);
        return view;
    }
}