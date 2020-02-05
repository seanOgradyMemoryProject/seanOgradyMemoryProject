package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class memoryStrategies3 extends AppCompatActivity {
    private Button Home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_strategies3);

        Home =findViewById(R.id.button16);
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePage();
            }
        });

    }

    public void openHomePage(){
        Intent intent = new Intent(memoryStrategies3.this, Home.class);
        startActivity(intent);
    }



}
