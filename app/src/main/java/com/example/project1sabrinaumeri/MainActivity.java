package com.example.project1sabrinaumeri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickButton(View view) {

    }

    public void onSettingsClick(View view) {
        Intent intent = new Intent(this,Settings.class);
        startActivity(intent);
    }

    public void onRecordEventClick(View view) {
        Intent intent = new Intent(this, RecyclerView.class);
        startActivity(intent);
    }
}