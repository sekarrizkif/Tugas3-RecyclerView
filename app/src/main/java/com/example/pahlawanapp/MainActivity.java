package com.example.pahlawanapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvPahlawan;
    private ArrayList<PahlawanModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPahlawan = findViewById(R.id.activitymain_rv);
        rvPahlawan.setHasFixedSize(true);
        list.addAll(DataPahlawan.getHeroList());

        showRecyclerList();
    }
    private void showRecyclerList(){
        rvPahlawan.setLayoutManager(new LinearLayoutManager(this));
        PahlawanAdapter pahlawanAdapter = new PahlawanAdapter(this);
        pahlawanAdapter.setListPahlawan(list);
        rvPahlawan.setAdapter(pahlawanAdapter);

    }
}
