package com.example.myapplication.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "rentdetails")
public class RentDetails {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "flatNo")
    String flatNo;
    @ColumnInfo(name = "name")
    String name;
    @ColumnInfo(name = "isMaintenance")
    boolean isMaintenance;
    @ColumnInfo(name = "maintenanceDate")
    long maintenanceDate;
    @ColumnInfo(name = "paymentDate")
    long paymentDate;
    @ColumnInfo(name = "amount")
    int amount;
    @ColumnInfo(name = "remark")
    String remark;

    public RentDetails(String flatNo, String name, boolean isMaintenance, long maintenanceDate, long paymentDate, int amount, String remark) {
        this.flatNo = flatNo;
        this.name = name;
        this.isMaintenance = isMaintenance;
        this.maintenanceDate = maintenanceDate;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.remark = remark;
    }

    public String getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMaintenance() {
        return isMaintenance;
    }

    public void setMaintenance(boolean maintenance) {
        isMaintenance = maintenance;
    }

    public long getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(long maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    public long getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(long paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
