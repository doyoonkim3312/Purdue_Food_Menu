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

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BreakfastFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BreakfastFragment extends Fragment {

    private ArrayList<String> breakfastResult = new ArrayList<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BreakfastFragment(Menu breakfastMenu) {
        for (Station station: breakfastMenu.getMeals().getMealList().get(0).getStations()
                .getStationList()) {
            for (Item item: station.getItems().getItemList()) {
                breakfastResult.add(item.getItemName());
            }
        }
    }

    public BreakfastFragment() {
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
        View view = inflater.inflate(R.layout.fragment_breakfast, container, false);

        return view;
    }
}