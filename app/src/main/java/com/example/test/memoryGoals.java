package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class memoryGoals extends AppCompatActivity {
    private Button Home;
    private Button Submit;
    private Button showMemoryGoals;
    private EditText memoryGoal;
    private String userID;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        userID = FirebaseAuth.getInstance().getCurrentUser().getUid();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_goals);

        Home =findViewById(R.id.button20);
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePage();
            }
        });

        databaseReference = FirebaseDatabase.getInstance().getReference("goals");

        memoryGoal = findViewById(R.id.editText5);
        Submit = findViewById(R.id.button23);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMemoryGoals();
            }
        });

        showMemoryGoals =findViewById(R.id.button29);
        showMemoryGoals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openshowGoalsPage();
            }
        });
    }


    public void openHomePage(){
        Intent intent = new Intent(memoryGoals.this, Home.class);
        startActivity(intent);
    }

    public void openshowGoalsPage(){
        Intent intent = new Intent(memoryGoals.this, showGoalsActivity.class);
        startActivity(intent);
    }

    public void addMemoryGoals(){
        String memoryGoals = memoryGoal.getText().toString();

        if(!TextUtils.isEmpty(memoryGoals)){
            databaseReference.child(userID).push().setValue(memoryGoals);
            Toast.makeText(memoryGoals.this, "Memory Goal submitted!", Toast.LENGTH_SHORT).show();
        }
    }

}
