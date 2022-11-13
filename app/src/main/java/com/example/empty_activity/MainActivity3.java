package com.example.empty_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.empty_activity.adapter.userAdap;
import com.example.empty_activity.model.usuario;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class MainActivity3 extends AppCompatActivity {

    RecyclerView nRecycler;
    userAdap mAdapter;

    FirebaseFirestore mFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mFirestore = FirebaseFirestore.getInstance();
        nRecycler = findViewById(R.id.reycler_view);
        nRecycler.setLayoutManager(new LinearLayoutManager(this));
        Query query = mFirestore.collection("user");

        FirestoreRecyclerOptions<usuario> firestoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<usuario>().setQuery(query, usuario.class).build();
        mAdapter = new userAdap(firestoreRecyclerOptions);
        mAdapter.notifyDataSetChanged();
        nRecycler.setAdapter(mAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        mAdapter.startListening();
    }
}