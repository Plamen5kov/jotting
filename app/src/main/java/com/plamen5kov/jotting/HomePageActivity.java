package com.plamen5kov.jotting;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.facebook.login.LoginManager;

import java.util.ArrayList;
import java.util.List;

import static com.plamen5kov.jotting.Contants.SERIALIZED_NOTE_KEY;

public class HomePageActivity extends AppCompatActivity implements RecyclerViewClickListener {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        mRecyclerView = findViewById(R.id.rv_notes_list);
        mRecyclerView.setHasFixedSize(true);

        //layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //adapter
        mAdapter = new NotesAdapter(Repository.getInstance().getAllNotes(), this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int currentId = item.getItemId();
        switch (currentId) {
            case R.id.action_logout:
                LoginManager.getInstance().logOut();
                Intent myIntent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(myIntent);
                break;
            case R.id.action_add:
                startActivity(new Intent(getApplicationContext(),CreateActivity.class));
                break;
                default: break;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_logout, menu);
        return true;
    }

    @Override
    public void onItemClick(Note item) {
        Intent detailsIntent = new Intent(this, DetailsActivity.class);
        detailsIntent.putExtra(SERIALIZED_NOTE_KEY, item);
        startActivity(detailsIntent);
    }
}
