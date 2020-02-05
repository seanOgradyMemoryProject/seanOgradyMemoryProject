package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity {
    Button btnLogout;
    private Button buttonCalendar;
    private Button buttonLearning;
    private Button buttonStrategies;
    private Button buttonTips;
    private Button buttonGoals;
    private Button buttonGames;
    FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnLogout = findViewById(R.id.button22);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(Home.this, MainActivity.class);
                startActivity(intent);

            }
        });
        //Calendar
        buttonCalendar =findViewById(R.id.button24);
        buttonCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalendarPage();
            }
        });
        //Learn More!
        buttonLearning =findViewById(R.id.button12);
        buttonLearning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLearningPage();
            }
        });

        buttonTips =findViewById(R.id.button17);
        buttonTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTipsPage();
            }
        });

        buttonStrategies =findViewById(R.id.button13);
        buttonStrategies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStrategiesPage();
            }
        });

        buttonGoals =findViewById(R.id.button19);
        buttonGoals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGoalsPage();
            }
        });

        buttonTips =findViewById(R.id.button21);
        buttonTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGamesPage();
            }
        });


    }

    //Go to calendar page
    public void openCalendarPage(){
        Intent intent = new Intent(Home.this, calendar.class);
        startActivity(intent);
    }

    public void openLearningPage(){
        Intent intent = new Intent(Home.this, LearningActivity.class);
        startActivity(intent);
    }

    public void openStrategiesPage(){
        Intent intent = new Intent(Home.this, memoryStrategies.class);
        startActivity(intent);
    }

    public void openTipsPage(){
        Intent intent = new Intent(Home.this, Tips.class);
        startActivity(intent);
    }

    public void openGoalsPage(){
        Intent intent = new Intent(Home.this, memoryGoals.class);
        startActivity(intent);
    }

    public void openGamesPage(){
        Intent intent = new Intent(Home.this, gamesHome.class);
        startActivity(intent);
    }


}
