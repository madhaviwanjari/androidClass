package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    Button addButtonId;
    Button listButtonId;
    Button exportButtonId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_activity);

        addButtonId=(Button) findViewById(R.id.addButtonId);
        listButtonId=(Button) findViewById(R.id.listButtonId);
        exportButtonId=(Button) findViewById(R.id.exportButtonId);

        addButtonId.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast toastLogin =Toast.makeText(DashboardActivity.this, "add", Toast.LENGTH_SHORT);
                toastLogin.show();
                Intent intent = new Intent(view.getContext(), AddMaintenanceActivity.class);
                startActivity(intent);
            }
        });

    ///////LIST button

        listButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toastLogin =Toast.makeText(DashboardActivity.this, "list", Toast.LENGTH_SHORT);
                toastLogin.show();
                Intent intent = new Intent(view.getContext(), ListMaintenanceActivity.class);
                startActivity(intent);
            }
        });



    }
}
