package com.example.aprivate.testing_sqlite.bin;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.example.aprivate.testing_sqlite.R;


//TODO !!!!  Убивай фоновые фрагменты
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MAIN=======:";

    private Button mButtonNewContact;

    private RecyclerView mRectcleView;
    private LinearLayoutManager mLinearLayoutManager;

    private Fragment mCostulFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mActionBarToolbar);

        start();

        mRectcleView = (RecyclerView) findViewById(R.id.recycler_view_id);
        mLinearLayoutManager = new LinearLayoutManager(this);

        //Add fragment
        mButtonNewContact = (Button) findViewById(R.id.new_contact);
        mButtonNewContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCostulFragment.onDestroy();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                AddContact addContact = new AddContact();
                mCostulFragment = addContact;
                ft.add(R.id.frgmCont, mCostulFragment);
                ft.commit();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    void start(){
        if (mCostulFragment==null) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();

            RVF recyclerViewFragment = new RVF();
            mCostulFragment = recyclerViewFragment;
            ft.add(R.id.frgmCont, mCostulFragment);
            ft.commit();
        } else {
            mCostulFragment.onDestroy();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();

            RVF recyclerViewFragment = new RVF();
            mCostulFragment = recyclerViewFragment;
            ft.add(R.id.frgmCont, mCostulFragment);
            ft.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }
}