package com.example.myapplication.adapter.nguoi_thue_adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.dao.EventDAO;
import com.example.myapplication.dao.HomeDao;
import com.example.myapplication.itf.IClickitemEvent;
import com.example.myapplication.itf.IClickitemHome;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder>{
    private List<HomeDao> mListHome;
    private IClickitemHome iClickitemHome;
    public HomeAdapter(List<HomeDao> mListhome, IClickitemHome listener) {
        this.mListHome = mListhome;
        this.iClickitemHome = listener;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home,parent,false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        final HomeDao homeDao = mListHome.get(position);
        if(homeDao==null) {
            return;
        }
        holder.tenbaibao.setText(homeDao.getTenbaibao());
        holder.ndbaibao.setText(homeDao.getNoidungBaibao());
        holder.imageView.setImageResource(homeDao.getImahome());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iClickitemHome.onClickitemHome(homeDao);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mListHome!=null)
            return mListHome.size();
        return 0;
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        private TextView tenbaibao;
        private TextView ndbaibao;
        private ImageView imageView;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.layout_item_home);
            tenbaibao = itemView.findViewById(R.id.tenbaibao);
            ndbaibao = itemView.findViewById(R.id.ndbaibao);
            imageView =itemView.findViewById(R.id.img_home);
        }
    }
}
