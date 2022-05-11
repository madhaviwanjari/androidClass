package com.example.myapplication;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.data.RentDetails;
import com.example.myapplication.db.RentDetailsDatabase;
import com.example.myapplication.utils.Utility;
import com.example.myapplication.view.CustomDatePickerDialog;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AddMaintenanceActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    EditText flatNoId;
    EditText nameId;
    RadioGroup radioGrpId;
    EditText paymentDateId;
    EditText maintenanceDateId;
    EditText amountId;
    EditText remarkId;
    Button okButtonId;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);

        flatNoId = (EditText) findViewById(R.id.flatNoId);
        nameId =(EditText) findViewById(R.id.nameId);
        radioGrpId = (RadioGroup) findViewById(R.id.radioGrpId);
        paymentDateId = (EditText) findViewById(R.id.paymentDateId);
        maintenanceDateId = (EditText) findViewById(R.id.maintenanceDateId);
        amountId = (EditText) findViewById(R.id.amountId);
        remarkId = (EditText) findViewById(R.id.remarkId);
        okButtonId =(Button) findViewById(R.id.okButtonId);

        okButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isValidate()){
                    Utility.printLog("validate");
                    saveRentDetails();
                }

            }
        });

        paymentDateId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDatePickerDialog datePickerDialog = new CustomDatePickerDialog(AddMaintenanceActivity.this);
                 CustomDatePickerDialog.OnDateSetCallBack listener= new CustomDatePickerDialog.OnDateSetCallBack(){
                    @Override
                    public void onDateSet(String date) {
                        paymentDateId.setText(date);
                    }
                };

                datePickerDialog.setOnDateSetCallBack(listener);
                datePickerDialog.show();
            }
        });


        maintenanceDateId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDatePickerDialog datePickerDialog = new CustomDatePickerDialog(AddMaintenanceActivity.this);
                CustomDatePickerDialog.OnDateSetCallBack listener= new CustomDatePickerDialog.OnDateSetCallBack(){
                    @Override
                    public void onDateSet(String date) {
                        maintenanceDateId.setText(date);
                    }
                };

                datePickerDialog.setOnDateSetCallBack(listener);
                datePickerDialog.show();
            }
        });



    }
boolean isMaintenanceMode(){
        return (radioGrpId.getCheckedRadioButtonId() == R.id.radioMaintainId);

}
    private void saveRentDetails() {
        try{
             String maintaincedate = maintenanceDateId.getText().toString();
            final Date maintenanceDate = Utility.simpleDateFormat.parse(maintaincedate);

            Date paymentDate = Utility.simpleDateFormat.parse(paymentDateId.getText().toString());


            RentDetails rentDetails = new RentDetails(flatNoId.getText().toString()
                    ,nameId.getText().toString(),isMaintenanceMode(),maintenanceDate.getTime(),
                    paymentDate.getTime(),(Integer.parseInt(amountId.getText().toString()))
                    ,remarkId.getText().toString());

            RentDetailsDatabase rentDetailsDatabase= RentDetailsDatabase.getInstance(this);
            rentDetailsDatabase.rentDetailsDao().insertRentDetails(rentDetails);
            List<RentDetails> rentDetailList = rentDetailsDatabase.rentDetailsDao().getRentDetailList();
            rentDetailList.size();

        }catch (Exception e){
            e.printStackTrace();

        }


    }



    private boolean isValidate() {

           String flatNo = flatNoId.getText().toString();
            String name = nameId.getText().toString();


            //int temp = radioGrpId.getCheckedRadioButtonId();
           // if(temp == R.id.radioMaintainId){}else{}

            if (flatNo.trim().isEmpty()){
                Toast.makeText(this, "Enter Flat No.", Toast.LENGTH_SHORT).show();
                return  false;

            }else if (name.trim().isEmpty()){
                Toast.makeText(this, "Enter name", Toast.LENGTH_SHORT).show();
                return  false;
            }else if (maintenanceDateId.getText().toString().trim().isEmpty()){
                Toast.makeText(this, "Enter Maintenance Date", Toast.LENGTH_SHORT).show();
                return  false;
            }else if (paymentDateId.getText().toString().trim().isEmpty()){
                Toast.makeText(this, "Enter Payment Date", Toast.LENGTH_SHORT).show();
                return  false;
            }else if (amountId.getText().toString().trim().isEmpty()){
                Toast.makeText(this, "Enter Amount", Toast.LENGTH_SHORT).show();
                return  false;
            }else if (remarkId.getText().toString().trim().isEmpty()){
                Toast.makeText(this, "Enter Remark", Toast.LENGTH_SHORT).show();
                return  false;
            }


        return  true;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear,
                          int dayOfMonth) {
        final Calendar myCalendar = Calendar.getInstance();
        myCalendar.set(Calendar.YEAR, year);
        myCalendar.set(Calendar.MONTH, monthOfYear);
        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        paymentDateId.setText(dayOfMonth+" "+monthOfYear +" "+year);

    }
}
