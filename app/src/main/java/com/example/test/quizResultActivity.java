package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class quizResultActivity extends AppCompatActivity {
    private Button backToQuiz;
    private Button toShortTerm;
    private Button toHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

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
