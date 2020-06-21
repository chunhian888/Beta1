package com.example.beta;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ManagementHome extends AppCompatActivity {
    String mName;
    Button MEpay, MCheckTNB, btnMEmergency, MChkFeedback;
    TextView testing123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management_home);
        mName = getIntent().getStringExtra("mName");

        MEpay = (Button) findViewById(R.id.MEpay);
        MCheckTNB = (Button) findViewById(R.id.MCheckTNB);
        btnMEmergency = (Button) findViewById(R.id.btnMEmergency);
        MChkFeedback = (Button) findViewById(R.id.MChkFeedback);
        testing123 = (TextView) findViewById(R.id.testing123);

        testing123.setText("Welcome "+ mName.toString() +" hehe! ");

        MCheckTNB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(ManagementHome.this,CheckTNB.class));
                //finish();
            }
        });

        MEpay.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(ManagementHome.this,EPay.class));
                //finish();
            }
        });

        MChkFeedback.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent =new Intent(ManagementHome.this,ManagementFeedback.class);
                intent.putExtra("mName",mName); //this one is bring data to next page
                startActivity(intent);
            }
        });

        btnMEmergency.setOnClickListener(new View.OnClickListener(){
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:0123919643"));
                try {
                    startActivity(intent);
                    finish();
                    Log.i("Finished making a call", "");
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(ManagementHome.this, "Call failed, please try again later.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


}
