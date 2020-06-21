package com.example.beta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    Button btnManagement, btnTenant;
    Button btnTesting1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTesting1 = (Button) findViewById(R.id.btnTesting1);
        btnManagement = (Button) findViewById(R.id.btnManagement);
        btnTenant = (Button) findViewById(R.id.btnTenant);

        btnManagement.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(MainActivity.this,ManagementLogin.class));
                //finish();
            }
        });

        btnTenant.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(MainActivity.this,TenantLogin.class));
                //finish();
            }
        });

        btnTesting1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(MainActivity.this,DevelopMain.class));
                //finish();
            }
        });
    }
}
