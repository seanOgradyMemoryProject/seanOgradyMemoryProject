package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class memoryStrategies5 extends AppCompatActivity {
    TextView TextView;
    private Button memstrat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_strategies5);

        memstrat = findViewById(R.id.button32);
        memstrat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMemstratsPage();
            }
        });


        TextView = findViewById(R.id.textView11);
        String attention44[] = getBaseContext().getResources().getStringArray(R.array.attention4);
        int arraySize = attention44.length;
        for (int i = 0; i < arraySize; i++) {
            TextView.append(attention44[i]);
            TextView.append("\n\n");
            //potential faade
        }



    }

    public void openMemstratsPage(){
        Intent intent = new Intent(memoryStrategies5.this, memoryStrategies.class);
        startActivity(intent);
    }




}
