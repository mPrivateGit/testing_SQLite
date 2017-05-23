//package com.example.aprivate.testing_sqlite.bin;
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.support.v7.widget.DividerItemDecoration;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Toast;
//
//import com.example.aprivate.testing_sqlite.R;
//import com.example.aprivate.testing_sqlite.adapters.CustomAdapter;
//
//import java.util.List;
//
//
//
//public class RecyclerViewFragment extends Fragment {
//    private RecyclerView mRecyclerView;
//    private CustomAdapter mCustomAdapter;
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
//                             @Nullable Bundle savedInstanceState) {
//        View v = inflater.inflate(R.layout.activity_recycler_view, container, false);
//        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view_id);
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(),
//                DividerItemDecoration.VERTICAL));
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//
//        updateUI();
//
//        return v;
//    }
//
//
//    private void updateUI() {
//        if (mCustomAdapter == null) {
//            Collection collection = Collection.getInstance();
//            List<Contacts> contactses = collection.getContacts();
//            mCustomAdapter = new CustomAdapter(contactses,
//                    new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int position = mRecyclerView.getChildLayoutPosition(v);
//                    Toast.makeText(getActivity(),
//                            " clicked: "+position, Toast.LENGTH_SHORT).show();
//                }
//            });
//            mRecyclerView.setAdapter(mCustomAdapter);
//        } else {
//            mCustomAdapter.notifyDataSetChanged();
//        }
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        updateUI();
//    }
//}
