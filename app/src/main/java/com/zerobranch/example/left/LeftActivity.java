package com.zerobranch.example.left;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zerobranch.example.R;

import java.util.ArrayList;
import java.util.List;

public class LeftActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lleft);

        final RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(new LeftAdapter(getItems()));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private List<String> getItems() {
        List<String> items = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            items.add("item " + i);
        }
        return items;
    }
}
