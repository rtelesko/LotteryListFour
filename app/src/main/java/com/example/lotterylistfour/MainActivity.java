package com.example.lotterylistfour;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/*
The RecyclerView class supports the display of a collection of data. It is a modernized version of the
ListView and the GridView classes provided by the Android framework.
Advantages:
a) Memory usage: Recycler View allows to display thousands rows data with optimized memory usage.
It shows data like list view but unlike list view it only initializes the number of item views that
could be displayed on screen with 2–3 extra margin of item views for smooth transaction
i.e. if there is 100 rows of data but only 6 can be displayed on screen at one time so it will give
memory to only 6 item views plus 4 more, 2 for above and 2 for below so memory will be allocated only
for 10 item views in case of the recycler view and same will consume memory for 100 item views in case of the
list view.
b) It also comes with default animations for removing and adding elements.
c) RecyclerView allow to use different layout managers for positioning items.

Mode:
Recycler view uses a ViewHolder to store references to the views for one entry in the recycler view.
A ViewHolder class is a static inner class in your adapter which holds references to the relevant views.
With these references your code can avoid the time-consuming findViewById() method to update the widgets with new data.

Adapter (Required): Provides the data and responsible for creating the views for the individual entry
ViewHolder (Required): Contains references for all views that are filled by the data of the entry
LayoutManager (Required, but default implementations available): Contains references for all views that
are filled by the data of the entry
ItemDecoration (Default behavior, but can be overridden): Responsible for drawing decorations around or on top of the view container of an entry
 */

public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

    MyRecyclerViewAdapter adapter;
    // ArrayList for storing the data
    ArrayList<String> tips = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Data to populate the RecyclerView with
        tips.add("Tip 1");
        tips.add("Tip 2");
        tips.add("Tip 3");
        tips.add("Tip 4");
        tips.add("Tip 5");
        tips.add("Tip 6");
        tips.add("Tip 7");
        tips.add("Tip 8");
        tips.add("Tip 9");
        tips.add("Tip 10");
        tips.add("Tip 11");
        tips.add("Tip 12");
        tips.add("Tip 13");
        tips.add("Tip 14");
        tips.add("Tip 15");

        // Set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvTips);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL));
        adapter = new MyRecyclerViewAdapter(this, tips);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    // Alternative 1: Toast message for clicking the item
    /*
    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_LONG).show();
    }
    */

    // Alternative 2: Removing an item when clicking
    @Override
    public void onItemClick(View view, int position) {
        String item = tips.get(position);
        tips.remove(position);
        adapter.notifyItemRemoved(position);
        adapter.notifyItemRangeChanged(position, tips.size());
        // Show the removed item label`enter code here`
        Toast.makeText(this, "Item removed : " + item, Toast.LENGTH_SHORT).show();
    }
}