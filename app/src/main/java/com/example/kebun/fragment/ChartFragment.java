package com.example.kebun.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kebun.R;
import com.example.kebun.adapter.ChartAdapter;
import com.example.kebun.adapter.KaosAdapter;
import com.example.kebun.database.AppDatabase;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChartFragment extends Fragment {
    RecyclerView recyclerView;
    ChartAdapter chartAdapter;
    AppDatabase appDatabase;
    Context context;

    public ChartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chart, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.chart_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        appDatabase = AppDatabase.iniDb(getContext());
        readData(appDatabase);
    }
    public void readData(AppDatabase appDatabase){
        List list;
        list = appDatabase.dao().getData();
        chartAdapter = new ChartAdapter(context, list);
        recyclerView.setAdapter(chartAdapter);

    }
}
