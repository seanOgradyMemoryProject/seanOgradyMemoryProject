package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class gamesHome extends AppCompatActivity {
    private Button Home;
    private Button toQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_home);

        Home =findViewById(R.id.button26);
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePage();
            }
        });

        toQuiz =findViewById(R.id.button25);
        toQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizHomePage();
            }
        });

    }


    public void openHomePage(){
        Intent intent = new Intent(gamesHome.this, Home.class);
        startActivity(intent);
    }

    public void openQuizHomePage(){
        Intent intent = new Intent(gamesHome.this, QuizHome.class);
        startActivity(intent);
    }


}
