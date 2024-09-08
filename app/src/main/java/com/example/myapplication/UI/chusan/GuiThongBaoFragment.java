package com.example.myapplication.UI.chusan;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;
import com.example.myapplication.adapter.GuiThongBaoAdapter;
import com.example.myapplication.entity.ThongBao;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GuiThongBaoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GuiThongBaoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ArrayList<ThongBao> list = new ArrayList<>();
    GuiThongBaoAdapter adapter;
    DatabaseReference databaseReference;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GuiThongBaoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GuiThongBaoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GuiThongBaoFragment newInstance(String param1, String param2) {
        GuiThongBaoFragment fragment = new GuiThongBaoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.rvtb);
        FloatingActionButton add = view.findViewById(R.id.themtb);
        LinearLayoutManager layoutManager= new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        list.clear();
        getList();
        adapter = new GuiThongBaoAdapter(getContext(),list);
        recyclerView.setAdapter(adapter);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                LayoutInflater layoutInflater = ((Activity)getContext()).getLayoutInflater();
                View v2 = layoutInflater.inflate(R.layout.dialog_addtb,null);
                builder.setView(v2);
                AlertDialog dialog = builder.create();
                dialog.show();
                EditText nhaptd = v2.findViewById(R.id.nhaptdtb);
                EditText nhap = v2.findViewById(R.id.nhaptb);
                Button addvao = v2.findViewById(R.id.addtb);
                Button huy = v2.findViewById(R.id.huytb);
                addvao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ThongBao thongBao = new ThongBao(nhaptd.getText().toString(),nhap.getText().toString());
                        databaseReference.child("ThongBao").push().setValue(thongBao);
                        list.clear();
                        adapter.notifyDataSetChanged();
                        dialog.dismiss();
//                        thongBao();
                    }
                });
                huy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });
    }

    private void getList() {
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("ThongBao").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    ThongBao thongBao = dataSnapshot.getValue(ThongBao.class);
                    list.add(thongBao);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gui_thong_bao, container, false);
    }
}