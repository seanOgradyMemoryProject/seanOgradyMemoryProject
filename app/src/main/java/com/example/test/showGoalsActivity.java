package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class showGoalsActivity extends AppCompatActivity {
    private Button Home;
    private DatabaseReference mDatabaseRef;
    private TextView TextView;
    private String userID;
    private String goalString = "";
    private Button deleteGoals;
    private ArrayList<String> goalsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_goals);

        userID = FirebaseAuth.getInstance().getCurrentUser().getUid();

        Home =findViewById(R.id.button55);
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePage();
            }
        });
        TextView = findViewById(R.id.textView27);

        deleteGoals = findViewById(R.id.button56);
        deleteGoals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDeletePage();
            }
        });





        mDatabaseRef = FirebaseDatabase.getInstance().getReference("goals/" + userID);
        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int n = 1;
                for (DataSnapshot snap : dataSnapshot.getChildren()){
                    String goal = snap.getValue().toString();
                    goalString += n + ". " + goal + "\n\n";
                    n++;
                    goalsList.add(goal);
                }
                TextView.setText(goalString);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void openHomePage(){
        Intent intent = new Intent(showGoalsActivity.this, memoryGoals.class);
        startActivity(intent);
    }

    public void openDeletePage(){
        Intent intent = new Intent(showGoalsActivity.this, deleteGoalsActivity.class);
        intent.putExtra("goalsList", goalsList);
        startActivity(intent);
    }



}
