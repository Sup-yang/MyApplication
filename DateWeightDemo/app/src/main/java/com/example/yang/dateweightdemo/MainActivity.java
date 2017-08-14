package com.example.yang.dateweightdemo;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    private TextView showtime;
    private int myear;
    private int mmonth;
    private int mday;
    private int mhour;
    private int mminute;

    static final int TIME_12=0;
    static final int TIME_24=1;
    static final int ADTE_DIALOG_ID=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showtime= (TextView) findViewById(R.id.text_showtime);
        setDialogOnClickListener(R.id.button_year,ADTE_DIALOG_ID);
        setDialogOnClickListener(R.id.button_12,TIME_12);
        setDialogOnClickListener(R.id.button_24,TIME_24);

        updateDisplay();
    }

    private void updateDisplay() {
        showtime.setText(new StringBuilder().append(myear).append("-").append(mmonth+1).append("-").append(mday)
        .append("-").append(pad(mhour)).append("-").append(pad(mminute))
        );
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id){
            case TIME_12:
            case TIME_24:
                return  new TimePickerDialog(this,timeSetListener,mhour,mminute,id==TIME_24);
            case ADTE_DIALOG_ID:
                return new DatePickerDialog(this,dateSetListener,myear,mmonth,mday);
        }
        return super.onCreateDialog(id);
    }


    @Override
    protected void onPrepareDialog(int id, Dialog dialog) {
        switch (id){
            case TIME_12:
            case TIME_24:
                ((TimePickerDialog)dialog).updateTime(mhour,mminute);
                break;
            case ADTE_DIALOG_ID:
                ((DatePickerDialog)dialog).updateDate(myear,mmonth,mday);
                break;
        }
    }

    private TimePickerDialog.OnTimeSetListener timeSetListener= new TimePickerDialog.OnTimeSetListener() {

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            mhour=hourOfDay;
            mminute=minute;
            updateDisplay();
        }
    };

    private DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            myear=year;
            mmonth=month;
            mday=dayOfMonth;
            updateDisplay();
        }
    };
    private void setDialogOnClickListener(int buttonid, final int dialogid){
        Button button1= (Button) findViewById(buttonid);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(dialogid);
            }
        });


    }

    private static String pad(int c){

        if (c>=10)
            return String.valueOf(c);
        else
            return "0"+String.valueOf(c);

    }
}
