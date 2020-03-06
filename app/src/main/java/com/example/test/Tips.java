package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class Tips extends AppCompatActivity {
    private Button Home;
    private Button showAll;
    private Button anotherOne;
    TextView TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        Home =findViewById(R.id.button18);
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePage();
            }
        });

        TextView = findViewById(R.id.textView13);
        String tipsy[] = getBaseContext().getResources().getStringArray(R.array.tipsy);
        int randomIndex = new Random().nextInt(tipsy.length);
        String randomTip = tipsy[randomIndex];
        TextView.setText(randomTip);

        showAll = findViewById(R.id.button27);
        showAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openshowAllPage();
            }
        });

        anotherOne = findViewById(R.id.button54);
        anotherOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openReloadPage();
            }
        });

    }

    public void openHomePage(){
        Intent intent = new Intent(Tips.this, Home.class);
        startActivity(intent);
    }

    public void openshowAllPage(){
        Intent intent = new Intent(Tips.this, showAllActivity.class);
        startActivity(intent);
    }

    public void openReloadPage(){
        Intent intent = new Intent(Tips.this, Tips.class);
        startActivity(intent);
    }

}