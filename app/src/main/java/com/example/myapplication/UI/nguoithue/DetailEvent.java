package com.example.myapplication.UI.nguoithue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.dao.EventDAO;

public class DetailEvent extends AppCompatActivity {
TextView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_event);
        Bundle bundle = getIntent().getExtras();
        EventDAO eventDAO = (EventDAO) bundle.get("object_event");
        TextView textname = findViewById(R.id.tv_name_event);
        TextView daybd = findViewById(R.id.daybd);
        TextView daykt = findViewById(R.id.daykt);
        ImageView dtim = findViewById(R.id.dtima);
        TextView ndgiaidauc = findViewById(R.id.ndgiaidau);
        textname.setText(eventDAO.getName());
        daybd.setText(eventDAO.getNgaybd());
        daykt.setText(eventDAO.getNgaykt());
        ndgiaidauc.setText((eventDAO.getThongtinevent()));
        dtim.setImageResource(eventDAO.getImevent());
        back = findViewById(R.id.backdetail);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}