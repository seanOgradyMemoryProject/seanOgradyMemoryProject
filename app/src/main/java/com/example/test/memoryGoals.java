package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class memoryGoals extends AppCompatActivity {
    private Button Home;

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
    }


    public void openHomePage(){
        Intent intent = new Intent(memoryGoals.this, Home.class);
        startActivity(intent);
    }

}
