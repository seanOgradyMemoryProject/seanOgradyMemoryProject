package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ltmemoryStrategies3 extends AppCompatActivity {
    android.widget.TextView TextView;
    private Button buttonStrategies2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ltmemory_strategies3);

        TextView = (TextView) findViewById(R.id.textView19);
        String ltStrategy33[] = getBaseContext().getResources().getStringArray(R.array.longTerm3);
        int arraySize = ltStrategy33.length;
        for(int i = 0; i < arraySize; i++) {
            TextView.append(ltStrategy33[i]);
            TextView.append("\n\n");
            //potential faade
        }

        buttonStrategies2 =findViewById(R.id.button40);
        buttonStrategies2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStrategiesPage();
            }
        });
    }

    public void openStrategiesPage(){
        Intent intent = new Intent(ltmemoryStrategies3.this, memoryStrategies.class);
        startActivity(intent);
    }



}
