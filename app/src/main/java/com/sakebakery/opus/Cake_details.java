package com.sakebakery.opus;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.view.Event;
import com.sakebakery.opus.adapter.CakeImagelistAdapter;
import com.sakebakery.opus.adapter.CakedataListAdapter;
import com.sakebakery.opus.obj.Cakeobj;
import com.sakebakery.opus.util.Util;

import java.util.ArrayList;


public class Cake_details extends AppCompatActivity {

   // public TextView side, flavor, icing, top, description, price;
    private DatabaseReference mData;
    private CakedataListAdapter cakedataListAdapter;
  //private CakeImagelistAdapter cakeImagelistAdapter;
    private RecyclerView cake_list;
    private ArrayList<Cakeobj> cakeObjs;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cake_details);
        cake_list= findViewById(R.id.cake_list);
        cakeObjs = new ArrayList<>();



        //Loading UI
        if(Util.isOnline(getApplicationContext())){
            LoadFirebaseDB();
        }else {
            Toast.makeText(getApplicationContext(), "No internet connection!", Toast.LENGTH_SHORT).show();
        }
    }


    public void gotoCreate (View view){
        //Intent intent = new Intent (this, CreatingDesign.class); //to go to Create Design class
        //startActivity(intent);
    }

    public void LoadFirebaseDB() {

        if (progressDialog == null) {
            progressDialog = new ProgressDialog(Cake_details.this);
            progressDialog.setCancelable(true);
            progressDialog.setMessage("Loading...");
            progressDialog.show();
        }
        mData = FirebaseDatabase.getInstance().getReference();
        mData.child("cakedata").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Log.d("Cake_list", "" + dataSnapshot.toString());

                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    Cakeobj cakeobj = new Cakeobj();
                    cakeobj.setCake_flavor(ds.child("flavor").getValue() + "");
                    cakeobj.setIcing_flavor(ds.child("icing").getValue() + "");
                    cakeobj.setTop_deco(ds.child("top_deco").getValue() + "");
                    cakeobj.setSide_deco(ds.child("side_deco").getValue() + "");
                    cakeobj.setDescription(ds.child("description").getValue() + "");
                    cakeobj.setCake_price(ds.child("price").getValue()+ "");
                    cakeobj.setActive(Integer.parseInt(ds.child("active").getValue() + ""));

                    if (cakeobj.getActive() == 1) {
                        cakeObjs.add(cakeobj);
                    }

                    if (cakeObjs.size() == 0) {
                        Toast.makeText(Cake_details.this, "No Data!", Toast.LENGTH_SHORT).show();
                    }

                }
                LoadUI();
                DismissDialog();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                DismissDialog();
            }
        });

    }

    public void DismissDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    public void LoadUI() {

        cakedataListAdapter = new CakedataListAdapter(Cake_details.this,cakeObjs);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        cake_list.setLayoutManager(mLayoutManager);
        cake_list.setItemAnimator(new DefaultItemAnimator());
        cake_list.setAdapter(cakedataListAdapter);

    }
}