package com.example.beta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TenantRegister extends AppCompatActivity {
    EditText txtTUsername, txtTPassword, txtTUnit, txtTBlock;
    Button btnRegisterTenant;
    private Tenant tenant;
    FirebaseDatabase database;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_register);

        txtTUsername = (EditText) findViewById(R.id.txtTUsername);
        txtTPassword = (EditText) findViewById(R.id.txtTPassword);
        txtTUnit = (EditText) findViewById(R.id.txtTUnit);
        txtTBlock = (EditText) findViewById(R.id.txtTBlock);
        btnRegisterTenant = (Button) findViewById(R.id.btnRegisterTenant);
        tenant = new Tenant();
        database = FirebaseDatabase.getInstance();
        ref = database.getReference().child("Tenant");

        txtTUsername.addTextChangedListener(registerTenant);
        txtTPassword.addTextChangedListener(registerTenant);
        txtTUnit.addTextChangedListener(registerTenant);
        txtTBlock.addTextChangedListener(registerTenant);

        btnRegisterTenant.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                tenant.setTUsername(txtTUsername.getText().toString());
                tenant.setTPassword(txtTPassword.getText().toString());
                tenant.setTBlock(txtTBlock.getText().toString());
                tenant.setTUnit(txtTUnit.getText().toString());
                tenant.setTMFees("No");
                ref.child(tenant.getTUsername()).setValue(tenant);

                Toast.makeText(TenantRegister.this, "Successfully registered", Toast.LENGTH_LONG).show();

                startActivity(new Intent(TenantRegister.this, MainActivity.class));
                finish();
            }
        });
    }
    private TextWatcher registerTenant = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String usernameInput = txtTUsername.getText().toString().trim();
            String passwordInput = txtTPassword.getText().toString().trim();
            String unitInput = txtTUnit.getText().toString().trim();
            String blockInput = txtTBlock.getText().toString().trim();

            btnRegisterTenant.setEnabled(!usernameInput.isEmpty() && !passwordInput.isEmpty() &&
                    !unitInput.isEmpty() && !blockInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}