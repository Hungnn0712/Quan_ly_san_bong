package com.example.myapplication.adapter.nguoi_thue_adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.entity.ThongBao;

import java.util.ArrayList;
import java.util.Base64;

public class ThongBaoAdapter extends RecyclerView.Adapter<ThongBaoAdapter.ThongBaoViewHolder> {
    private Context context;
    private ArrayList<ThongBao> dsm;

    public ThongBaoAdapter(Context context, ArrayList<ThongBao> list) {
        this.context = context;
        this.dsm = list;
    }

    @NonNull
    @Override
    public ThongBaoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_thongbao, parent, false);
        ThongBaoViewHolder viewHolder = new ThongBaoViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ThongBaoViewHolder holder, int position) {
        ThongBao lg = dsm.get(position);
        holder.tengiai.setText(lg.getTenGiai());
        holder.thongtin.setText(lg.getThongTin());
    }

    @Override
    public int getItemCount() {
        return dsm.size();
    }

    class ThongBaoViewHolder extends RecyclerView.ViewHolder{
        TextView tengiai,thongtin;

        public ThongBaoViewHolder(@NonNull View view) {
            super(view);
            tengiai = view.findViewById(R.id.tieudetb);
            thongtin = view.findViewById(R.id.noidungtb);
        }
    }
}
