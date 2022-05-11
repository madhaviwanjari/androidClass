package com.example.myapplication.view;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Build;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.example.myapplication.utils.Utility;

import java.util.Calendar;

public class CustomDatePickerDialog extends DatePickerDialog implements DatePickerDialog.OnDateSetListener {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public CustomDatePickerDialog(@NonNull Context context) {
        super(context);
        setOnDateSetListener(this);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear,
                          int dayOfMonth)  {
        final Calendar myCalendar = Calendar.getInstance();
        myCalendar.set(Calendar.YEAR, year);
        myCalendar.set(Calendar.MONTH, monthOfYear);
        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
         String date=  Utility.simpleDateFormat.format((myCalendar.getTime()));
         if(callBack != null){
             callBack.onDateSet(date);
         }

    }

    OnDateSetCallBack callBack;

    public void setOnDateSetCallBack(OnDateSetCallBack callBack) {
        this.callBack = callBack;
    }

    public interface  OnDateSetCallBack{
       public void  onDateSet(String date);
    }
}
