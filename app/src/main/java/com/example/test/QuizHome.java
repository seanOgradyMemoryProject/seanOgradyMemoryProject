package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;


public class QuizHome extends AppCompatActivity {
    private TextView wordsToRemember;
    private DatabaseReference mDatabaseRef;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_home);
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("quiz/short_term/words");


        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<String> wordsList = new ArrayList<>();

                for (DataSnapshot snap : dataSnapshot.getChildren()){
                    wordsList.add(snap.getValue().toString());
                }

                String words = wordsList.toString()
                        .replace("[","")
                        .replace("]","")
                        .replace(",","")
                        .trim();

                wordsToRemember.setText( words );

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        wordsToRemember = findViewById(R.id.wordsToRemember);
    }
}
