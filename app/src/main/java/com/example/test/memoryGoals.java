package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class memoryGoals extends AppCompatActivity {
    private Button Home;
    private Button Submit;
    private EditText memoryGoal;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
    }


    public void openHomePage(){
        Intent intent = new Intent(memoryGoals.this, Home.class);
        startActivity(intent);
    }

    public void addMemoryGoals(){
        String memoryGoals = memoryGoal.getText().toString();

        if(!TextUtils.isEmpty(memoryGoals)){
            String id = databaseReference.push().getKey();
            Users goals = new Users(id);
            databaseReference.child(id).setValue(goals);
            Toast.makeText(memoryGoals.this, "Memory Goal submitted!", Toast.LENGTH_SHORT).show();
        }
    }

}
