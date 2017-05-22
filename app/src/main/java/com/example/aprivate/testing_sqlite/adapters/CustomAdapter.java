//package com.example.aprivate.testing_sqlite.adapters;
//
//
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Toast;
//
//import com.example.aprivate.testing_sqlite.R;
//import com.example.aprivate.testing_sqlite.bin.Collection;
//import com.example.aprivate.testing_sqlite.bin.Contacts;
//import com.example.aprivate.testing_sqlite.holders.CustomHolder;
//
//import java.util.List;
//
//
//public class CustomAdapter extends RecyclerView.Adapter<CustomHolder>
//        implements View.OnClickListener {
//    private List<Contacts> mArrayList = Collection.getInstance().getContacts();
//    private View.OnClickListener mListener;
//    private RecyclerView recyclerView;
//
//
//    public CustomAdapter(List<Contacts> contacts, View.OnClickListener onClickListener) {
//        mArrayList = contacts;
//        mListener = onClickListener;
//    }
//
//    @Override
//    public CustomHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//
//        LayoutInflater layoutInflater = LayoutInflater.from(null);
//        View v = layoutInflater.inflate(R.layout.item_view, parent, false);
//        CustomHolder holder = new CustomHolder(v);
//        holder.itemView.setOnClickListener(mListener);
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(CustomHolder holder, int position) {
//        holder.bind(mArrayList.get(position));
//    }
//
//    @Override
//    public int getItemCount() {
//        return mArrayList.size();
//    }
//
//    @Override
//    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
//        super.onAttachedToRecyclerView(recyclerView);
//        this.recyclerView = recyclerView;
//    }
//
//    @Override
//    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
//        super.onDetachedFromRecyclerView(recyclerView);
//        this.recyclerView = null;
//    }
//
//
//    @Override
//    public void onClick(View v) {
//        Toast t = Toast.makeText(v.getContext(), "Testik", Toast.LENGTH_SHORT);
//        t.show();
//    }
//
//
//}
