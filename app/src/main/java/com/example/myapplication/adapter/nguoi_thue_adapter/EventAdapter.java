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
import com.example.myapplication.UI.nguoithue.DetailEvent;
import com.example.myapplication.UI.nguoithue.EventFragment;
import com.example.myapplication.dao.EventDAO;
import com.example.myapplication.itf.IClickitemEvent;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {
    private List<EventDAO> mListEvent;
    private IClickitemEvent iClickitemEvent;
    public EventAdapter(List<EventDAO> mListEvent, IClickitemEvent listener) {
        this.mListEvent = mListEvent;
        this.iClickitemEvent = listener;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event,parent,false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        final EventDAO eventDAO = mListEvent.get(position);
        if(eventDAO==null) {
            return;
        }
        holder.tvname.setText(eventDAO.getName());
        holder.tvngaykt.setText(eventDAO.getName());
        holder.tvngaybd.setText(eventDAO.getName());
        holder.imevent.setImageResource(eventDAO.getImevent());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iClickitemEvent.onClickitemEvent(eventDAO);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mListEvent!=null)
            return mListEvent.size();
        return 0;
    }

    public class EventViewHolder extends RecyclerView.ViewHolder{
        private TextView tvname;
        private TextView tvngaybd;
        private TextView tvngaykt;
        private ImageView imevent;
        private CardView cardView;
        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.layout_item_event);
            tvname = itemView.findViewById(R.id.nameevent);
            tvngaybd = itemView.findViewById(R.id.ngaybd);
            tvngaykt = itemView.findViewById(R.id.ngaykt);
            imevent = itemView.findViewById(R.id.imevent);
        }
    }
}
