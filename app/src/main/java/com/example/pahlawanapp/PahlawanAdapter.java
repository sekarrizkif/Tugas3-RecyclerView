package com.example.pahlawanapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class PahlawanAdapter extends RecyclerView.Adapter<PahlawanAdapter.ViewHolder> {

    private ArrayList<PahlawanModel> listPahlawan;
    private Context context;

    public PahlawanAdapter (Context context) {
        this.context = context;
    }

    public ArrayList<PahlawanModel> getListPahlawan() {
        return listPahlawan;
    }

    public void setListPahlawan(ArrayList<PahlawanModel> listPahlawan) {
        this.listPahlawan = listPahlawan;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemrow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listpahlawan, parent, false);
        return new ViewHolder(itemrow);
    }

    @Override
    public void onBindViewHolder(@NonNull PahlawanAdapter.ViewHolder viewHolder, final int i) {
        Glide.with(context).load(getListPahlawan().get(i).getFoto()).into(viewHolder.ivPahlawan);
        viewHolder.tvNama.setText(getListPahlawan().get(i).getNama());
        viewHolder.btnLihat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailPahlawan.class);

                intent.putExtra("img_url", getListPahlawan().get(i).getFoto());
                intent.putExtra("name", getListPahlawan().get(i).getNama());
                intent.putExtra("detail", getListPahlawan().get(i).getDetail());
                context.startActivity(intent);
            }
        });

        viewHolder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String namaPahlawan = "Pahlawan ini adalah " + getListPahlawan().get(i).getDetail();
                intent.putExtra(Intent.EXTRA_TEXT, namaPahlawan);
                context.startActivity(Intent.createChooser(intent, "Share Using"));
            }
        });

    }

    @Override
    public int getItemCount() {
        return getListPahlawan().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPahlawan;
        TextView tvNama;
        Button btnShare, btnLihat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPahlawan = itemView.findViewById(R.id.item_iv);
            tvNama = itemView.findViewById(R.id.nama_tv);
            btnLihat = itemView.findViewById(R.id.lihat_btn);
            btnShare = itemView.findViewById(R.id.share_btn);
        }
    }
}

