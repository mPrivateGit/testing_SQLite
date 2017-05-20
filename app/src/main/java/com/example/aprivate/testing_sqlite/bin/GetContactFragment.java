package com.example.aprivate.testing_sqlite.bin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.aprivate.testing_sqlite.R;

public class GetContactFragment extends Fragment {
    private static final String TAG = "BF_class ===========";

    private TextView mTextViewFirstName;
    private TextView mTextViewSecondName;
    private TextView mTextViewPhoneNumber;

    private String mFirstName;
    private String mSecondName;
    private String mPhoneNumber;

    private Button mNextButton;
    private Button mBackButton;


    private int index = 0;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_blank, container, false);

        mTextViewFirstName = (TextView) v.findViewById(R.id.get_first_name);
        mTextViewSecondName = (TextView) v.findViewById(R.id.get_second_name);
        mTextViewPhoneNumber = (TextView) v.findViewById(R.id.get_phone_number);

        mNextButton = (Button) v.findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index+=1;
                setContent();
                Log.d(TAG, String.valueOf(index));
            }
        });

        mBackButton = (Button) v.findViewById(R.id.back_button);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index-=1;
                setContent();
                Log.d(TAG, String.valueOf(index));
            }
        });

        setContent();
        return v;
    }

    private void setContent(){
        if (Collection.getInstance().getContacts().size()==0){
            mTextViewFirstName.setText("Пока нет контактов");
            mTextViewSecondName.setText("Добавь новый контак");
            mTextViewPhoneNumber.setText(" ");
        } else if(Collection.getInstance().getContacts().size()<=index) {
            index = 0;
            mFirstName = Collection.getInstance().getContacts().get(index).getmFirstNames();
            mSecondName = Collection.getInstance().getContacts().get(index).getmSecondNames();
            mPhoneNumber = Collection.getInstance().getContacts().get(index).getmPhoneNumbers();

            mTextViewFirstName.setText(mFirstName);
            mTextViewSecondName.setText(mSecondName);
            mTextViewPhoneNumber.setText(mPhoneNumber);
        } else if (index<0) {
            index = Collection.getInstance().getContacts().size() - 1;
            mFirstName = Collection.getInstance().getContacts().get(index).getmFirstNames();
            mSecondName = Collection.getInstance().getContacts().get(index).getmSecondNames();
            mPhoneNumber = Collection.getInstance().getContacts().get(index).getmPhoneNumbers();

            mTextViewFirstName.setText(mFirstName);
            mTextViewSecondName.setText(mSecondName);
            mTextViewPhoneNumber.setText(mPhoneNumber);
        } else {
            mFirstName = Collection.getInstance().getContacts().get(index).getmFirstNames();
            mSecondName = Collection.getInstance().getContacts().get(index).getmSecondNames();
            mPhoneNumber = Collection.getInstance().getContacts().get(index).getmPhoneNumbers();

            mTextViewFirstName.setText(mFirstName);
            mTextViewSecondName.setText(mSecondName);
            mTextViewPhoneNumber.setText(mPhoneNumber);
        }

//        mTextViewFirstName.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "fonts/"));
    }

    @Override
    public void onPause() {
        super.onPause();
        onDestroyView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}