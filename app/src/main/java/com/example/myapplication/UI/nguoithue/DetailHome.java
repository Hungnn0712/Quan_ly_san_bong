package com.example.myapplication.UI.nguoithue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.dao.EventDAO;
import com.example.myapplication.dao.HomeDao;

public class DetailHome extends AppCompatActivity {
    TextView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_home);
        Bundle bundle = getIntent().getExtras();
        HomeDao homeDao = (HomeDao) bundle.get("object_home");
        TextView tenbaibaoc = findViewById(R.id.dttenbaibao);
        TextView ndbaibaoc = findViewById(R.id.dtndbaibao);
        ImageView imaga = findViewById(R.id.dtimahome);
        tenbaibaoc.setText(homeDao.getTenbaibao());
        ndbaibaoc.setText(homeDao.getNoidungBaibao());
        imaga.setImageResource(homeDao.getImahome());
    }
}