package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class deleteGoalsActivity extends AppCompatActivity {
    private Button goBack;
    private Spinner spinner;
    private DatabaseReference mDatabaseRef;
    private String userID;
    private String goalDeletion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_goals);
        userID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("goals/" + userID);

        goBack = findViewById(R.id.button57);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMemoryPage();
            }
        });

        spinner = findViewById(R.id.spinner);

        final ArrayList<String> myList = (ArrayList<String>) getIntent().getSerializableExtra("goalsList");

        myList.add(0, "Select Goal to Delete!");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(deleteGoalsActivity.this, android.R.layout.simple_spinner_item, myList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    goalDeletion = myList.get(position);
                    mDatabaseRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                                String value = snapshot.getValue().toString();
                                if(value.equals(goalDeletion)) {
                                    snapshot.getRef().removeValue();
                                    Toast.makeText(getApplicationContext(), "Goal deleted!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public void openMemoryPage(){
        Intent intent = new Intent(deleteGoalsActivity.this, showGoalsActivity.class);
        startActivity(intent);
    }

}
