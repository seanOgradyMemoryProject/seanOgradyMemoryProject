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
import java.util.Random;

import static android.widget.Toast.LENGTH_SHORT;


public class QuizHome extends AppCompatActivity {
    private TextView wordsToRemember;
    private DatabaseReference mDatabaseRef;
    private TextView quizPrompt;
    private TextView firstPrompt;
    private Button quizNext;
    private Spinner spinner;
    private int totalWords = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_home);
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("quiz/short_term/words");
        quizPrompt = findViewById(R.id.quizPrompt);
        quizNext= findViewById(R.id.button51);
        wordsToRemember = findViewById(R.id.wordsToRemember);
        firstPrompt = findViewById(R.id.textView12);
        spinner = findViewById(R.id.quizSpinner);

        final int correctAnswer = new Random().nextInt(totalWords) + 1;
        String quizPromptText = "Please select word number " + correctAnswer;
        quizPrompt.setText(quizPromptText);

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

                wordsList.add(0, "Select Answer");


                ArrayAdapter<String> adapter = new ArrayAdapter<>(QuizHome.this,
                        android.R.layout.simple_spinner_item,wordsList);

                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        if(position == correctAnswer){
                            Toast.makeText(getApplicationContext(), "" + id, Toast.LENGTH_SHORT).show();
                        }
                        else if(position !=0){
                            Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        quizNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizPrompt.setVisibility(View.VISIBLE);
                wordsToRemember.setVisibility(View.INVISIBLE);
                firstPrompt.setVisibility(View.INVISIBLE);
                spinner.setVisibility(View.VISIBLE);
            }
        });

    }
}