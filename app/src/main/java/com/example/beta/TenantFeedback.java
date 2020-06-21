package com.example.beta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class TenantFeedback extends AppCompatActivity {
    EditText txtTFeedback;
    Button btnTFBSubmit;
    String tName, tFeedback;
    private Feedback feedback;
    FirebaseDatabase database;
    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_feedback);

        tFeedback = getIntent().getStringExtra("tFeedback");
        tName = getIntent().getStringExtra("tName");
        txtTFeedback = (EditText) findViewById(R.id.txtTFeedback);
        btnTFBSubmit = (Button) findViewById(R.id.btnTFBSubmit);
        //txtTFeedback.setText(tName.toString());
        feedback = new Feedback();
        database = FirebaseDatabase.getInstance();
        ref = database.getReference().child("Feedback");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String feedback = dataSnapshot.child(tName).child("tfeedback").getValue().toString();
                txtTFeedback.setText(feedback);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btnTFBSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feedback.setTUsername(tName.toString());
                feedback.setTFFeedback(txtTFeedback.getText().toString());
                ref.child(feedback.getTUsername()).setValue(feedback);

                Intent intent = new Intent(TenantFeedback.this,TenantHome.class);
                intent.putExtra("tName",tName); //this one is bring data to next page
                startActivity(intent);
                finish();

                //here is the update one data only thing
                //Map<String,Object> taskMap = new HashMap<String,Object>();
                //taskMap.put("Status", "COMPLETED");
                ////ref.updateChildren(taskMap);
                //ref.child(feedback.getTUsername()).updateChildren(taskMap);

                //startActivity(new Intent(TenantFeedback.this, TenantHome.class));
                //finish();

            }
        });
    }

}
