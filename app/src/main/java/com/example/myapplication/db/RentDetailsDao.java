package com.example.myapplication.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.myapplication.data.RentDetails;

import java.util.List;

@Dao
public interface RentDetailsDao {
@Query("select * from rentdetails")
 public    List<RentDetails> getRentDetailList();
    @Insert
    public  void insertRentDetails(RentDetails rentDetails);
}
