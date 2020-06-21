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

public class TenantLogin extends AppCompatActivity {
    EditText txtTenantUsername, txtTenantPassword;
    Button btnTenantLogin;
    private DatabaseReference ref;
    private Tenant tenant;
    String tUsername, tPassword, tName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_login);

        txtTenantUsername = (EditText) findViewById(R.id.txtTenantUsername);
        txtTenantPassword = (EditText) findViewById(R.id.txtTenantPassword);
        btnTenantLogin = (Button) findViewById(R.id.btnTenantLogin);
        ref = FirebaseDatabase.getInstance().getReference().child("Tenant");

        btnTenantLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                tUsername = txtTenantUsername.getText().toString();
                tPassword = txtTenantPassword.getText().toString();
                tName = tUsername;
                if(ref.child(tUsername)!= null){
                    ref.child(tUsername).addValueEventListener(new ValueEventListener(){
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot){
                            Tenant tenant = dataSnapshot.getValue(Tenant.class);
                            try{
                                if(tPassword.equals(tenant.getTPassword())){
                                    Toast.makeText(TenantLogin.this, "Login Successfully!", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(TenantLogin.this,TenantHome.class);
                                    intent.putExtra("tName",tName); //this one is bring data to next page
                                    startActivity(intent);
                                    finish();
                                }else
                                    Toast.makeText(TenantLogin.this,"Invalid username or password!", Toast.LENGTH_LONG).show();
                            }catch (NullPointerException NP){
                                Toast.makeText(TenantLogin.this,"Invalid username or password!", Toast.LENGTH_LONG).show();
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError){

                        }
                    });
                }else {
                    Toast.makeText(TenantLogin.this,"Please enter Username", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
