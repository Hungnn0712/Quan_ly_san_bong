package com.example.myapplication.adapter;

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
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.entity.ThongBao;

import java.util.ArrayList;
import java.util.Base64;

public class GuiThongBaoAdapter extends RecyclerView.Adapter<GuiThongBaoAdapter.GuiThongBaoViewHolder> {
    private ArrayList<ThongBao> dsm;
    private Context c;

    public GuiThongBaoAdapter( Context c,ArrayList<ThongBao> dsm) {
        this.dsm = dsm;
        this.c = c;
    }

    @NonNull
    @Override
    public GuiThongBaoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) c).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_guithongbao, parent, false);
        GuiThongBaoViewHolder viewHolder = new GuiThongBaoViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GuiThongBaoViewHolder holder, int position) {
        ThongBao lg = dsm.get(position);
        holder.tieude.setText(lg.getTenGiai());
        holder.noidung.setText(lg.getThongTin());
    }

    @Override
    public int getItemCount() {
        return dsm.size();
    }

    class GuiThongBaoViewHolder extends RecyclerView.ViewHolder{
        TextView ngay,noidung,tieude;
        CardView cardView;
        public GuiThongBaoViewHolder(@NonNull View view) {
            super(view);
            tieude = view.findViewById(R.id.tieudetb);
            noidung = view.findViewById(R.id.noidungtb);
            cardView = view.findViewById(R.id.cardviewloai21);
        }
    }
}
