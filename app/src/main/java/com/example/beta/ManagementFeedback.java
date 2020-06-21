package com.example.beta;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ManagementFeedback extends AppCompatActivity {
    ListView ListViewFeedback;
    ArrayList<String> feedbackList = new ArrayList<>();
    FirebaseDatabase database;
    DatabaseReference ref;
    Button btnMreturn;
    String mName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management_feedback);

        final ArrayAdapter<String> feedbackAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,feedbackList);
        mName = getIntent().getStringExtra("mName");

        btnMreturn = (Button) findViewById(R.id.btnMreturn);
        ListViewFeedback = (ListView) findViewById(R.id.ListViewFeedback);
        ListViewFeedback.setAdapter(feedbackAdapter);
        database = FirebaseDatabase.getInstance();

        ref = database.getReference().child("Feedback");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String feedback = dataSnapshot.getValue().toString();
                feedbackList.add(feedback);
                feedbackAdapter.notifyDataSetChanged();
            }


            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                feedbackAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btnMreturn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent =(new Intent(ManagementFeedback.this,ManagementHome.class));
                intent.putExtra("mName",mName); //this one is bring data to next page
                startActivity(intent);
                //finish();
            }
        });

    }
}
