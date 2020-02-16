package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class prospectiveMemory3 extends AppCompatActivity {
    TextView TextView;
    private Button memoryStrategies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prospective_memory3);

        TextView = (TextView) findViewById(R.id.textView22);
        String prospective33[] = getBaseContext().getResources().getStringArray(R.array.prospective3);
        int arraySize = prospective33.length;
        for(int i = 0; i < arraySize; i++) {
            TextView.append(prospective33[i]);
            TextView.append("\n\n");
            //potential faade
        }

        memoryStrategies =findViewById(R.id.button47);
        memoryStrategies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMemoryStrategiesPage();
            }
        });
    }

    public void openMemoryStrategiesPage(){
        Intent intent = new Intent(prospectiveMemory3.this, memoryStrategies.class);
        startActivity(intent);
    }

}
