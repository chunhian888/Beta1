package com.example.beta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class TenantHome extends AppCompatActivity {
    Button TCheckTNB, TEPay, TFeedback, btnTEmergency;
    TextView testing123;
    String tName, tFeedback;
    DatabaseReference ref;
    FirebaseDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_home);

        tName = getIntent().getStringExtra("tName");
        TCheckTNB = (Button) findViewById(R.id.TCheckTNB);
        TEPay = (Button) findViewById(R.id.TEPay);
        TFeedback = (Button) findViewById(R.id.TFeedback);

        btnTEmergency = (Button) findViewById(R.id.btnTEmergency);
        testing123 = (TextView) findViewById(R.id.testing123);
        testing123.setText("Welcome "+ tName.toString() +" hehe! ");

        //database = FirebaseDatabase.getInstance();
        //ref = database.getReference().child("Feedback");

        TCheckTNB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(TenantHome.this,CheckTNB.class));
                //finish();
            }
        });

        TEPay.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(TenantHome.this,EPay.class));
                //finish();
            }
        });

        TFeedback.setOnClickListener(new View.OnClickListener(){
            Intent intent = new Intent(TenantHome.this,TenantFeedback.class);
            @Override
            public void onClick(View view){

                Intent intent = new Intent(TenantHome.this,TenantFeedback.class);
                intent.putExtra("tName",tName); //this one is bring data to next page
                //intent.putExtra("tFeedback",tFeedback);
                startActivity(intent);
            }
        });

        btnTEmergency.setOnClickListener(new View.OnClickListener(){
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
                    Toast.makeText(TenantHome.this, "Call failed, please try again later.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


}
