package com.example.beta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DevelopMain extends AppCompatActivity {
    Button btnDManagement, btnDTenant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_develop_main);

        btnDManagement = (Button) findViewById(R.id.btnDManagement);
        btnDTenant = (Button) findViewById(R.id.btnDTenant);

        btnDManagement.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(DevelopMain.this,ManagementRegister.class));
                //finish();
            }
        });

        btnDTenant.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(DevelopMain.this,TenantRegister.class));
                //finish();
            }
        });
    }
}
