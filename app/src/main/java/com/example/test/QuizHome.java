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
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static android.widget.Toast.LENGTH_SHORT;


public class QuizHome extends AppCompatActivity {
    private TextView wordsToRemember;
    private DatabaseReference mDatabaseRef;
    private TextView quizPrompt;
    private TextView firstPrompt;
    private TextView levelCounter;
    private Button quizNext;
    private Spinner spinner;
    private int totalWords;
    private int chosenWords;

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
        levelCounter = findViewById(R.id.levelCounter);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            chosenWords = extras.getInt("ChosenWords");
        }
        else{
            chosenWords = 3;
        }
        levelCounter.setText("Level " + (chosenWords-2));

        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<String> wordsList = new ArrayList<>();
                ArrayList<String> chosenWordsList = new ArrayList<>();


                for (DataSnapshot snap : dataSnapshot.getChildren()){
                    wordsList.add(snap.getValue().toString());
                }

                totalWords = wordsList.size();
                Collections.shuffle(wordsList);


                for(int i = 0; i<chosenWords; i++){
                    chosenWordsList.add(wordsList.get(i));
                }

                int correctAnswer = new Random().nextInt(chosenWords) + 1;

                String quizPromptText = "Please select word number " + correctAnswer;
                quizPrompt.setText(quizPromptText);

                final String correctWord = chosenWordsList.get(correctAnswer-1);

                String words = chosenWordsList.toString()
                        .replace("[","")
                        .replace("]","")
                        .replace(",","")
                        .trim();

                wordsToRemember.setText( words );

                final ArrayList<String> wordsListShuffled = chosenWordsList;
                Collections.shuffle(wordsListShuffled);

                wordsListShuffled.add(0, "Select Answer");

                ArrayAdapter<String> adapter = new ArrayAdapter<>(QuizHome.this,
                        android.R.layout.simple_spinner_item,wordsListShuffled);

                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        if(wordsListShuffled.get(position) == correctWord){
                            Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT).show();
                            nextLevel();
                        }
                        else if(position !=0){
                            Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                            gameOver();
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
                levelCounter.setVisibility(View.INVISIBLE);
                quizNext.setVisibility(View.INVISIBLE);
            }
        });

    }

    public void nextLevel(){

        if(chosenWords < totalWords){
            chosenWords++;
        }

        Intent intent = new Intent(QuizHome.this, QuizHome.class);
        intent.putExtra("ChosenWords", chosenWords);
        startActivity(intent);
    }
    public void gameOver(){
        Intent intent = new Intent(QuizHome.this, quizResultActivity.class);
        intent.putExtra("ChosenWords", chosenWords);
        startActivity(intent);
    }

}