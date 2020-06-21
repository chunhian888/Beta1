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

public class ManagementRegister extends AppCompatActivity {
    EditText txtMUsername, txtMPassword, txtMLocation, txtMName;
    Button btnRegisterManagement;
    private Management management;
    FirebaseDatabase database;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management_register);

        txtMUsername = (EditText) findViewById(R.id.txtMUsername);
        txtMPassword = (EditText) findViewById(R.id.txtMPassword);
        txtMLocation = (EditText) findViewById(R.id.txtMLocation);
        txtMName = (EditText) findViewById(R.id.txtMName);
        btnRegisterManagement = (Button) findViewById(R.id.btnRegisterManagement);
        management = new Management();
        database = FirebaseDatabase.getInstance();
        ref = database.getReference().child("Management");

        txtMUsername.addTextChangedListener(registerManagement);
        txtMPassword.addTextChangedListener(registerManagement);
        txtMLocation.addTextChangedListener(registerManagement);
        txtMName.addTextChangedListener(registerManagement);

        btnRegisterManagement.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                    management.setMUsername(txtMUsername.getText().toString());
                    management.setMPassword(txtMPassword.getText().toString());
                    management.setMLocation(txtMLocation.getText().toString());
                    management.setMName(txtMName.getText().toString());
                    ref.child(management.getMUsername()).setValue(management);

                    Toast.makeText(ManagementRegister.this, "Successfully registered", Toast.LENGTH_LONG).show();

                    startActivity(new Intent(ManagementRegister.this, MainActivity.class));
                    finish();
            }
        });
    }
    private TextWatcher registerManagement = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String usernameInput = txtMUsername.getText().toString().trim();
            String passwordInput = txtMPassword.getText().toString().trim();
            String locationInput = txtMLocation.getText().toString().trim();
            String nameInput = txtMName.getText().toString().trim();

            btnRegisterManagement.setEnabled(!usernameInput.isEmpty() && !passwordInput.isEmpty() &&
            !locationInput.isEmpty() && !nameInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
