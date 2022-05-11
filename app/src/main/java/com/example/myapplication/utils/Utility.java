package com.example.myapplication.utils;

import android.util.Log;

import java.text.SimpleDateFormat;

public class Utility {
    public static void printLog(String msg){
        Log.d("TAG",msg);
    }

    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

}
