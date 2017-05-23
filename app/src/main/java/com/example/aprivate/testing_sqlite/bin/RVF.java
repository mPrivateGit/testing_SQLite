package com.example.aprivate.testing_sqlite.bin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aprivate.testing_sqlite.R;

import java.util.List;


public class RVF extends Fragment{
    private RecyclerView mRecyclerView;
    private TestCustomAdapter mTestCustomAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_recycler_view, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view_id);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(),
                DividerItemDecoration.VERTICAL));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return v;
    }


    private void updateUI() {
        if (mTestCustomAdapter == null) {
            Collection collection = Collection.get(getActivity());
            List<Contacts> contactses = collection.getContacts();
            mTestCustomAdapter = new TestCustomAdapter(contactses,
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int position = mRecyclerView.getChildLayoutPosition(v);
                            Toast.makeText(getActivity(),
                                    " clicked: "+position, Toast.LENGTH_SHORT).show();
                        }
                    });
            mRecyclerView.setAdapter(mTestCustomAdapter);
        } else {
            mTestCustomAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private class CustomHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Contacts mContacts;

        private TextView mTextViewFirstName;
        private TextView mTextViewSecondName;
        private TextView mTextViewPhoneNumber;


        public CustomHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mTextViewFirstName = TextView.class.cast(itemView.findViewById(R.id.first_name_item_view));
            mTextViewSecondName = (TextView) itemView.findViewById(R.id.get_second_name_item_view);
            mTextViewPhoneNumber = (TextView) itemView.findViewById(R.id.phone_number_item_view);
        }

        public void bind(Contacts contacts){
            mContacts = contacts;
            mTextViewFirstName.setText(mContacts.getmFirstNames());
            mTextViewSecondName.setText(mContacts.getmSecondNames());
            mTextViewPhoneNumber.setText(mContacts.getmPhoneNumbers());
        }

        @Override
        public void onClick(View v) {
            Intent intent = ContactPager.newIntent(getActivity(),
                    mContacts.getmId());
            startActivity(intent);
        }
    }

    public class TestCustomAdapter extends RecyclerView.Adapter<CustomHolder>
            implements View.OnClickListener{

        private List<Contacts> mContacts = Collection.sCollection.getContacts();
        private View.OnClickListener mListener;
        private RecyclerView mRecyclerView;


        public TestCustomAdapter(List<Contacts> contacts, View.OnClickListener listener) {
            mContacts = contacts;
            mListener = listener;
        }

        @Override
        public CustomHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View v = layoutInflater.inflate(R.layout.activity_item_view, parent, false);
            v.setOnClickListener(mListener);

            return new CustomHolder(v);
        }

        @Override
        public void onBindViewHolder(CustomHolder holder, int position) {
            holder.bind(mContacts.get(position));
        }

        @Override
        public int getItemCount() {
            return mContacts.size();
        }

        @Override
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
            this.mRecyclerView = recyclerView;
        }

        @Override
        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
            super.onDetachedFromRecyclerView(recyclerView);
            this.mRecyclerView = null;
        }


        @Override
        public void onClick(View v) {
            Toast t = Toast.makeText(v.getContext(), "Testik", Toast.LENGTH_SHORT);
            t.show();
        }
    }
}