package com.codenamerockeyrecyclerviewapp.recyclerviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import Adapter.Model.myAdapter;
import Model.ListItem;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();

        //Adding things to the recycler view by one by one
//        ListItem item1 = new ListItem("Movie 1", "This movie is about someone crazy!!", " Wow! Great Movie");
//        ListItem item2 = new ListItem("Movie 2", "This movie is about love!!", " How romantic 5 Stars!!!!");

// loops through all ten items
        for (int i = 0; i < 10;  i++) {
            ListItem item = new ListItem(
                    "Item " + (i + 1),
                    "Description",
                    "Excellent"
            );

           listItems.add(item);
        //displaying those movies items one by one
//            listItems.add(item1);
//            listItems.add(item2);
       }

        adapter = new myAdapter(this, listItems);
        recyclerView.setAdapter(adapter);
    }
}
