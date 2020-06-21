package com.example.beta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ManagementLogin extends AppCompatActivity {
    EditText txtManagementUsername, txtManagementPassword;
    Button btnManagementLogin;
    private DatabaseReference ref;
    private Management management;
    String mUsername, mPassword, mName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management_login);

        txtManagementUsername = (EditText) findViewById(R.id.txtManagementUsername);
        txtManagementPassword = (EditText) findViewById(R.id.txtManagementPassword);
        btnManagementLogin = (Button) findViewById(R.id.btnManagementLogin);
        ref = FirebaseDatabase.getInstance().getReference().child("Management");

        btnManagementLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mUsername = txtManagementUsername.getText().toString();
                mPassword = txtManagementPassword.getText().toString();

                mName = mUsername;
                if(ref.child(mUsername)!= null){
                    ref.child(mUsername).addValueEventListener(new ValueEventListener(){
                    @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot){
                        Management management = dataSnapshot.getValue(Management.class);
                        try{
                            if(mPassword.equals(management.getMPassword())){
                                Toast.makeText(ManagementLogin.this, "Login Successfully!", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(ManagementLogin.this,ManagementHome.class);
                                intent.putExtra("mName",mName); //this one is bring data to next page
                                startActivity(intent);
                                finish();
                            }else
                                Toast.makeText(ManagementLogin.this,"Invalid username or password!", Toast.LENGTH_LONG).show();
                        }catch (NullPointerException NP){
                            Toast.makeText(ManagementLogin.this,"Invalid username or password!", Toast.LENGTH_LONG).show();
                        }
                    }
                    @Override
                        public void onCancelled(@NonNull DatabaseError databaseError){

                    }
                });
                }else {
                    Toast.makeText(ManagementLogin.this,"Please enter Username", Toast.LENGTH_LONG).show();
                }
            }
        });
   }
}
