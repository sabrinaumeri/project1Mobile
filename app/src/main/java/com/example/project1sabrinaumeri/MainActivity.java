package com.example.project1sabrinaumeri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.app.DatePickerDialog;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    static TextInputEditText date;
    static TextInputEditText time;
    Spinner description;
    String date2;
    String time2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        date = findViewById(R.id.EditDate);
        time = findViewById(R.id.editTime);
        description = findViewById(R.id.spinner2);

    }

    public void onSettingsClick(View view) {
        Intent intent = new Intent(this,Settings.class);
        startActivity(intent);
    }

    public void onRecordEventClick(View view) {
        Intent intent = new Intent(this, RecyclerView.class);
        startActivity(intent);
    }

    public void onClickAddEvent(View view) {

        date2 = date.getText().toString();
        time2 = time.getText().toString();
        SharedPreferences settings = getSharedPreferences("datapersistance", Context.MODE_PRIVATE);
        String eventString = settings.getString("name", "");

        Intent intent = new Intent(this, RecyclerView.class);
        intent.putExtra("date", date2);
        intent.putExtra("time", time2);
        String description2;
        switch (description.getSelectedItemPosition()) {

            case 0:
                description2 = "Morning Walk";
                break;
            case 1:
                description2 = "Afternoon Walk";
                break;
            case 2:
                description2 = "Evening Walk";
                break;
            case 3:
                description2 = "Additional Walk";
                break;
            default:
                break;
        }
        Toast.makeText(this, "New Walk added.", Toast.LENGTH_SHORT).show();
        Intent intent2 = new Intent(this, RecyclerView.class);
        startActivity(intent2);

    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            date.setText(day+"/"+month+"/"+year);
        }
    }

    public void showDatePickerDialog(View v) {
        InputMethodManager imm =(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");

    }

    public static class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            // Do something with the time chosen by the user
            time.setText(hourOfDay+":"+minute);
        }
    }
    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

}