package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class quizResultActivity extends AppCompatActivity {
    private Button backToQuiz;
    private Button toShortTerm;
    private Button toHome;
    private TextView scoreText;
    private TextView firstParagraph;
    private TextView secondParagraph;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);
        scoreText = findViewById(R.id.scoreText);

        Bundle extras = getIntent().getExtras();
        int score = extras.getInt("ChosenWords") - 3;

        scoreText.setText(Integer.toString(score));

        backToQuiz =findViewById(R.id.button4);
        backToQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizPage();
            }
        });

        toShortTerm =findViewById(R.id.button52);
        toShortTerm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openShortTermPage();
            }
        });

        toHome =findViewById(R.id.button53);
        toHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePage();
            }
        });

        firstParagraph = findViewById(R.id.textView5);
        firstParagraph.append(getBaseContext().getResources().getString(R.string.firstPart));

        secondParagraph = findViewById(R.id.textView6);
        secondParagraph.append(getBaseContext().getResources().getString(R.string.secondPart));

    }

    public void openHomePage(){
        Intent intent = new Intent(quizResultActivity.this, Home.class);
        startActivity(intent);
    }

    public void openShortTermPage(){
        Intent intent = new Intent(quizResultActivity.this, stmemoryStrategies1.class);
        startActivity(intent);
    }

    public void openQuizPage(){
        Intent intent = new Intent(quizResultActivity.this, QuizHome.class);
        startActivity(intent);
    }


}
