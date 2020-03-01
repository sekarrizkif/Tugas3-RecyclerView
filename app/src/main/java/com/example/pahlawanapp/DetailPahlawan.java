package com.example.pahlawanapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailPahlawan extends AppCompatActivity {

    ImageView detail_iv;
    TextView detail_judul, detail_deskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_pahlawan);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        detail_iv = findViewById(R.id.detailfoto_iv);
        detail_judul = findViewById(R.id.judul_tv);
        detail_deskripsi = findViewById(R.id.deskripsi_tv);

        getIncomingIntent();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void getIncomingIntent(){
        Bundle bundle = getIntent().getExtras();
        if(bundle !=null){
            int ivimage = bundle.getInt("img_url");
            Glide.with(getApplicationContext()).load(ivimage).into(detail_iv);
            String getDesc = bundle.getString("detail");
            String getTitle= bundle.getString("name");

            detail_deskripsi.setText(getDesc);
            detail_judul.setText(getTitle);
        }
    }



}

