package com.example.project1sabrinaumeri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void onRecordEventClick(View view) {
        Intent intent = new Intent(this, RecyclerView.class);
        startActivity(intent);
    }


    public void onClearEvent(View view) {

    }

    public void onSettingsClick(View view) {
    }
}