package com.example.aprivate.testing_sqlite.bin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aprivate.testing_sqlite.R;
import com.example.aprivate.testing_sqlite.adapters.CustomAdapter;


public class RecyclerViewFragment extends Fragment {


    protected RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.recyclerview_lis, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view_id);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(),
                DividerItemDecoration.VERTICAL));
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        CustomAdapter mCustomAdapter = new CustomAdapter();
        mRecyclerView.setAdapter(mCustomAdapter);
    }
}
