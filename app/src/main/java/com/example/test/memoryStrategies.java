package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class memoryStrategies extends AppCompatActivity {
    private Button buttonStrategies2;
    private Button stStrategies1;
    private Button ltStrategies1;
    private Button internal;
    private Button home;
    private Button prospective;
    private Button external;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_strategies);

        buttonStrategies2 =findViewById(R.id.button14);
        buttonStrategies2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStrategies2Page();
            }
        });

        stStrategies1 =findViewById(R.id.button33);
        stStrategies1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openstStrategies1Page();
            }
        });

        ltStrategies1 =findViewById(R.id.button37);
        ltStrategies1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openltStrategies1Page();
            }
        });

        internal =findViewById(R.id.button42);
        internal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInternalPage();
            }
        });

        home =findViewById(R.id.button44);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomePage();
            }
        });

        prospective =findViewById(R.id.button41);
        prospective.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProspectivePage();
            }
        });

        external =findViewById(R.id.button43);
        external.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openExternalPage();
            }
        });


    }

    public void openStrategies2Page(){
        Intent intent = new Intent(memoryStrategies.this, memoryStrategies2.class);
        startActivity(intent);
    }

    public void openstStrategies1Page(){
        Intent intent = new Intent(memoryStrategies.this, stmemoryStrategies1.class);
        startActivity(intent);
    }

    public void openltStrategies1Page(){
        Intent intent = new Intent(memoryStrategies.this, ltmemoryStrategies1.class);
        startActivity(intent);
    }

    public void openInternalPage(){
        Intent intent = new Intent(memoryStrategies.this, stmemoryStrategies3.class);
        startActivity(intent);
    }

    public void openHomePage(){
        Intent intent = new Intent(memoryStrategies.this, Home.class);
        startActivity(intent);
    }

    public void openProspectivePage(){
        Intent intent = new Intent(memoryStrategies.this, prospectiveMemory1.class);
        startActivity(intent);
    }

    public void openExternalPage(){
        Intent intent = new Intent(memoryStrategies.this, externalMemory1.class);
        startActivity(intent);
    }

}
