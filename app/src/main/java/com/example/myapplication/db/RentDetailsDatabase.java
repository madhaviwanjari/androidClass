package com.example.myapplication.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.myapplication.data.RentDetails;

@Database(entities = RentDetails.class,exportSchema = false,version = 1)
public abstract class RentDetailsDatabase extends RoomDatabase {
    private static final String DB_NAME = "maintenance_db";
    private  static RentDetailsDatabase instance;
    public static synchronized RentDetailsDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    RentDetailsDatabase.class,DB_NAME).fallbackToDestructiveMigration().allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    public abstract RentDetailsDao rentDetailsDao();
}
