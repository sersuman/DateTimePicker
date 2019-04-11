package com.softwarica.datetimepicker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private TextView tvDate, tvTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDate = findViewById(R.id.tvDate);
        tvTime = findViewById(R.id.tvTime);
        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDatePicker();
            }
        });
        tvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadTime();
            }
        });

    }

    private void loadTime(){
        final Calendar c = Calendar.getInstance();
        final int hour = c.get(Calendar.HOUR);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                tvTime.setText("Time is:" + hourOfDay + minute);
            }
        }, hour,minute, false);
        timePickerDialog.show();
    }
    private void loadDatePicker(){
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,this,year, month,day);
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis()-10000);
        datePickerDialog.getDatePicker().setMaxDate((System.currentTimeMillis()-1000)+3*24*60*60*1000);
        datePickerDialog.show();
    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
       String stringMonth = convertToMonth(month);
        String date = "Month/Day/Year :" + stringMonth  + "/" + dayOfMonth + "/" + year;
        tvDate.setText(date);
    }
    private String convertToMonth(int month){
        String textMonth="";
        switch (month){
            case 0:
                textMonth = "January";
                break;
            case 1:
                textMonth = "February";
                break;
            case 2:
                textMonth = "March";
                break;
            case 3:
                textMonth = "April";
                break;
            case 4:
                textMonth = "May";
                break;
            case 5:
                textMonth = "June";
                break;
            case 6:
                textMonth = "July";
                break;
            case 7:
                textMonth= "August";
                break;
            case 8:
                textMonth = "September";
                break;
            case 9:
                textMonth = "October";
                break;
            case 10:
                textMonth = "November";
                break;
            case 11:
                textMonth = "December";
                break;
        }
        return textMonth;

    }
}
