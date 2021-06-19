package com.example.project1sabrinaumeri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class RecyclerView extends AppCompatActivity {


    RecyclerView recyclerView;
    String[] events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        //recyclerView = findViewById(R.id.rView);
        SharedPreferences settings = getSharedPreferences("datapersistance", Context.MODE_PRIVATE);
        String eventString = settings.getString("name", "");

        events = eventString.split("");

    }


    public void onButtonClickSettings(View view) {
        finish();
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    public void onButtonClickRecordEvent(View view) {
        finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

