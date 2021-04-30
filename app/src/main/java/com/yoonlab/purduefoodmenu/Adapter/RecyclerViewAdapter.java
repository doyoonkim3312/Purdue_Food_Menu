package com.yoonlab.purduefoodmenu.Adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yoonlab.purduefoodmenu.Models.Item;
import com.yoonlab.purduefoodmenu.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<MainViewHolder> {
    private ArrayList<Item> itemList;

    public RecyclerViewAdapter (ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.recycler_view_item_layout, parent, false);
        MainViewHolder viewHolder = new MainViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.itemText.setText(itemList.get(position).getItemName());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}

class MainViewHolder extends RecyclerView.ViewHolder {

    TextView itemText;

    public MainViewHolder(@NonNull View itemView) {
        super(itemView);
        itemText = itemView.findViewById(R.id.itemTextView);
    }
}
